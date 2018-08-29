package com.luxsoft.lx.ventas

import org.apache.commons.lang.exception.ExceptionUtils
import org.apache.commons.logging.LogFactory


class VentaListenerManager {

	private static final log=LogFactory.getLog(this)
	
	def listeners=[]
	
	def beforeSavePartida(VentaDet det){
		log.debug 'Porcesando partida de venta: '+det
		listeners.each{ p ->
			try {
				p.beforeSavePartida(det)
			}catch(Exception ex) {
				log.error ex
				String msg="Error en listener: ${p} Causa: "+ExceptionUtils.getRootCauseMessage(ex)
				throw new VentaDetListenerException (message:msg,ventaDet:det)
			}
		}
		return det
	}
	
}

class VentaDetListenerException extends RuntimeException{
	String message
	VentaDet ventaDet

}