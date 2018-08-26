import {
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  Params
} from '@angular/router';
import {
  ActionReducerMap,
  createFeatureSelector,
  createSelector
} from '@ngrx/store';
import * as fromRouter from '@ngrx/router-store';
import * as fromApplication from './application.reducer';
import { state } from '@angular/animations';

export interface RouterStateUrl {
  url: string;
  queryParams: Params;
  params: Params;
  parentParams?: Params;
}

export interface State {
  routerReducer: fromRouter.RouterReducerState<RouterStateUrl>;
  application: fromApplication.State;
}

export const reducers: ActionReducerMap<State> = {
  routerReducer: fromRouter.routerReducer,
  application: fromApplication.reducer
};

export const getRouterState = createFeatureSelector<
  fromRouter.RouterReducerState<RouterStateUrl>
>('routerReducer');

export const getApplicationState = (state: State) => state.application;

export const getAppConfig = createSelector(
  getApplicationState,
  fromApplication.getAppConfig
);

export const getMainNavigation = createSelector(
  getApplicationState,
  fromApplication.getMainNavigation
);

export class CustomSerializer
  implements fromRouter.RouterStateSerializer<RouterStateUrl> {
  serialize(routerState: RouterStateSnapshot): RouterStateUrl {
    const { url } = routerState;
    const { queryParams } = routerState.root;

    let state: ActivatedRouteSnapshot = routerState.root;
    while (state.firstChild) {
      state = state.firstChild;
    }
    const { params } = state;
    let parentParams;
    if (state.parent) {
      // console.log('Adding parrent params: ', state);
      parentParams = state.parent.params;
    }

    return { url, queryParams, params, parentParams };
  }
}
