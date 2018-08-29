package com.luxsoft.lx.cxc

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import com.luxsoft.lx.utils.MonedaUtils
import com.luxsoft.lx.core.Cliente
import com.luxsoft.lx.core.Empresa
import com.luxsoft.cfdi.Cfdi
import com.luxsoft.lx.ventas.Venta

@EqualsAndHashCode(includes='venta')
@ToString(includes='venta,saldo',includeNames=true,includePackage=false)
class CuentaPorCobrar {
	
	Empresa empresa

	Cliente cliente

	Venta venta
	
	Cfdi cfdi

	Date fecha

	String comentario

    Currency moneda
    BigDecimal tc

    BigDecimal importe
    BigDecimal impuestoTasa=16
    BigDecimal impuesto
    BigDecimal total

    
	BigDecimal saldo
	BigDecimal pagos
	BigDecimal abonos

	Date dateCreated
	Date lastUpdated

	public CuentaPorCobrar(){}

	public CuentaPorCobrar(Venta venta){
		this.empresa=venta.empresa
		this.cliente=venta.cliente
		this.venta=venta
		this.cfdi=venta.cfdi
		this.fecha=venta.cfdi.fecha
		this.comentario=venta.comentario
        this.moneda=venta.moneda
        this.tc=1.0
        this.impuestoTasa=venta.impuestoTasa
        this.importe=venta.subTotal
        this.impuesto=venta.impuesto
        this.total=venta.total
	}

    static constraints = {

    }

    static transients = ['pagos','abonos']

    //static hasMany = [aplicaciones: AplicacionDeCobro]

    static mappings = {
		fecha type: 'date'
	}

    def getPagos(){
    	if(!pagos){
    		pagos=0.0
    	}
    	return pagos
    }

    def getAbonos(){
    	if(!abonos){
    		abonos=0.0
    	}
    	return abonos
    }

}
