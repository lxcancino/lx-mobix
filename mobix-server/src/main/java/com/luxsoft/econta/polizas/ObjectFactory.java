
package com.luxsoft.econta.polizas;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.luxsoft.econta.polizas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.luxsoft.econta.polizas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Polizas }
     * 
     */
    public Polizas createPolizas() {
        return new Polizas();
    }

    /**
     * Create an instance of {@link Poliza }
     * 
     */
    public Poliza createPoliza() {
        return new Poliza();
    }

    /**
     * Create an instance of {@link Transaccion }
     * 
     */
    public Transaccion createTransaccion() {
        return new Transaccion();
    }

    /**
     * Create an instance of {@link CompNal }
     * 
     */
    public CompNal createCompNal() {
        return new CompNal();
    }

    /**
     * Create an instance of {@link CompNalOtr }
     * 
     */
    public CompNalOtr createCompNalOtr() {
        return new CompNalOtr();
    }

    /**
     * Create an instance of {@link CompExt }
     * 
     */
    public CompExt createCompExt() {
        return new CompExt();
    }

    /**
     * Create an instance of {@link Cheque }
     * 
     */
    public Cheque createCheque() {
        return new Cheque();
    }

    /**
     * Create an instance of {@link Transferencia }
     * 
     */
    public Transferencia createTransferencia() {
        return new Transferencia();
    }

    /**
     * Create an instance of {@link OtrMetodoPago }
     * 
     */
    public OtrMetodoPago createOtrMetodoPago() {
        return new OtrMetodoPago();
    }

}
