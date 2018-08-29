package com.luxsoft.lx.core

import grails.validation.Validateable
import groovy.transform.ToString
import com.luxsoft.utils.Periodo


@ToString(includes='ejercicio,mes',includeNames=true,includePackage=false)
class PeriodoOperativo implements Serializable, Validateable{
	
	Integer ejercicio=Periodo.currentYear()
    Integer mes=Periodo.currentMes()

    static constraints={
        ejercicio inList:(2014..2018)
        mes inList:(1..12)
    }

    String toString(){
    	return "$mes - $ejercicio "
    }

    Periodo toPeriodo(){
        return Periodo.getPeriodoEnUnMes(mes-1,ejercicio)
    }


	
}