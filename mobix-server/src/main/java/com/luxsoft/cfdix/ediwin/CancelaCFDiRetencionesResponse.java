
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
 *         &lt;element name="cancelaCFDiRetencionesReturn" type="{http://cfdi.service.ediwinws.edicom.com}CancelaResponse"/>
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
    "cancelaCFDiRetencionesReturn"
})
@XmlRootElement(name = "cancelaCFDiRetencionesResponse")
public class CancelaCFDiRetencionesResponse {

    @XmlElement(required = true)
    protected CancelaResponse cancelaCFDiRetencionesReturn;

    /**
     * Obtiene el valor de la propiedad cancelaCFDiRetencionesReturn.
     * 
     * @return
     *     possible object is
     *     {@link CancelaResponse }
     *     
     */
    public CancelaResponse getCancelaCFDiRetencionesReturn() {
        return cancelaCFDiRetencionesReturn;
    }

    /**
     * Define el valor de la propiedad cancelaCFDiRetencionesReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelaResponse }
     *     
     */
    public void setCancelaCFDiRetencionesReturn(CancelaResponse value) {
        this.cancelaCFDiRetencionesReturn = value;
    }

}
