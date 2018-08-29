package com.luxsoft.lx.core

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import com.luxsoft.lx.contabilidad.CuentaContable

@ToString(includes='nombre,rfc',includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='nombre,rfc')
class Proveedor {

	String nombre
	Direccion direccion
	
	String rfc='XAXX010101000'
	boolean nacional=false
	
	
    String email
	String www	
	CuentaContable cuentaContable
	String subCuentaOperativa

	//Map productos
    	
	Date dateCreated
	Date lastUpdated
	Empresa empresa
    	
	static embedded = ['direccion']
	
	
	
    static constraints = {
		nombre(minSize:3,maxSize:255,unique:['empresa'])
		rfc(minSie:12,maxSize:13)
		email(nullable:true,email:true)
		www(nullable:true,url:true)
		direccion(nullable:true)
		cuentaContable(nullable:true)
		subCuentaOperativa nullable:true,maxSize:4, minSie:4
    }
    	
    String toString(){
    	return nombre
    }
	
    	
    //static hasMany = [productos:Producto]

	static mapping = {
		//productos cascade: "all-delete-orphan"
	}
}
