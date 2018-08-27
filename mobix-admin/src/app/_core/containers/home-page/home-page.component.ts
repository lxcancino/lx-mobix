import { Component, OnInit } from '@angular/core';

import { Store, select } from '@ngrx/store';
import * as fromRoot from '../../../store';
import * as fromAuth from 'app/auth/store';
import { AuthSession } from 'app/auth/models/authSession';

import { of as observableOf, Observable } from 'rxjs';
import { AppConfig } from '../../../models/app-config';

@Component({
  selector: 'lx-home-page',
  templateUrl: './home-page.component.html',
  styles: []
})
export class HomePageComponent implements OnInit {
  application$: Observable<AppConfig>;
  session$: Observable<AuthSession>;

  constructor(private store: Store<fromAuth.AuthState>) {}

  ngOnInit() {
    this.application$ = this.store.pipe(select(fromRoot.getAppConfig));
    this.session$ = this.store.pipe(select(fromAuth.getSession));
  }
}
