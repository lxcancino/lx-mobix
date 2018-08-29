package com.luxsoft.mobix.core

class Documento {

	String descripcion
	byte[] file

    static constraints = {
    	file(nullable:true,maxSize:1024*1024*5)
    }
    
    static belongsTo = [arrendamiento:Arrendamiento]
}
