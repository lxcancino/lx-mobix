package com.luxsoft.cfdix.v33

import java.security.Signature

import org.bouncycastle.util.encoders.Base64

import com.luxsoft.lx.core.Empresa
import lx.cfdi.v33.Comprobante

public class CfdiSellador33 {

	//String algoritmo = 'SHA1withRSA'
	String algoritmo = 'SHA256withRSA'

	CfdiCadenaBuilder33 cadenaBuilder = new CfdiCadenaBuilder33()

	Comprobante sellar(Comprobante comprobante, Empresa empresa){
		String cadenaOriginal = cadenaBuilder.build(comprobante)

		final byte[] input=cadenaOriginal.getBytes("UTF-8")
		Signature signature=Signature.getInstance(algoritmo,"BC");
		signature.initSign(empresa.privateKey)
		signature.update(input)
		
		final byte[] signedData=signature.sign()
		final byte[] encoedeData=Base64.encode(signedData)
		comprobante.sello = new String(encoedeData,"UTF-8")
		return comprobante
	}

	
}