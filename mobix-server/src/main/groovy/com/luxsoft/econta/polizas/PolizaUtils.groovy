package com.luxsoft.econta.polizas

import com.luxsoft.lx.contabilidad.*

class PolizaUtils {
	
	
	public static void buildProcesadores(){
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'FACTURACION',
			label:'Facturación',
			tipo:'DIARIO',
			service:'polizaDeFacturacionService')

		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'PAGO_GASTOS',
			label:'Pagos (Gastos)',
			tipo:'EGRESO',
			service:'polizaDePagoGastosService')

		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'COBRANZA',
			label: 'Cobranza',
			tipo:'INGRESO',
			service:'polizaDeCobranzaService')

		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'PROVISION_GASTOS',
			label: 'Provision (Gastos)',
			service:'polizaDeProvisionGastosService')

		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'COMISIONES_BANCARIAS',
			label:'Comisiones (Retiro)',
			tipo:'DIARIO',
			service:'polizaDeComisionesBancariasService')
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'COMISIONES_BANCARIAS_GASTO',
			label:'Comisiones (Gasto)',
			tipo:'DIARIO',
			service:'polizaDeComisionesBancariasGastoService')
		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'INVERSIONES',
			label:'Inversiones',
			service:'polizaDeInversionesService')
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'COMPROBACION_GASTOS',
			label:'Comprobación de gastos',
			service:'polizaDeComprobacionDeGastosService')

		/*
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'PAGO_IMPUESTOS',
			label:'Pagos (Impuestos)',
			tipo:'EGRESO',
			service:'polizaDePagoDeImpuestos')
		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'DEPRECIACIONES',
			label:'Depreciaciones',
			tipo:'DIARIO',
			service:'polizaDeDepreciaciones')
		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'AMORTIZACIONES',
			label:'Amortizaciones',
			tipo:'DIARIO',
			service:'polizaDeAmortizaciones')
		

		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'DETERMINACION_DE_IVA',
			label: 'Determinación (IVA)',
			tipo:'DIARIO',
			service:'polizaDeDeterminacionDelIva')
		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'PROVISION_ISR',
			label: 'Provisión (ISR)',
			service:'polizaDeProvisionIsr')
		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'TRASPASO_IVA_DETERMINADO',
			label: 'Traspaso (IVA)',
			service:'polizaDeTraspasoDeIvaDeterminado')
		

		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'HONORARIOS',
			label: 'Honorarios',
			service:'polizaDeHonorarios')
		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'CANCELACION_DE_PROVISION_GASTOS',
			label: 'Cancelacion (Prov IVA)',
			service:'polizaDeCancelacionDeProvisionGastos')
		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'CHEQUE_CANCELADO',
			label: 'Cancelacion (Cheques)',
			service:'polizaDeChequeCancelado')
		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'CANCELACION_DE_PROVISION_SEGUROS',
			label: 'Cancelación (Seguros)',
			service:'polizaDeCancelacionDeProvisionSeguros')
		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'IMPUESTO_PREDIAL',
			label: 'Predial',
			service:'polizaDeImpuestoPredial')
		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'HONORARIOS_ASIMILADOS_A_SALARIOS',
			label: 'Honorarios asimilados',
			service:'polizaDeHonorariosAsimiladosASalarios')
		
		
		
		ProcesadorDePoliza.findOrSaveWhere(
			nombre:'HONORARIOS_CON_RETENCIONES',
			label: 'Honorarios (Con ret)',
			service:'polizaDeHonorariosConRetenciones')
		*/
		
	}


	public static IvaTrasladadoPendiente(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'209-0001')
	} 
	public static IvaTrasladadoCobrado(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'208-0001')	
	}

	public static IvaAcreditable(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'118-0001')	
	}

	public static IvaPendienteDeAcreditar(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'119-0001')
	}
	

	public static ContablesNoFiscales(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'704-0002')	
	}

	public static OtrosGastosNoFiscales(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'703-0002')		
	}

	
	public static RetencionIsrHonorariosAsimilados(def empresa){
		return CuentaContable.buscarPorClave(empresa,'216-0004')
	}

	public static RetencionIsrHonorarios(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'216-0001')
	}

	public static RetencionIsrServiciosProfesionales(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'216-0002')
	}

	public static RetencionIsrDividendos(def empresa){
	return CuentaContable.findByEmpresaAndClave(empresa,'216-0005')
	}

	

	// Cargo
	public static IvaRetenidoPendient(def empresa){ 
		return CuentaContable.findByEmpresaAndClave(empresa,'119-0002')	
	}

	// Abono
	public static ImpuestoRetenidoDeIva(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'216-0003')	
	}

	public static AcredoresDiversos(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'205-0001')
	}

	public static ComisionesBancarias(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'600-0011')	
	}

	public static Deudores(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'107-0001')	
	}

	public static InteresesBancarios(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'702-0001')		
	}

	public static IsrBancario(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'750-0002')
	}

	public static Servicios(def empresa){
		return CuentaContable.findByEmpresaAndClave(empresa,'403-0001')	
	}


	
}