package com.luxsoft.lx.cxp


import groovy.transform.EqualsAndHashCode


@EqualsAndHashCode(includes='cuentaPorPagar,requisitado,comentario')
class RequisicionDet {

	CuentaPorPagar cuentaPorPagar
	BigDecimal requisitado
	String comentario

    static constraints = {
    	comentario nullable:true
    }

    
    static belongsTo = [requisicion: Requisicion]

    String toString(){
    	return "CxP: ${cuentaPorPagar?.id} ${cuentaPorPagar?.total}"
    }
}
