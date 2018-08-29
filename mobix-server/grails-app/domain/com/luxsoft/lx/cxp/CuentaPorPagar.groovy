package com.luxsoft.lx.cxp


import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode


import com.luxsoft.lx.core.Proveedor
import com.luxsoft.lx.core.Empresa
import com.luxsoft.lx.utils.MonedaUtils
import com.luxsoft.lx.tesoreria.AplicacionDePago

@ToString(includes='proveedor,uuid,serie,folio',includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='id')
class CuentaPorPagar {
	
	Empresa empresa
	Proveedor proveedor

	Date fecha

	Date vencimiento

	Currency moneda=Currency.getInstance('MXN')
	BigDecimal tipoDeCambio=1.0

	//Importes
	BigDecimal importe=0.0
	BigDecimal descuento=0.0
	BigDecimal subTotal=0.0

	BigDecimal impuestoTasa=MonedaUtils.IVA
	BigDecimal impuesto=0.0

	BigDecimal retensionIvaTasa=0
	BigDecimal retensionIva=0
	BigDecimal retensionIsrTasa=0
	BigDecimal retensionIsr=0
	
	BigDecimal total=0
	
	// Requisicion
	BigDecimal requisitado=0
	BigDecimal pendienteRequisitar=0

	//Saldo
	BigDecimal pagosAplicados=0
	
	BigDecimal totalMN=0
	BigDecimal saldoActual=0
	BigDecimal saldoAlCorte=0

	//Datos de CFDI...
	String versionCfdi
	byte[] cfdiXml
	String cfdiXmlFileName
	String uuid
	String serie
	String folio
	Boolean gastoPorComprobar = true

	byte[] acuse
	String acuseEstado
	String acuseCodigoEstatus

	String comentario

	Date dateCreated
	Date lastUpdated
	String creadoPor
	String modificadoPor	

    static constraints = {
		tipoDeCambio(scale:6)
		
		importe(scale:4)
		descuento(scale:4)
		subTotal(scale:4)

		impuesto(scale:4)
		total(scale:4)
		retensionIsr(scale:4)
		retensionIva(sacle:4)
		
		comentario(nullable:true)
    	uuid nullable:true,maxSize:40,unique:true
    	serie nullable:true,maxSize:20
    	folio nullable:true,maxSize:40
    	cfdiXmlFileName nullable:true,maxSize:200
		cfdiXml nullable:true,maxSize:(1024 * 512)  // 50kb para almacenar el xml
		acuse nullable:true,maxSize:(1024*256)
		acuseEstado nullable:true,maxSize:100
		acuseCodigoEstatus nullable:true,maxSize:100
		gastoPorComprobar nullable:true
		versionCfdi nullable:true,maxSize:10
		
    }
	
	static mapping ={
		//proveedor fetch:'join'
		requisitado formula:'(select ifnull(sum(x.requisitado),0) from requisicion_det x where x.cuenta_por_pagar_id=id)'
		pagosAplicados formula:'(select ifnull(sum(x.importe),0) from aplicacion_de_pago x where x.cuenta_por_pagar_id=id)'
		pagosAplicados formula:'(select ifnull(sum(x.importe),0) from aplicacion_de_pago x where x.cuenta_por_pagar_id=id)'
		
		fecha type:'date'
		vencimiento type:'date'
	}
	
	//static transients = ['pendienteRequisitar','saldoActual','saldoAlCorte','pagosAplicados']
	static transients = ['pendienteRequisitar','saldoActual','saldoAlCorte','saldo']
	
	
	
	
	BigDecimal getTotalMN(String property){
		return "${property}"*tc
		
	}
	
	public BigDecimal getPendienteRequisitar(){
		def req=requisitado?:0.0
		return total-req
	}
	
	public BigDecimal getSaldoActual(){
		def pag=pagosAplicados?:0.0
		return total-pag
	}

	public BigDecimal getSaldo(){
		return getSaldoActual()
	}

	public BigDecimal buscarSaldoAlCorte(Date corte){
		def found=AplicacionDePago.executeQuery(
			"select sum(a.importe) from AplicacionDePago a where a.cuentaPorPagar=? and date(a.fecha)<=?",[this,corte])
    	def aplicado=found[0]?:0.0
    	def saldo=this.total-aplicado
    	return saldo
	}
	
}
