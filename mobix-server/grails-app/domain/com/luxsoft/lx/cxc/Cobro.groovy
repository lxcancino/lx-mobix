package com.luxsoft.lx.cxc

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import com.luxsoft.lx.tesoreria.Banco
import com.luxsoft.lx.tesoreria.CuentaBancaria
import com.luxsoft.lx.tesoreria.MovimientoDeCuenta
import com.luxsoft.lx.core.FormaDePago
import com.luxsoft.lx.core.Empresa
import com.luxsoft.lx.core.Cliente
import com.luxsoft.cfdi.Cfdi


@EqualsAndHashCode(includes='id,cliente')
@ToString(includes='cliente,total,disponible,formaDePago',includeNames=true,includePackage=false)
class Cobro {

	Empresa empresa

	Date fecha
	
	Cliente cliente

	FormaDePago formaDePago
	
	Banco banco
	
	String referencia
	
	BigDecimal importe=0.0
	
	BigDecimal aplicado=0.0
	
	BigDecimal disponible=0.0
	
	String comentario

	Boolean anticipo=false

	CuentaBancaria cuentaDestino

	MovimientoDeCuenta ingreso

	Cfdi cfdi
	
	Date dateCreated
	Date lastUpdated
	String creadoPor
	String modificadoPor
	
	static hasMany = [aplicaciones: AplicacionDeCobro]

    static constraints = {
    	comentario nullable:true, maxSize:300
    	referencia nullable:true,maxSize:20
    	banco nullable:true,maxSize:30
    	cuentaDestino nullable:true
    	creadoPor maxSize:50
    	modificadoPor maxSize:50
    	importe min:1.0
    	cfdi nullable: true
    }

    static mapping = {
		aplicaciones cascade: "all-delete-orphan"
		fecha type: 'date'
	}

	static transients = ['disponible','aplicado']
	
	BigDecimal getAplicado(){
		//partidas.sum (0.0),{it.importeBruto}
		if(aplicaciones==null)
			return 0.0
		return aplicaciones.sum(0.0,{it.importe})
	}

	BigDecimal getDisponible(){
		return  importe-getAplicado()
	}

    
}

