
package com.luxsoft.cfdix.ediwin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="changePasswordReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "changePasswordReturn"
})
@XmlRootElement(name = "changePasswordResponse")
public class ChangePasswordResponse {

    protected boolean changePasswordReturn;

    /**
     * Obtiene el valor de la propiedad changePasswordReturn.
     * 
     */
    public boolean isChangePasswordReturn() {
        return changePasswordReturn;
    }

    /**
     * Define el valor de la propiedad changePasswordReturn.
     * 
     */
    public void setChangePasswordReturn(boolean value) {
        this.changePasswordReturn = value;
    }

}
