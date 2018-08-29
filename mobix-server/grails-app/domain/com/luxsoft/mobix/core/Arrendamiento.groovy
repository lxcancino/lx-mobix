package com.luxsoft.mobix.core

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import com.luxsoft.lx.core.Cliente
import com.luxsoft.lx.core.Empresa
import com.luxsoft.lx.core.Producto
import com.luxsoft.utils.Periodo
import groovy.time.TimeCategory
import com.luxsoft.lx.core.FormaDePago
import com.luxsoft.lx.contabilidad.CuentaContable


@ToString(excludes='dateCreated,lastUpdated',includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='cliente,inmueble,tipo')
class Arrendamiento {

	Empresa empresa

	Cliente cliente

	Inmueble inmueble

	String tipo

	BigDecimal precio

	Date inicio

	Date fin

	Integer diaDeCorte  //El dia del mes que se genera la renta

	Boolean renovacionAutomatica = true

	Boolean facturacionAutomatica

	Boolean envioAutomatico

	Date proximaFactura

	Producto producto

	FormaDePago formaDePago

	String cuentaDePago

	CuentaContable cuentaContable

	//List documentos
	//List rentas

	Periodo periodo

	String comentario

	Date dateCreated
	Date lastUpdated

	static constraints = {
		tipo inList:['MENSUAL','BIMESTRAL','TRIMESTRAL','SEMESTRAL','ANUAL','ESPECIAL']
		diaDeCorte range:1..15
		comentario nullable:true,maxSize:300
		proximaFactura nullable:true
		formaDePago nullable:true
		cuentaDePago nullable:true,maxSize:6
		cuentaContable nullable:true
	}

	static hasMany = [rentas:Renta]

	static transients = ['ultimaRenta','periodo']

	static mapping = {
		rentas cascade: "all-delete-orphan"
		//documentos cascade: "all-delete-orphan"
        inicio type: 'date'
        fin type: 'date'
        proximaFactura type: 'date'

	}

	def getPeriodo(){
		if(!periodo && inicio && fin)
			periodo=new Periodo(inicio,fin)
		return periodo
	}

	def generarRentas(){
		def data=[]
		def periodos=Periodo.periodosMensuales(getPeriodo())
		def multiplo=1
		switch(tipo) {
			case 'MENSUAL':
				multiplo=1
				break
			case 'BIMESTRAL':
				multiplo=2
				break
			default:
				multiplo=1
		}
		def folio=1
		def index=1
		def fechaInicial=inicio
		periodos.each{
			if(index%multiplo==0){
				def fechaFin=it.fechaFinal
				def start=it.fechaInicial
				use(TimeCategory){
					start=start-(multiplo-1).month

				}
				def renta=new Renta(folio:folio,inicio:start,fin:it.fechaFinal,comentario:'RENTA '+folio,importe:precio)
				data.add(renta)
				folio++
			}else{
				fechaInicial
			}
			index++
		}
		return data
	}

	def generarRentas2(){
		generarRentas().each{
			addToRentas(it)
		}
	}


}
