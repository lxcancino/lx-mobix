import { Action } from '@ngrx/store';
import {
  ApplicationActions,
  ApplicationActionTypes
} from '../actions/aplication.actions';

import { AppConfig } from '../../models/app-config';
import { NavRoute } from '../../models/nav-route';

export interface State {
  config: AppConfig;
  mainNavigation: NavRoute[];
}

export const initialState: State = {
  config: {
    nombre: 'App Nombre',
    descripcion: 'App Descripción',
    header: 'App Header',
    version: '1.0.0'
  },
  mainNavigation: []
};

export function reducer(
  state = initialState,
  action: ApplicationActions
): State {
  switch (action.type) {
    case ApplicationActionTypes.SetAppConfig: {
      const config = action.payload.config;
      return {
        ...state,
        config
      };
    }
    case ApplicationActionTypes.SetMainNavigation: {
      const mainNavigation = action.payload.mainNavigation;
      return {
        ...state,
        mainNavigation
      };
    }

    default:
      return state;
  }
}

export const getAppConfig = (state: State) => state.config;
export const getMainNavigation = (state: State) => state.mainNavigation;
