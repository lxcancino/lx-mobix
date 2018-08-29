package com.luxsoft.lx.tesoreria

import com.luxsoft.lx.sat.BancoSat
import com.luxsoft.lx.core.Empresa

class Banco {

	Empresa empresa
	String nombre
	BancoSat bancoSat

    static constraints = {
		nombre(blank:false,size:5..150,unique:['empresa'])
		
    }

    static hasMany = [cuentas: CuentaBancaria]
	
	String toString(){
		return nombre
	}

    
}
