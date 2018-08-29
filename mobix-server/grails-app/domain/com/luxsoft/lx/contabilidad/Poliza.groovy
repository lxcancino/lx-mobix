package com.luxsoft.lx.contabilidad


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import com.luxsoft.lx.core.Empresa
import com.luxsoft.lx.utils.MonedaUtils

@EqualsAndHashCode(includes='empresa,ejercicio,mes,tipo,subTipo,folio')
@ToString(includes='empresa,ejercicio,mes,tipo,subTipo,folio,debe,haber',includeNames=true,includePackage=false)
class Poliza {

	Empresa empresa

	Integer ejercicio

	Integer mes
	
	String tipo

	String subTipo

	Integer folio

	Date fecha

	String concepto

	BigDecimal debe=0.0

	BigDecimal haber=0.0

	Boolean manual=false

	List partidas=[]

	Long origen

	String entidad

	Date cierre

	Date dateCreated
	Date lastUpdated

	String creadoPor
	String modificadoPor
	
	static hasMany = [partidas:PolizaDet]

    static constraints = {
		ejercicio inList:(2014..2018)
		mes inList:(1..13)
		tipo(inList:['INGRESO','EGRESO','DIARIO'])
		subTipo(maxSize:30)
		//folio unique:['empresa','ejercicio','mes','tipo','subTipo']
		debe(nullable:false,scale:6)
		haber(nullable:false,scale:6)
		concepto(maxSize:300)
		creadoPor nullable:true,maxSize:50
		modificadoPor nullable:true,maxSize:50
		cierre nullable:true
		origen nullable:true
		entidad nullable:true
    }
	
	
	static mapping ={
		partidas cascade: "all-delete-orphan"
		cheques  cascade: "all-delete-orphan"
		fecha type:'date'
	}
	
	static transients = {'cuadre'}
	
	def getCuadre(){
		return MonedaUtils.round(debe-haber)
	}
	
	
	
	def actualizar(){
		//if(!partidas) 
		debe=partidas.sum (0.0,{it.debe})
		haber=partidas.sum(0.0,{it.haber})
	}

	
	def beforeInsert(){
		actualizar()
	}
	
	def beforeUpdate(){
		actualizar()
	}
	
	
}



