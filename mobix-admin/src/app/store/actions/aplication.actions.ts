import { Action } from '@ngrx/store';
import { AppConfig } from '../../models/app-config';
import { NavRoute } from '../../models/nav-route';

export enum ApplicationActionTypes {
  SetAppConfig = '[Aplication] Set AppConfig',
  SetMainNavigation = '[Aplication] Set Main navigation'
}

export class SetAppConfig implements Action {
  readonly type = ApplicationActionTypes.SetAppConfig;
  constructor(public payload: { config: AppConfig }) {}
}

export class SetMainNavigation implements Action {
  readonly type = ApplicationActionTypes.SetMainNavigation;
  constructor(public payload: { mainNavigation: NavRoute[] }) {}
}

export type ApplicationActions = SetAppConfig | SetMainNavigation;
