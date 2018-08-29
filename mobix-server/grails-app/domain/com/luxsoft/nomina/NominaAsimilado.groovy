package com.luxsoft.nomina

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

import com.luxsoft.cfdi.Cfdi
import com.luxsoft.lx.core.Empresa

@ToString(includes='empresa,asimilado,formaDePago,concepto',includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='id')
class NominaAsimilado {

	Empresa empresa

	Asimilado asimilado

	String formaDePago

	Date fecha

	Date pago // fecha de pago aproximado

	BigDecimal percepciones

	BigDecimal deducciones

	String concepto

	Cfdi cfdi

	Date dateCreated
	Date lastUpdated


	static constraints = {
		formaDePago inList: ['TRANSFERENCIA','CHEQUE', 'EFECTIVO']
		cfdi nullable: true
	}

	static hasMany = [partidas: NominaAsimiladoDet]

	static transients = ['deducciones']

	static mapping = {
		partidas cascade: "all-delete-orphan"
        fecha type: 'date'
        pago type: 'date'
	}

	BigDecimal getDeducciones() {
		partidas.sum 0.0,{
			return it.tipo=='DEDUCCION' ? it.importeExcento:0.0
		}
	}
}
