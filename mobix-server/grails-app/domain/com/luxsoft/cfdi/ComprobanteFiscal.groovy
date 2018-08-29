package com.luxsoft.cfdi

class ComprobanteFiscal {

	String emisor
	String emisorRfc
	String receptor
	String receptorRfc
	BigDecimal total
	String uuid
	String acuseEstado
	String acuseCodigo
	Date ultimaValidacion
	Date dateCreated
	Date lastUpdated

    static constraints = {
    	acuseCodigo nullable: true
    	acuseEstado nullable: true
    	ultimaValidacion nullable: true
    }
}
