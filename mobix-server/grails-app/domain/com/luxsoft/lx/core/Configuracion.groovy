package com.luxsoft.lx.core

class Configuracion {

	transient springSecurityService

	Empresa empresa
	String modulo

	Map atributos

	Date dateCreated
	Date lastUpdated
	String creadoPor
	String modificadoPor
	

    static constraints = {
    	empresa unique:true
    	modulo inList:['GENERAL','CONTABILIDAD','TESORERIA','GASTOS']
    }

    static transients = ['springSecurityService']

    static Configuracion buscar(Empresa empresa,String modulo){
    	return Configuracion.findByEmpresa(empresa)
    }

    String buscarAtributo(String key){
        def val=atributos[key]
        if(!val) throw new RuntimeException("Atributo ${key} no definido para el módulo: ${modulo} de ${empresa.clave}")
        return val
    }

    def beforeInsert() {
    	def usename=springSecurityService.principal.username
    	creadoPor=usename
    	modificadoPor=username
    }

    def beforeUpdate() {
    	modificadoPor=springSecurityService.principal.username
    }


}
