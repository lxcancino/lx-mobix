package com.luxsoft.lx.tesoreria

class Cheque {

	CuentaBancaria cuenta
	Integer folio
	Date impresion
	//Pago egreso
	Date cancelacion
	String comentarioCancelacion

	Date dateCreated
	Date lastUpdated

	String creadoPor
	String modificadoPor

    static constraints = {
    	egreso(nullable:false,validator:{val,object->
			if(val.cuenta.tipo!='CHEQUES'){
				return 'tipoDeEgreso'
			}
		})
		impresion(nullable:true)
		cancelacion nullable:true
		comentarioCancelacion nullable:true
		folio min:1
    }

    static belongsTo = [egreso: Pago]
   
}
