package com.luxsoft.lx.core

import groovy.transform.EqualsAndHashCode


@EqualsAndHashCode(includes='clave')
class Linea implements Comparable{

	String clave
	String descripcion
	Empresa empresa

    static constraints = {
    	clave size:5..25,unique:['empresa'],matches:'[0-9A-Z\\s_]+'
    	descripcion size:2..250
    }

    String toString(){
    	return clave
    }

    int compareTo(other){
    	this.clave <=>other.clave
    }
}
