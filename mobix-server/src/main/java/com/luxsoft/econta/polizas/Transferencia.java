
package com.luxsoft.econta.polizas;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="CtaOri">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="50"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="BancoOriNal" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Banco" />
 *       &lt;attribute name="BancoOriExt">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="150"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CtaDest" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="50"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="BancoDestNal" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Banco" />
 *       &lt;attribute name="BancoDestExt">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="150"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Fecha" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="Benef" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="300"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="RFC" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="12"/>
 *             &lt;maxLength value="13"/>
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;pattern value="[A-ZÑ&amp;]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z0-9]?[A-Z0-9]?[0-9A-Z]?"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Monto" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/PolizasPeriodo}t_Importe" />
 *       &lt;attribute name="Moneda" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Moneda" />
 *       &lt;attribute name="TipCamb">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;minInclusive value="0"/>
 *             &lt;totalDigits value="19"/>
 *             &lt;fractionDigits value="5"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Transferencia {

    @XmlAttribute(name = "CtaOri")
    protected String ctaOri;
    @XmlAttribute(name = "BancoOriNal", required = true)
    protected String bancoOriNal;
    @XmlAttribute(name = "BancoOriExt")
    protected String bancoOriExt;
    @XmlAttribute(name = "CtaDest", required = true)
    protected String ctaDest;
    @XmlAttribute(name = "BancoDestNal", required = true)
    protected String bancoDestNal;
    @XmlAttribute(name = "BancoDestExt")
    protected String bancoDestExt;
    @XmlAttribute(name = "Fecha", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecha;
    @XmlAttribute(name = "Benef", required = true)
    protected String benef;
    @XmlAttribute(name = "RFC", required = true)
    protected String rfc;
    @XmlAttribute(name = "Monto", required = true)
    protected BigDecimal monto;
    @XmlAttribute(name = "Moneda")
    protected CMoneda moneda;
    @XmlAttribute(name = "TipCamb")
    protected BigDecimal tipCamb;

    /**
     * Gets the value of the ctaOri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtaOri() {
        return ctaOri;
    }

    /**
     * Sets the value of the ctaOri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtaOri(String value) {
        this.ctaOri = value;
    }

    /**
     * Gets the value of the bancoOriNal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBancoOriNal() {
        return bancoOriNal;
    }

    /**
     * Sets the value of the bancoOriNal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBancoOriNal(String value) {
        this.bancoOriNal = value;
    }

    /**
     * Gets the value of the bancoOriExt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBancoOriExt() {
        return bancoOriExt;
    }

    /**
     * Sets the value of the bancoOriExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBancoOriExt(String value) {
        this.bancoOriExt = value;
    }

    /**
     * Gets the value of the ctaDest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtaDest() {
        return ctaDest;
    }

    /**
     * Sets the value of the ctaDest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtaDest(String value) {
        this.ctaDest = value;
    }

    /**
     * Gets the value of the bancoDestNal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBancoDestNal() {
        return bancoDestNal;
    }

    /**
     * Sets the value of the bancoDestNal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBancoDestNal(String value) {
        this.bancoDestNal = value;
    }

    /**
     * Gets the value of the bancoDestExt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBancoDestExt() {
        return bancoDestExt;
    }

    /**
     * Sets the value of the bancoDestExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBancoDestExt(String value) {
        this.bancoDestExt = value;
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
     * Gets the value of the benef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenef() {
        return benef;
    }

    /**
     * Sets the value of the benef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenef(String value) {
        this.benef = value;
    }

    /**
     * Gets the value of the rfc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRFC() {
        return rfc;
    }

    /**
     * Sets the value of the rfc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRFC(String value) {
        this.rfc = value;
    }

    /**
     * Gets the value of the monto property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMonto(BigDecimal value) {
        this.monto = value;
    }

    /**
     * Gets the value of the moneda property.
     * 
     * @return
     *     possible object is
     *     {@link CMoneda }
     *     
     */
    public CMoneda getMoneda() {
        return moneda;
    }

    /**
     * Sets the value of the moneda property.
     * 
     * @param value
     *     allowed object is
     *     {@link CMoneda }
     *     
     */
    public void setMoneda(CMoneda value) {
        this.moneda = value;
    }

    /**
     * Gets the value of the tipCamb property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTipCamb() {
        return tipCamb;
    }

    /**
     * Sets the value of the tipCamb property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTipCamb(BigDecimal value) {
        this.tipCamb = value;
    }

}
