package com.luxsoft.lx.tesoreria

import com.luxsoft.lx.core.FormaDePago
import com.luxsoft.lx.cxp.Requisicion
import com.luxsoft.lx.sat.BancoSat


class Pago extends MovimientoDeCuenta{

	Requisicion requisicion

	FormaDePago formaDePago

	String aFavor

	String rfc

	Cheque cheque

	BancoSat bancoDestino

    String cuentaDestino

	static hasMany = [aplicaciones: AplicacionDePago]

	//static hasOne = [cheque: Cheque]


    static constraints = {
    	formaDePago inList:[FormaDePago.TRANSFERENCIA,FormaDePago.CHEQUE,FormaDePago.EFECTIVO]
    	//cheque nullable:true
    	aFavor nullable:true
    	rfc nullable:true,maxSize:13
    	bancoDestino nullable:true
    	cuentaDestino nullable:true
    }
    
    static embedded = ['autorizacion']

    static mapping = {
		aplicaciones cascade: "all-delete-orphan"
		//cheque formula:'(select max(x) from Cheque x where x.egreso_id=id and x.cancelacion is null)'
		
	}

	static transients = ['cheque']

    String toString(){
		return "$formaDePago Folio:$folio ${cuenta?.numero}   ${importe}"
	}

	BigDecimal getAplicado(){
		if(aplicaciones==null)
			return 0.0
		return aplicaciones.sum(0.0,{it.importe})
	}

	BigDecimal getDisponible(){
		return  importe.abs()-getAplicado()
	}

	Cheque getCheque(){
		return Cheque.find("from Cheque c where c.egreso=? and c.cancelacion=null",this)
	}

	
}
