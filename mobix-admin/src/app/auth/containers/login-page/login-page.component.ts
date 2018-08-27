import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { Store, select } from '@ngrx/store';
import * as fromRoot from 'app/store';
import * as fromStore from '../../store';

import { Observable } from 'rxjs';
import { AppConfig } from '../../../models/app-config';

@Component({
  selector: 'lx-login-page',
  templateUrl: './login-page.component.html'
})
export class LoginPageComponent implements OnInit {
  application$: Observable<AppConfig>;
  loading$: Observable<boolean>;
  error$: Observable<any>;
  form: FormGroup;
  constructor(
    private fb: FormBuilder,
    private store: Store<fromStore.AuthState>
  ) {}

  ngOnInit() {
    this.application$ = this.store.pipe(select(fromRoot.getAppConfig));
    this.loading$ = this.store.select(fromStore.getAuthLoading);
    this.error$ = this.store.pipe(select(fromStore.getAuthError));

    this.form = this.fb.group({
      username: [null, [Validators.required, Validators.minLength(4)]],
      password: [null, [Validators.required, Validators.minLength(4)]]
    });
  }

  login() {
    if (this.form.valid) {
      this.store.dispatch(new fromStore.Login(this.form.value));
    }
  }
}
