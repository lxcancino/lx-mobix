package com.luxsoft.lx.tesoreria

import com.luxsoft.lx.core.Empresa

class SaldoPorCuentaBancaria {

	Empresa empresa

	CuentaBancaria cuenta

	BigDecimal saldoInicial

	BigDecimal ingresos

	BigDecimal egresos

	BigDecimal saldoFinal

	Integer ejercicio

	Integer mes

	Date cierre
	
	Date dateCreated
	Date lastUpdated

    static constraints = {
    	ejercicio inList:(2014..2018)
    	mes inList:(1..12)
    	cuenta unique:['empresa','ejercicio','mes']
		cierre(nullable:true)
		

    }

    
}
