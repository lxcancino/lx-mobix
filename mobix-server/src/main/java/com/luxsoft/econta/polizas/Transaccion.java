
package com.luxsoft.econta.polizas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompNal" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="UUID_CFDI" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;length value="36"/>
 *                       &lt;pattern value="[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="RFC" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="12"/>
 *                       &lt;maxLength value="13"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[A-ZÑ&amp;]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z0-9]?[A-Z0-9]?[0-9A-Z]?"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="MontoTotal" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/PolizasPeriodo}t_Importe" />
 *                 &lt;attribute name="Moneda" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Moneda" />
 *                 &lt;attribute name="TipCamb">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                       &lt;minInclusive value="0"/>
 *                       &lt;totalDigits value="19"/>
 *                       &lt;fractionDigits value="5"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CompNalOtr" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="CFD_CBB_Serie">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="10"/>
 *                       &lt;pattern value="[A-Z]+"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="CFD_CBB_NumFol" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                       &lt;minInclusive value="1"/>
 *                       &lt;totalDigits value="20"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="RFC" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="12"/>
 *                       &lt;maxLength value="13"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[A-ZÑ&amp;]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z0-9]?[A-Z0-9]?[0-9A-Z]?"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="MontoTotal" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/PolizasPeriodo}t_Importe" />
 *                 &lt;attribute name="Moneda" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Moneda" />
 *                 &lt;attribute name="TipCamb">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                       &lt;minInclusive value="0"/>
 *                       &lt;totalDigits value="19"/>
 *                       &lt;fractionDigits value="5"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CompExt" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="NumFactExt" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="36"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="TaxID">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="30"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="MontoTotal" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/PolizasPeriodo}t_Importe" />
 *                 &lt;attribute name="Moneda" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Moneda" />
 *                 &lt;attribute name="TipCamb">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                       &lt;minInclusive value="0"/>
 *                       &lt;totalDigits value="19"/>
 *                       &lt;fractionDigits value="5"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Cheque" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Num" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;maxLength value="20"/>
 *                       &lt;minLength value="1"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="BanEmisNal" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Banco" />
 *                 &lt;attribute name="BanEmisExt">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;maxLength value="150"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="CtaOri" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;maxLength value="50"/>
 *                       &lt;minLength value="1"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="Fecha" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *                 &lt;attribute name="Benef" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="300"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="RFC" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="12"/>
 *                       &lt;maxLength value="13"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[A-ZÑ&amp;]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z0-9]?[A-Z0-9]?[0-9A-Z]?"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="Monto" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/PolizasPeriodo}t_Importe" />
 *                 &lt;attribute name="Moneda" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Moneda" />
 *                 &lt;attribute name="TipCamb">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                       &lt;minInclusive value="0"/>
 *                       &lt;totalDigits value="19"/>
 *                       &lt;fractionDigits value="5"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Transferencia" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="CtaOri">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="50"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="BancoOriNal" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Banco" />
 *                 &lt;attribute name="BancoOriExt">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;maxLength value="150"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="CtaDest" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="50"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="BancoDestNal" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Banco" />
 *                 &lt;attribute name="BancoDestExt">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;maxLength value="150"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="Fecha" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *                 &lt;attribute name="Benef" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="300"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="RFC" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="12"/>
 *                       &lt;maxLength value="13"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[A-ZÑ&amp;]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z0-9]?[A-Z0-9]?[0-9A-Z]?"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="Monto" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/PolizasPeriodo}t_Importe" />
 *                 &lt;attribute name="Moneda" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Moneda" />
 *                 &lt;attribute name="TipCamb">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                       &lt;minInclusive value="0"/>
 *                       &lt;totalDigits value="19"/>
 *                       &lt;fractionDigits value="5"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OtrMetodoPago" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="MetPagoPol" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_MetPagos" />
 *                 &lt;attribute name="Fecha" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *                 &lt;attribute name="Benef" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="300"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="RFC" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="12"/>
 *                       &lt;maxLength value="13"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[A-ZÑ&amp;]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z0-9]?[A-Z0-9]?[0-9A-Z]?"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="Monto" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/PolizasPeriodo}t_Importe" />
 *                 &lt;attribute name="Moneda" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/CatalogosParaEsqContE}c_Moneda" />
 *                 &lt;attribute name="TipCamb">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                       &lt;minInclusive value="0"/>
 *                       &lt;totalDigits value="19"/>
 *                       &lt;fractionDigits value="5"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="NumCta" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="100"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="DesCta" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="100"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Concepto" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="200"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Debe" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/PolizasPeriodo}t_Importe" />
 *       &lt;attribute name="Haber" use="required" type="{www.sat.gob.mx/esquemas/ContabilidadE/1_1/PolizasPeriodo}t_Importe" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "compNal",
    "compNalOtr",
    "compExt",
    "cheque",
    "transferencia",
    "otrMetodoPago"
})
public class Transaccion {

    @XmlElement(name = "CompNal")
    protected List<CompNal> compNal;
    @XmlElement(name = "CompNalOtr")
    protected List<CompNalOtr> compNalOtr;
    @XmlElement(name = "CompExt")
    protected List<CompExt> compExt;
    @XmlElement(name = "Cheque")
    protected List<Cheque> cheque;
    @XmlElement(name = "Transferencia")
    protected List<Transferencia> transferencia;
    @XmlElement(name = "OtrMetodoPago")
    protected List<OtrMetodoPago> otrMetodoPago;
    @XmlAttribute(name = "NumCta", required = true)
    protected String numCta;
    @XmlAttribute(name = "DesCta", required = true)
    protected String desCta;
    @XmlAttribute(name = "Concepto", required = true)
    protected String concepto;
    @XmlAttribute(name = "Debe", required = true)
    protected BigDecimal debe;
    @XmlAttribute(name = "Haber", required = true)
    protected BigDecimal haber;

    /**
     * Gets the value of the compNal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the compNal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompNal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompNal }
     * 
     * 
     */
    public List<CompNal> getCompNal() {
        if (compNal == null) {
            compNal = new ArrayList<CompNal>();
        }
        return this.compNal;
    }

    /**
     * Gets the value of the compNalOtr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the compNalOtr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompNalOtr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompNalOtr }
     * 
     * 
     */
    public List<CompNalOtr> getCompNalOtr() {
        if (compNalOtr == null) {
            compNalOtr = new ArrayList<CompNalOtr>();
        }
        return this.compNalOtr;
    }

    /**
     * Gets the value of the compExt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the compExt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompExt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompExt }
     * 
     * 
     */
    public List<CompExt> getCompExt() {
        if (compExt == null) {
            compExt = new ArrayList<CompExt>();
        }
        return this.compExt;
    }

    /**
     * Gets the value of the cheque property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cheque property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheque().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cheque }
     * 
     * 
     */
    public List<Cheque> getCheque() {
        if (cheque == null) {
            cheque = new ArrayList<Cheque>();
        }
        return this.cheque;
    }

    /**
     * Gets the value of the transferencia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transferencia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransferencia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transferencia }
     * 
     * 
     */
    public List<Transferencia> getTransferencia() {
        if (transferencia == null) {
            transferencia = new ArrayList<Transferencia>();
        }
        return this.transferencia;
    }

    /**
     * Gets the value of the otrMetodoPago property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otrMetodoPago property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtrMetodoPago().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OtrMetodoPago }
     * 
     * 
     */
    public List<OtrMetodoPago> getOtrMetodoPago() {
        if (otrMetodoPago == null) {
            otrMetodoPago = new ArrayList<OtrMetodoPago>();
        }
        return this.otrMetodoPago;
    }

    /**
     * Gets the value of the numCta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCta() {
        return numCta;
    }

    /**
     * Sets the value of the numCta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCta(String value) {
        this.numCta = value;
    }

    /**
     * Gets the value of the desCta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesCta() {
        return desCta;
    }

    /**
     * Sets the value of the desCta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesCta(String value) {
        this.desCta = value;
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

    /**
     * Gets the value of the debe property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebe() {
        return debe;
    }

    /**
     * Sets the value of the debe property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebe(BigDecimal value) {
        this.debe = value;
    }

    /**
     * Gets the value of the haber property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHaber() {
        return haber;
    }

    /**
     * Sets the value of the haber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHaber(BigDecimal value) {
        this.haber = value;
    }

}
