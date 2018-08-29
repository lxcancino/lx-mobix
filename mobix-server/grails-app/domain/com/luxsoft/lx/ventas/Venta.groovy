package com.luxsoft.lx.ventas

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import com.luxsoft.lx.utils.MonedaUtils
import com.luxsoft.lx.core.Cliente
import com.luxsoft.lx.core.Empresa
import com.luxsoft.cfdi.Cfdi


@EqualsAndHashCode(includes='cliente,empresa,folio')
@ToString(includes='cliente,folio,fecha,tipo,total',includeNames=true,includePackage=false)
//@Resource
class Venta {

	Empresa empresa

	Cliente cliente

	Date fecha

	String tipo

	Long folio

	Currency moneda =MonedaUtils.PESOS
	
	String formaDePago='NO DEFINIDO'

	String cuentaDePago

	String status

	List partidas=[]

	BigDecimal importe=0.0

	BigDecimal descuento=0.0

	BigDecimal subTotal=0.0

	BigDecimal impuesto=0.0

	BigDecimal impuestoTasa=16

	BigDecimal total=0

	BigDecimal saldo=0

	BigDecimal pagos=0

	//BigDecimal abonos=0
	
	Cfdi cfdi
	
	String usoCfdi = 'G03'
	String metodoDePago = 'PPD'
	

	String comentario

	Date dateCreated
	Date lastUpdated

	String creadoPor

	String modificadoPor

	Boolean cancelada=false

	
	static hasMany = [partidas: VentaDet]

    static constraints = {
    	tipo inList:['ARRENDAMIENTO','NORMAL','SERVICIOS','VENTA_ACTIVO']
    	formaDePago maxSize:20,blank:false
		comentario nullable:true
		creadoPor nullalbe:true
		modificadoPor nullalble:true
		cfdi nullable: true
		cuentaDePago nullable:true,maxSize:6
		usoCfdi nullable: true
		metodoDePago nullable: true, maxSize:3, minSize:3

    }

    static mapping = {
		partidas cascade: "all-delete-orphan"
		//saldo formula: 'total - pagos-abonos'
		pagos formula:'(select ifnull(sum(x.importe),0) from aplicacion_de_cobro x where x.cuenta_por_cobrar_id=id)'
		//abonos formula:'(select ifnull(sum(x.total),0) from CXCAplicacion x where x.factura_id=id)'
		fecha type: 'date'
	}

	static transients = ['status','saldo']

	
	def actualizarImportes(){
		partidas*.actualizarImportes()
		importe=partidas.sum 0.0,{it.importeBruto}
		descuento=partidas.sum 0.0,{it.descuento}
		subTotal=partidas.sum 0.0,{it.importeNeto}
		impuesto=partidas.sum 0.0,{it.impuesto}
		total=subTotal+impuesto
		return this
	}
	

	def getSaldo(){
		return total-pagos
	}
	

	def getSubTotalSinIva(){
        return MonedaUtils.calcularImporteDelTotal(subTotal)
    }

    def getDescuentoSinIva(){
    	return MonedaUtils.calcularImporteDelTotal(descuento)
    }

    def getStatus(){
    	if(cfdi)
    		return 'FACTURADA'
    	else 
    		return 'PEDIDO'
    }
	
	
}

