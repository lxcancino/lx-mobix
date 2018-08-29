package com.luxsoft.lx.contabilidad

import com.luxsoft.lx.core.Empresa
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='empresa,cuenta,ejercicio,mes')
@ToString(excludes='dateCreated',includeNames=true,includePackage=false)
class SaldoPorCuentaContable implements Comparable{
	
	Empresa empresa
	CuentaContable cuenta
	Integer ejercicio
	Integer mes
	
	
	BigDecimal debe=0
	BigDecimal haber=0
	BigDecimal saldoInicial=0
	BigDecimal saldoFinal=0
	Date cierre
	
	Date dateCreated
	Date lastUpdated

	static mapping = {
		
	}

    static constraints = {
    	ejercicio inList:(2014..2018)
		mes inList:(1..13)
		cuenta unique:['empresa','ejercicio','mes','cuenta']
		debe sacale:6
		haber sacale:6
		saldoInicial sacale:6
		saldoFinal sacale:6
		cierre nullable:true
    }
	
	int compareTo(other){
		this.cuenta <=>other.cuenta
	}

}
