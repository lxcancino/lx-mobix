package com.luxsoft.cfdi.retenciones


import javax.xml.XMLConstants
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller
import javax.xml.validation.Schema
import javax.xml.validation.SchemaFactory
import javax.xml.transform.Source
import javax.xml.transform.stream.StreamSource
import org.springframework.context.ResourceLoaderAware
import org.springframework.core.io.ResourceLoader
import org.bouncycastle.util.encoders.Base64
import com.luxsoft.lx.core.Empresa

import com.luxsoft.cfdi.retenciones.dividendos.Dividendos



class RetencionesBuilder implements ResourceLoaderAware{


	def resourceLoader

	def cadenaBuilder

	def retencionSellador

	
	def retencionesTibrador

	public toRetenciones(CfdiRetenciones bean){

		ObjectFactory factory=new ObjectFactory();
		Retenciones retenciones=factory.createRetenciones();
		retenciones.setVersion("1.0");

		
		//Emisor
		def emisor=new Retenciones.Emisor(rfcEmisor:bean.emisorRfc,nomDenRazSocE:bean.emisor)
		retenciones.setEmisor(emisor)

		//Receptor
		def receptor=new Retenciones.Receptor(nacionalidad:bean.receptorNacionalidad)
		if(bean.receptorNacionalidad=='Nacional'){
		    def nacional=new Retenciones.Receptor.Nacional(rfcRecep:bean.receptorRfc,nomDenRazSocR:bean.receptor,curpr:bean.receptorCurp)
		    receptor.setNacional(nacional)
		}else{
		    def extranjero=new Retenciones.Receptor.Extranjero(numRegIdTrib:bean.receptorRegistroTributario,nomDenRazSocR:bean.receptor)
		    receptor.setExtranjero(extranjero)
		}
		retenciones.setReceptor(receptor)
		
		//Periodo
		def periodo=new Retenciones.Periodo(mesIni:bean.mesInicial,mesFin:bean.mesFinal,ejerc:bean.ejercicio)
		retenciones.setPeriodo(periodo)

		//Totales
		def totales=new Retenciones.Totales(
			montoTotOperacion:bean.total,
			montoTotGrav:bean.totalGravado,
			montoTotExent:bean.totalExcento,
			montoTotRet:bean.totalRetenido)

		bean.impuestosRetenidos.each{
			Retenciones.Totales.ImpRetenidos r=new Retenciones.Totales.ImpRetenidos(
				baseRet:it.baseRet,
				impuesto:it.impuesto.clave,
				montoRet:it.montoRet,
				tipoPagoRet:it.tipoPagoRet
			)
			totales.getImpRetenidos().add(r)
		}
		retenciones.setFolioInt(bean.id.toString())
		retenciones.fechaExp=bean.fecha
		retenciones.cveRetenc=bean.tipoDeRetencion.clave
		if(retenciones.cveRetenc=='25'){
			retenciones.descRetenc=bean.retencionDescripcion
		}

		retenciones.setTotales(totales)

		/** COMPLEMENTO **/
		if (bean.cveTipDivOUtil) {
			Retenciones.Complemento complemento = factory.createRetencionesComplemento()

			Dividendos dividendos = factory.createDividendos()
			dividendos.setVersion("1.0");
			
			Dividendos.DividOUtil dividOUtil = factory.createDividendosDividOUtil()
			dividendos.dividOUtil = dividOUtil

			dividOUtil.cveTipDivOUtil = bean.cveTipDivOUtil
			dividOUtil.montISRAcredRetMexico = bean.montoISRAcredRetMexico
			dividOUtil.tipoSocDistrDiv = 'Sociedad Nacional'

			// dividOUtil.setMontISRAcredRetMexico(bean.montoISRAcredRetMexico)
			dividOUtil.montISRAcredRetExtranjero = 0.0
			dividOUtil.montISRAcredNal = bean.montoISRAcredRetMexico
			dividOUtil.montDivAcumNal = bean.montoDivAcumNal

			complemento.getAny().add(dividendos)
			retenciones.setComplemento(complemento)
		}

		return retenciones
	}

	private getSchema() {
		/*
		def is=resourceLoader.getResource("/WEB-INF/sat/retencionpagov1.xsd").getInputStream()
		SchemaFactory sf=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema=sf.newSchema(new StreamSource(is))
		return schema
		*/
		
		Source schema1 = new StreamSource("http://www.sat.gob.mx/esquemas/retencionpago/1/retencionpagov1.xsd")
        Source schema2 = new StreamSource("http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos/dividendos.xsd")
		Source[] schemas = [schema1, schema2]
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
		Schema schema =  sf.newSchema(schemas)
		return schema
		
	}

	public buildXml(CfdiRetenciones bean){
		def retenciones=toRetenciones(bean)
		JAXBContext jc=JAXBContext.newInstance(Retenciones.class);
		Marshaller marshaller=jc.createMarshaller();
		marshaller.setSchema(getSchema());
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
			"http://www.sat.gob.mx/esquemas/retencionpago/1 http://www.sat.gob.mx/esquemas/retencionpago/1/retencionpagov1.xsd http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos/dividendos.xsd");

		def empresa = Empresa.findByRfc(bean.emisorRfc)
		assert empresa

		retenciones.setNumCert(empresa.numeroDeCertificado)
		byte[] encodedCert=Base64.encode(empresa.getCertificado().getEncoded())
		retenciones.setCert(new String(encodedCert))
		
		//Sello digital
		String cadenaOriginal=cadenaBuilder.generarCadena(retenciones)
		def sello=retencionSellador.sellar(empresa.privateKey,cadenaOriginal)
		retenciones.setSello(sello)
		
		//Output
    	ByteArrayOutputStream out=new ByteArrayOutputStream()
    	marshaller.marshal(retenciones,out)

    	bean.xml=out.toByteArray()
    	bean.xmlName="CFDI_RETENCION_${bean.emisorRfc}_${bean.id.toString()}.xml"
    	
    	bean.save failOnError:true

    	return bean


	}

	void setResourceLoader(ResourceLoader resourceLoader){
		this.resourceLoader=resourceLoader
	}
}