import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import {
  StoreRouterConnectingModule,
  RouterStateSerializer
} from '@ngrx/router-store';
import { StoreModule, MetaReducer } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';

import { reducers, effects, CustomSerializer } from './store';

// Not used in production
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { storeFreeze } from 'ngrx-store-freeze';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './_shared/shared.module';
import { CoreModule } from './_core/core.module';
import { AuthModule } from './auth/auth.module';

import { environment } from '../environments/environment.prod';

export const metaReducers: MetaReducer<any>[] = !environment.production
  ? [storeFreeze]
  : [];

@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,

    // Ngrx Store configuration
    StoreModule.forRoot(reducers, { metaReducers }),
    StoreDevtoolsModule.instrument({
      name: 'MOBIX Dev Tools',
      logOnly: environment.production
    }),
    EffectsModule.forRoot(effects),
    StoreRouterConnectingModule,
    SharedModule,
    AuthModule.forRoot(),
    CoreModule
  ],
  providers: [{ provide: RouterStateSerializer, useClass: CustomSerializer }],
  declarations: [AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule {}
