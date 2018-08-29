package com.luxsoft.mobix.core

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

import com.luxsoft.lx.core.Direccion
import com.luxsoft.lx.core.Empresa
import com.luxsoft.lx.core.Producto

@ToString(excludes='dateCreated,lastUpdated',includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='cuentaPredial')
class Inmueble {

	String clave

	String descripcion
	
	String cuentaPredial
	
	Empresa empresa

	Direccion direccion

	Date dateCreated

	Date lastUpdated

    static constraints = {
    	clave maxSize:40,unique:['empresa']
    	descripcion blank:false
    }

    static embedded = ['direccion']
}
