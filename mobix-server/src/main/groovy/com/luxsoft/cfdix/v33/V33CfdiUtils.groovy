package com.luxsoft.cfdix.v33

import javax.xml.bind.JAXBContext
import java.text.SimpleDateFormat


import com.luxsoft.cfdi.Cfdi
import lx.cfdi.v33.Comprobante


class V33CfdiUtils {

	final static SimpleDateFormat CFDI_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

	public static Comprobante toComprobante(Cfdi cfdi){
		JAXBContext context = JAXBContext.newInstance(Comprobante.class)
		def unmarshaller = context.createUnmarshaller()
		Comprobante comprobante = (Comprobante)unmarshaller
			.unmarshal(new ByteArrayInputStream(cfdi.xml))
		return comprobante
	}

}