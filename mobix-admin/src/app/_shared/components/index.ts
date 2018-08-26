import { DireccionComponent } from './direccion/direccion.component';
import { SearchTitleComponent } from './search-title/search-title.component';
import { FormaDePagoComponent } from './forma-de-pago/forma-de-pago.component';
import { UsoCfdiComponent } from './uso-cfdi/uso-cfdi.component';
import { FechaDialogComponent } from './fecha-dilog/fecha.dialog.component';
import { PeriodoDialogComponent } from './periodo-dialog/periodo-dialog.component';
import { PeriodoPickerComponent } from './periodo-picker/periodo-picker.component';
import { UpperCaseFieldComponent } from './upper-case-field/upper-case-field.component';
import { DireccionFormComponent } from './direccion-form/direccion-form.component';
import { EjercicioFieldComponent } from './ejercicio-field/ejercicio-field.component';
import { MesFieldComponent } from './mes-field/mes-field.component';
import { MonedaFieldComponent } from './moneda-field/moneda-field.component';

export const components = [
  DireccionComponent,

  SearchTitleComponent,

  FormaDePagoComponent,
  UsoCfdiComponent,
  FechaDialogComponent,
  PeriodoDialogComponent,
  PeriodoPickerComponent,
  UpperCaseFieldComponent,
  DireccionFormComponent,
  EjercicioFieldComponent,
  MesFieldComponent,
  MonedaFieldComponent
];

export const entyComponents: any[] = [
  FechaDialogComponent,
  PeriodoDialogComponent
];

export * from './direccion/direccion.component';

export * from './search-title/search-title.component';
export * from './forma-de-pago/forma-de-pago.component';
export * from './uso-cfdi/uso-cfdi.component';
export * from './fecha-dilog/fecha.dialog.component';
export * from './periodo-dialog/periodo-dialog.component';
export * from './periodo-picker/periodo-picker.component';

export * from './upper-case-field/upper-case-field.component';
export * from './direccion-form/direccion-form.component';
export * from './ejercicio-field/ejercicio-field.component';
export * from './mes-field/mes-field.component';
export * from './moneda-field/moneda-field.component';
