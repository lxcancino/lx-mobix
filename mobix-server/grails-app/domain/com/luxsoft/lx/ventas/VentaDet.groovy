package com.luxsoft.lx.ventas


import groovy.transform.EqualsAndHashCode

import com.luxsoft.lx.core.Producto
import com.luxsoft.lx.utils.MonedaUtils
import com.luxsoft.mobix.core.Inmueble

@EqualsAndHashCode(includes='producto,cantidad')
//@ToString(includes='producto,cantidad',includeNames=true,includePackage=false)
class VentaDet {

	Producto producto
	
	BigDecimal cantidad=0.0

	BigDecimal precio=0.0

	BigDecimal importeBruto=0.0

	BigDecimal descuentoTasa=0.0

    BigDecimal descuento=0.0

    BigDecimal importeNeto=0.0

    BigDecimal impuesto=0.0

	String comentario

    Inmueble inmueble

	Date dateCreated
	Date lastUpdated

	static belongsTo = [venta: Venta]

    static constraints = {
    	cantidad(scale:2)
    	precio(scale:4)
    	importeBruto(scale:4)
    	descuentoTasa(scale:4)
    	descuento(scale:4)
    	importeNeto(scale:4)
    	impuesto(scale:4)
    	comentario nullable:true
        inmueble nullable:true
        
    }

    static transients = ['importeNetoSinIva','importeBrutoSinIva','total']

    def actualizarImportes(){
        
        importeBruto=precio*cantidad 

        if(descuentoTasa>=0.0){
            descuento=(descuentoTasa/100)*importeBruto
        }
        
        importeNeto=importeBruto-descuento
        
        impuesto = MonedaUtils.calcularImpuesto(importeNeto, producto.impuesto)
        return this
    }

    def getTotal(){
        return importeNeto+impuesto
    }

    String toString(){
    	"${producto}  ${cantidad}  ${precio}"
    }

    
   


}
