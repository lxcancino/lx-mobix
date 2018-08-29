package com.luxsoft.cfdi

import groovy.transform.ToString
import java.io.ByteArrayInputStream


@ToString(includeNames=true,includes="id,serie,folio,tipo,fecha,uuid")
class Cfdi {
	
	String serie
	String folio
	String uuid
	Date timbrado
	String tipo
	Date fecha
	String emisor
	String emisorRfc
	String receptor
	String receptorRfc
	
	BigDecimal total
	
	String cadenaOriginal
	//String origen
	String xmlName
	byte[] xml

	byte[] acuse
	String acuseEstado
	String acuseCodigoEstatus
	String grupo
	String referencia
	
	Date dateCreated
	Date lastUpdated

	String creadoPor
	String modificadoPor

	String versionCfdi = '3.2'
	
	
	
	String comentario

	static hasOne = [cancelacion: CancelacionDeCfdi]

    static constraints = {
		serie blannk:false,maxSize:15
		folio blank:false,maxSize:20
		uuid nullable:true,maxSize:300
		timbrado(nullable:true)
		tipo inList:['INGRESO','EGRESO','TRASLADO','PAGO','NOMINA']
		fecha nullable:false
		emisor blank:false,maxSize:600
		emisorRfc blank:false,maxSize:13
		receptor blank:false,maxSize:600
		receptorRfc blank:false,maxSize:13
		xmlName nullable:true,maxSize:200
		xml maxSize:(1024 * 512)  // 50kb para almacenar el xml
		cadenaOriginal maxSize:1024*64, nullable:true 
		//origen blank:false,maxSize:255
		cancelacion nullable:true
		creadoPor maxSize:50
		modificadoPor maxSize:50
		acuse nullable:true,maxSize:(1024*256)
		acuseEstado nullable:true
		acuseCodigoEstatus nullable:true
		grupo nullable:true,maxSize:20
		comentario nullable:true,maxSize:100
		versionCfdi inList: ['3.2','3.3']
    }
	
	//static transients = ['comprobanteDocument','timbreFiscal']
	
	public Cfdi() {}
	
	public Cfdi(def c) {
		serie=c.serie
		folio=c.folio
		fecha=c.fecha.getTime()
		emisor=c.emisor.nombre
		emisorRfc=c.emisor.rfc
		receptor=c.receptor.nombre
		receptorRfc=c.receptor.rfc
		total=c.total
		versionCfdi = c.version
	}
	
	
	String toString(){
		return "($emisor) Id:$id  Tipo:$tipo Serie:$serie Folio:$folio  UUID:$uuid xmlName:$xmlName"
	}

	
}
