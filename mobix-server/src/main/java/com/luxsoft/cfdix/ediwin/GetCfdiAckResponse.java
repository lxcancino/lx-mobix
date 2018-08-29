
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
 *         &lt;element name="getCfdiAckReturn" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
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
    "getCfdiAckReturn"
})
@XmlRootElement(name = "getCfdiAckResponse")
public class GetCfdiAckResponse {

    @XmlElement(required = true)
    protected byte[] getCfdiAckReturn;

    /**
     * Obtiene el valor de la propiedad getCfdiAckReturn.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getGetCfdiAckReturn() {
        return getCfdiAckReturn;
    }

    /**
     * Define el valor de la propiedad getCfdiAckReturn.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setGetCfdiAckReturn(byte[] value) {
        this.getCfdiAckReturn = value;
    }

}
