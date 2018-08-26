import { Component, OnInit } from '@angular/core';

import { Store, select } from '@ngrx/store';
import * as fromRoot from '../../../store';

import { of as observableOf, Observable } from 'rxjs';
import { AppConfig } from '../../../models/app-config';
import { NavRoute } from '../../../models/nav-route';

@Component({
  selector: 'sx-main-page',
  templateUrl: './main-page.component.html',
  styles: []
})
export class MainPageComponent implements OnInit {
  navigation$: Observable<NavRoute[]>;

  usermenu: Array<{ icon: string; route: string; title: string }> = [
    {
      icon: 'swap_horiz',
      route: '.',
      title: 'Cambio de usuario'
    },
    {
      icon: 'tune',
      route: '.',
      title: 'Cuenta'
    },
    {
      icon: 'exit_to_app',
      route: '.',
      title: 'Salir del sistema'
    }
  ];

  appConfig$: Observable<AppConfig>;

  sidenavWidth = 300;

  constructor(private store: Store<fromRoot.State>) {}

  ngOnInit() {
    this.appConfig$ = this.store.pipe(select(fromRoot.getAppConfig));
    this.navigation$ = this.store.pipe(select(fromRoot.getMainNavigation));
  }
}
