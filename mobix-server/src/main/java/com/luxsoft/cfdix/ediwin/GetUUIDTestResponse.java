
package com.luxsoft.cfdix.ediwin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getUUIDTestReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getUUIDTestReturn"
})
@XmlRootElement(name = "getUUIDTestResponse")
public class GetUUIDTestResponse {

    @XmlElement(required = true)
    protected String getUUIDTestReturn;

    /**
     * Obtiene el valor de la propiedad getUUIDTestReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetUUIDTestReturn() {
        return getUUIDTestReturn;
    }

    /**
     * Define el valor de la propiedad getUUIDTestReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetUUIDTestReturn(String value) {
        this.getUUIDTestReturn = value;
    }

}
