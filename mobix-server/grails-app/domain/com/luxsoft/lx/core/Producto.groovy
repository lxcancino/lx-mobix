package com.luxsoft.lx.core


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import com.luxsoft.lx.core.Empresa

@EqualsAndHashCode(includes='clave')
@ToString(includeNames=true,includePackage=false)
class Producto {

    Empresa empresa

	String clave
	
	String descripcion
	
    String unidad

    Linea linea

	Boolean inventariable=true

    BigDecimal precio=0.0

    BigDecimal descuento=0.0

    BigDecimal impuesto=0.0

    String claveProdServ
    String claveUnidadSat
    String unidadSat

    Boolean impuestoTasa = 0.16

	Date dateCreated
	Date lastUpdated


    static constraints = {
        clave size:5..40,unique:['empresa']
    	descripcion blank:false
		unidad inList:['SERVICIO','PIEZA','NO DEFINIDO','UNO']
        claveProdServ nullable:true
        claveUnidadSat nullable:true
        unidadSat nullable: true
    }

    String toString(){
    	"$descripcion ($clave)"
    }

    def beforeInsert() {
    	clave=clave.toUpperCase()
    }
    def beforeUpdate() {
    	clave=clave.toUpperCase()
    }
}

