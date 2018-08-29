package com.luxsoft.lx.cxp

import groovy.transform.EqualsAndHashCode
import com.luxsoft.lx.core.Empresa
import com.luxsoft.lx.core.Proveedor
import com.luxsoft.lx.core.Autorizacion
import com.luxsoft.lx.tesoreria.Pago
import com.luxsoft.lx.core.FormaDePago

@EqualsAndHashCode(includes='empresa,proveedor,id')
class Requisicion {

	Empresa empresa

	Proveedor proveedor

	String aFavor

	Long folio

	Date pago

    FormaDePago formaDePago

	Autorizacion autorizacion

	String tipo

	BigDecimal total=0.0
	
	String comentario

	Date dateCreated
	Date lastUpdated

	static hasMany = [partidas: RequisicionDet]

    static constraints = {
    	folio unique: 'empresa'
    	comentario nullable:true
    	autorizacion nullable:true
    	tipo inList:['GASTO','COMPRA','HONORARIOS','GASTO_POR_COMPROBAR'],maxSize:50
    	total scale:4
    	aFavor nullable:true
        formaDePago nullable:true
    }

    static mapping = {
    	partidas cascade: "all-delete-orphan"
    	pago type:'date'
        
    }

    String toString(){
    	return "Folio:$folio Proveedor:${proveedor?.nombre} Total:${total}"
    }


}
