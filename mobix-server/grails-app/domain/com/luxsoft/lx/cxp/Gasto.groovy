package com.luxsoft.lx.cxp



class Gasto extends CuentaPorPagar{

	String concepto='GASTOS'
	


    static hasMany = [partidas: GastoDet]

    static mapping = {
		partidas cascade: "all-delete-orphan"
		concepto nullalbe:true,maxSize:50
	}


	static String[] CONCEPTOS=[
		'GASTOS',
		'HONORARIOS_CON_RETENCION',
		'HONORARIOS_SIN_RETENCION',
		'HONORARIOS_ASIMILADOS',
		'SERVICIOS_PROFESIONALES',
		'RETENCION_PAGOS',
		'COMISIONES_BANCARIAS'
		]
	
}
