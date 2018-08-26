import { Component, OnInit } from '@angular/core';

import { Store, select } from '@ngrx/store';
import * as fromRoot from './store';
import { NavRoute } from './models/nav-route';

@Component({
  selector: 'lx-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  mainNavigation: NavRoute[] = [
    {
      icon: 'home',
      path: '/',
      nombre: 'Inicio'
    }
  ];

  constructor(private store: Store<fromRoot.State>) {}

  ngOnInit() {
    this.store.dispatch(
      new fromRoot.SetMainNavigation({ mainNavigation: this.mainNavigation })
    );
  }
}

/**
 * navigation: Array<{ icon: string; route: string; title: string }> = [
    {
      icon: 'home',
      route: '/',
      title: 'Inicio'
    },
    {
      icon: 'storage',
      route: '/catalogos',
      title: 'Productos'
    },
    {
      icon: 'people',
      route: '/proveedores',
      title: 'Proveedores'
    },
    {
      icon: 'shopping_cart',
      route: '/ordenes',
      title: 'Ordenes'
    },
    {
      icon: 'my_library_books',
      route: '/cxp',
      title: 'Cuentas por pagar (CXP)'
    }
  ];
 */
