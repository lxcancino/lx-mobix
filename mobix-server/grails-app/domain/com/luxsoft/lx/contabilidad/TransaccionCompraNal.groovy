package com.luxsoft.lx.contabilidad

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import com.luxsoft.lx.utils.MonedaUtils
import com.luxsoft.lx.sat.BancoSat

@ToString(excludes='dateCreated,lastUpdated,polizaDet',includeNames=true,includePackage=false)
@EqualsAndHashCode
class TransaccionCompraNal {

	
	String uuidcfdi
	
	String rfc
	
	BigDecimal montoTotal
	
	Currency moneda = MonedaUtils.PESOS
	
	BigDecimal tipCamb = 1.0

	Date dateCreated

	Date lastUpdated

    static constraints = {
    }

    static belongsTo = [polizaDet:PolizaDet]
}
