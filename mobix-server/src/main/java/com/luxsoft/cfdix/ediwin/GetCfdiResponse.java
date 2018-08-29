
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
 *         &lt;element name="getCfdiReturn" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
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
    "getCfdiReturn"
})
@XmlRootElement(name = "getCfdiResponse")
public class GetCfdiResponse {

    @XmlElement(required = true)
    protected byte[] getCfdiReturn;

    /**
     * Obtiene el valor de la propiedad getCfdiReturn.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getGetCfdiReturn() {
        return getCfdiReturn;
    }

    /**
     * Define el valor de la propiedad getCfdiReturn.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setGetCfdiReturn(byte[] value) {
        this.getCfdiReturn = value;
    }

}
