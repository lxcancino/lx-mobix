package com.luxsoft.lx.cxc


import com.luxsoft.lx.ventas.Venta
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import com.luxsoft.lx.ventas.Venta
import com.luxsoft.cfdi.Cfdi


@EqualsAndHashCode(includes='cuentaPorCobrar,fecha,importe,comentario')
@ToString(includes='cuentaPorCobrar,fecha,comentario',includeNames=true,includePackage=false)
class AplicacionDeCobro {

	Venta cuentaPorCobrar 


	Date fecha

	BigDecimal importe

	String comentario

	Cfdi cfdiCobro

	static belongsTo = [pago: Cobro]

    static constraints = {
    	comentario nullable: true
    	cfdiCobro nullable: true
    }

    static mapping = {
		fecha type:'date'
		
	}
    
}
