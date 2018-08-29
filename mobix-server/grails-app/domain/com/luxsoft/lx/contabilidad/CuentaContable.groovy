package com.luxsoft.lx.contabilidad

import com.luxsoft.lx.sat.*
import groovy.transform.EqualsAndHashCode
import com.luxsoft.lx.core.Empresa

@EqualsAndHashCode(includes='id,clave,descripcion')
class CuentaContable implements Comparable{

	Empresa empresa

	String clave
	String descripcion
	String tipo
	String subTipo
	CuentaContable padre
	Integer nivel=1
	boolean detalle=false
	boolean deResultado=false
	String naturaleza
	
	CuentaSat cuentaSat

	Boolean suspendida = false

	Date dateCreated
	Date lastUpdated
    	
	static hasMany = [subCuentas:CuentaContable]

    static constraints = {
		clave blank:false,maxSize:100 ,unique:['empresa']
		descripcion(blank:false,maxSize:300)
		detalle(nullable:false)
		tipo(nullable:false,inList:['ACTIVO','PASIVO','CAPITAL','ORDEN'])
		subTipo(nullable:true,inList:['CIRCULANTE','FIJO','DIFERIDO','CORTO PLAZO','CAPITAL','ORDEN'])
		naturaleza(inList:['DEUDORA','ACREEDORA','MIXTA'])
		cuentaSat nullable:true
		nivel inList:[1,2,3,4]
		//padre nullable:true
		// padre nullable:true,validator:{val,obj ->
		// 	if(obj.detalle) return 'subCuentasNoPermitidas'
		// 	return true
		// }
		
    }
    	
	static mapping ={
		subCuentas cascade: "all-delete-orphan"
	}
    	
	String toString(){
		return clave+" "+descripcion
	}
    	
	static CuentaContable buscarPorClave(String clave){
		return CuentaContable.findByClave(clave)
	}

	static CuentaContable buscarPorClave(def empresa,def clave){
		def found = CuentaContable.findByEmpresaAndClave(empresa,clave)
		assert found, 'No existe la cuenta contable: '+clave
		return found
	}

	int compareTo(other){
		this.clave <=>other.clave
	}

}

