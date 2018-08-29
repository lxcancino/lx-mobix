
package com.luxsoft.econta.polizas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transaccion"
})
public class Poliza {

    @XmlElement(name = "Transaccion", required = true)
    protected List<Transaccion> transaccion;
    @XmlAttribute(name = "NumUnIdenPol", required = true)
    protected String numUnIdenPol;
    @XmlAttribute(name = "Fecha", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecha;
    @XmlAttribute(name = "Concepto", required = true)
    protected String concepto;

    /**
     * Gets the value of the transaccion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transaccion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransaccion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transaccion }
     * 
     * 
     */
    public List<Transaccion> getTransaccion() {
        if (transaccion == null) {
            transaccion = new ArrayList<Transaccion>();
        }
        return this.transaccion;
    }

    /**
     * Gets the value of the numUnIdenPol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumUnIdenPol() {
        return numUnIdenPol;
    }

    /**
     * Sets the value of the numUnIdenPol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumUnIdenPol(String value) {
        this.numUnIdenPol = value;
    }

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the concepto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Sets the value of the concepto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConcepto(String value) {
        this.concepto = value;
    }

}
