package com.luxsoft.lx.core

class EmpresaBranding {

	byte[] logo

	Date dateCreated

	Date lastUpdated

	static belongsTo = [empresa: Empresa]

    static constraints = {
    	logo nullable:true,maxSize:(1024 * 1024)
    }


}




