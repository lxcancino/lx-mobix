package com.luxsoft.lx.af


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


import com.luxsoft.lx.core.Empresa
import com.luxsoft.lx.contabilidad.CuentaContable
import com.luxsoft.lx.cxp.GastoDet


@EqualsAndHashCode(includes='empresa,descripcion,factura')
@ToString( includeNames=true,includePackage=false)
class ActivoFijo {

	Empresa empresa

	BigDecimal valorOriginal

	BigDecimal valorDepreciable

	String descripcion

	String factura

	Date adquisicion

	String tipoDeDepreciacion = 'MENSUAL'

	BigDecimal depreciacionTasa

	CuentaContable cuentaContable

	String modelo

	String serie

	String consignatario

	String comentario

	BigDecimal costoActualizado = 0.0

	GastoDet gastoDet

	BigDecimal depreciacionAcumulada

	Date dateCreated

	Date lastUpdated

	static constraints = {
		factura maxSize:50
		tipoDeDepreciacion inList:['MENSUAL']
		depreciacionTasa scale:4,min:1.0,max:99.99
		gastoDet nullable:true
		modelo nullable:true,maxSize:50
		serie nullable:true,maxSize:50
		consignatario nullable:true
		comentario nullable:true
	}

	static hasMany = [depreciaciones:Depreciacion]

	static mapping = {
		depreciaciones cascade: "all-delete-orphan"
		//depreciacionAcumulada formula:'(select ifnull(sum(x.depreciacion),0) from depreciacion x where x.activo_id=id)'
		adquisicion type: 'date'
	}

	static transients = ['depreciacionAcumulada','pendiente']

	BigDecimal getDepreciacionAcumulada(Date fecha){

		if(!depreciaciones)
			return 0.0

		def ejercicio = fecha.toYear()
		def mes = fecha.toMonth()

		return depreciaciones.sum (0.0){
			if(it.ejercicio<=it.ejercicio && it.mes<=mes)
				it.depreciacion
			else
				return 0.0
		}

	}

	BigDecimal getPendiente(){
		reurn valorOriginal-depreciacionAcumulada
	}
}
