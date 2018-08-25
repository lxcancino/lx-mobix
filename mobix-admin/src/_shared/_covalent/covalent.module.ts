import { NgModule } from '@angular/core';
import {
  CovalentMediaModule,
  CovalentLoadingModule,
  CovalentNotificationsModule,
  CovalentLayoutModule,
  CovalentMenuModule,
  CovalentPagingModule,
  CovalentSearchModule,
  CovalentCommonModule,
  CovalentDialogsModule,
  CovalentMessageModule
} from '@covalent/core';

const COVALENT_MODULES: any[] = [
  CovalentMediaModule,
  CovalentLoadingModule,
  CovalentNotificationsModule,
  CovalentLayoutModule,
  CovalentMenuModule,
  CovalentPagingModule,
  CovalentSearchModule,
  CovalentCommonModule,
  CovalentDialogsModule,
  CovalentMessageModule
];

@NgModule({
  imports: [COVALENT_MODULES],
  exports: [COVALENT_MODULES],
  declarations: []
})
export class CovalentModule {}
