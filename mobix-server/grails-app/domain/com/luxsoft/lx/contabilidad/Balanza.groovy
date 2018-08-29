package com.luxsoft.lx.contabilidad

import com.luxsoft.lx.core.Empresa

class Balanza {

	Empresa empresa

	Integer ejercicio
	Integer mes

	Date dateCreated
	Date lastUpdated

	static hasMany = [partidas: BalanzaDet]

    static constraints = {
    	ejercicio inList:(2015..2018)
		mes inList:(1..13)
		empresa unique:['ejercicio','mes']
    }

    static mapping = {
		partidas cascade: "all-delete-orphan"
	}

	String toString(){
		return "Balanza de comprobacion ${empresa.nombre} ${empresa.mes} / ${empresa.ejercicio}"
	}
}

