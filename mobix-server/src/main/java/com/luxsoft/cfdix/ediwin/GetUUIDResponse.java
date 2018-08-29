
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
 *         &lt;element name="getUUIDReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "getUUIDReturn"
})
@XmlRootElement(name = "getUUIDResponse")
public class GetUUIDResponse {

    @XmlElement(required = true)
    protected String getUUIDReturn;

    /**
     * Obtiene el valor de la propiedad getUUIDReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetUUIDReturn() {
        return getUUIDReturn;
    }

    /**
     * Define el valor de la propiedad getUUIDReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetUUIDReturn(String value) {
        this.getUUIDReturn = value;
    }

}
