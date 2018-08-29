package com.luxsoft.lx.contabilidad

import com.luxsoft.lx.core.Empresa

class CierreContable {

	Empresa empresa
	Integer ejercicio
	Integer mes
	String tipo='CIERRE_MENSUAL'

	Date dateCreated
	Date lastUpdated
	String creadoPor
	String modificadoPor

    static constraints = {
    	ejercicio inList:(2014..2018)
    	mes inList:(1..13),unique:['empresa','ejercicio']
    	tipo(inList:['CIERRE_ANUAL','CIERRE_MENSUAL'])
    }

    String toString(){
    	"$tipo $ejercicio $mes $empresa"
    }
}
