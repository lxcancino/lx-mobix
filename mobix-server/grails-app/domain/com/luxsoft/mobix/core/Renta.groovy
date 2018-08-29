package com.luxsoft.mobix.core


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.Sortable
import com.luxsoft.lx.ventas.VentaDet
import com.luxsoft.utils.Periodo

@EqualsAndHashCode(includes='arrendamiento,folio')
@ToString(excludes='dateCreated,lastUpdated',includeNames=true,includePackage=false)
@Sortable(includes=['folio'])
class Renta {

    Integer folio

    Date inicio

    Date fin

    Date fechaDeCobro

    String comentario

    BigDecimal importe

    Date dateCreated

    Date lastUpdated

    Periodo periodo

    VentaDet ventaDet

    static constraints = {
        comentario nullable:true
        ventaDet nullable:true
    }
    static mappings = {
        inicio type: 'date'
        fin type: 'date'
        fechaDeCobro type: 'date'
    }




    static belongsTo = [arrendamiento: Arrendamiento]

    static transients = ['periodo']

    def getPeriodo(){
        if(!periodo)
            periodo=new Periodo(inicio,fin)
        return periodo
    }

    String toString(){
        return "$folio ${inicio?.format('dd/MM/yyyy')} ${fin?.format('dd/MM/yyyy')} $importe "
    }


}
