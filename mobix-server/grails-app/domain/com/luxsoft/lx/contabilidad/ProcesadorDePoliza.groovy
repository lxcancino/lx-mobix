package com.luxsoft.lx.contabilidad

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode


@ToString(includes='nombre,service',includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='nombre')
class ProcesadorDePoliza {

	String nombre
    String tipo = 'DIARIO'
	String descripcion
	String service
    String label
    int orden = 0


    static constraints = {
    	nombre maxSize:50,unique:true
    	descripcion nullable:true
    	service nullable:true,maxSize:100
        tipo(inList:['INGRESO','EGRESO','DIARIO'])
    }
    
    def beforeInsert() {
        if(!label)
            label=nombre.capitalize()
        if(!descripcion)
            descripcion=nombre.capitalize()

    }

    
}
