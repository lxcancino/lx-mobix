package com.luxsoft.lx.contabilidad


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='cuenta')
@ToString(includeNames=true,includePackage=false)
class BalanzaDet implements Comparable{

	CuentaContable cuenta
	BigDecimal saldoIni=0.0
	BigDecimal debe=0.0
	BigDecimal haber=0.0
	BigDecimal saldoFin=0.0

	static belongsTo = [balanza: Balanza]

    static constraints = {
    	
    }

    int compareTo(other){
		this.cuenta <=>other.cuenta
	}
    

}

