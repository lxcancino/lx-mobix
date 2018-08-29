package com.luxsoft.lx.cxp

import com.luxsoft.lx.contabilidad.CuentaContable
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
//import com.luxsoft.lx.utils.MonedaUtils

@ToString(includes='descripcion,cuentaContable,cantidad,importe',includeNames=true,includePackage=false)
@EqualsAndHashCode(includes='concepto,descripcion,cantidad,importe')
class GastoDet {

	CuentaContable cuentaContable
	String descripcion
	String unidad
	BigDecimal cantidad
	BigDecimal valorUnitario
	BigDecimal importe
	String comentario
    String concepto


    BigDecimal retencionIsrTasa=0
    BigDecimal retencionIsr=0
    BigDecimal retencionIvaTasa=0
    BigDecimal retencionIva=0




    static constraints = {
    	valorUnitario(scale:4)
    	importe(scale:4)
    	unidad maxSize:20
    	comentario nullable:true
        retencionIsrTasa scale:4
        retencionIvaTasa scale:4
        concepto nullable:true,maxSize:50
    }

    static belongsTo = [gasto: Gasto]

    def actualizarImportes(){
        importe=cantidad*valorUnitario
        return this
    }

}

