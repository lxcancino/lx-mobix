package com.luxsoft.lx.af


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.Sortable

@EqualsAndHashCode(includes='activo,ejercicio,mes')
@ToString(excludes='dateCreated,lastUpdated',includeNames=true,includePackage=false)
@Sortable(includes=['ejercicio','mes'])
class Depreciacion {

	Integer ejercicio

	Integer mes

	BigDecimal depreciacion

	Date dateCreated
	Date lastUpdated

    static constraints = {
    	
    }

    static belongsTo = [activo: ActivoFijo]
}
