package com.luxsoft.lx.tesoreria



import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

import com.luxsoft.lx.contabilidad.CuentaContable
import com.luxsoft.lx.core.Empresa

class CuentaBancaria {
	

	Empresa empresa

	String numero
	String tipo
	String nombre
	Currency moneda
	boolean activo
	int folioInicial=0
	int folioFinal=0
	int folio=0
	BigDecimal tasaDeInversion=0
	BigDecimal tasaIsr=0.0
	int diasInversionIsr=365
	int plazo=0
	CuentaContable cuentaContable
	String subCuentaOperativa

	String impresionTemplate
	
	String cuentaRetencion

	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [banco:Banco]

    static constraints = {
		numero(blank:false,size:1..50)
		nombre(blank:false,size:1..100)
		tipo(blank:false,size:1..50,inList:['CHEQUES','INVERSION'])
		impresionTemplate nullable:true,maxSize:50
		cuentaRetencion nullable:true
		subCuentaOperativa(nullable:true,maxSize:4)
    }
	
	static mapping ={
		banco fetch:'join'
	}
	
	String toString() {
		return "${numero}  - ${banco?.nombre} (${tipo}) "
	}
	
	boolean equals(Object obj){
		if(!obj.instanceOf(CuentaBancaria))
			return false
		if(this.is(obj))
			return true
		def eb=new EqualsBuilder()
		eb.append(id, obj.id)
		eb.append(banco, obj.banco)
		eb.append(numero, obj.numero)
		return eb.isEquals()
	}
	
	int hashCode(){
		def hb=new HashCodeBuilder(17,35)
		hb.append(id)
		hb.append(banco)
		hb.append(numero)
		return hb.toHashCode()
	}

	
	
	
}

