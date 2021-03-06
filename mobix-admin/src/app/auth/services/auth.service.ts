import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { catchError, delay } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';

import { Authenticate } from '../models/authenticate';
import { AuthSession, readFromStore } from '../models/authSession';
import { environment } from 'environments/environment';

@Injectable()
export class AuthService {
  constructor(private http: HttpClient) {}

  login(authenticate: Authenticate): Observable<any> {
    const url = `${environment.apiUrl}/login`;
    return this.http
      .post<any>(url, authenticate)
      .pipe(catchError((error: any) => throwError(error)));
  }

  getToken() {
    if (this.session) {
      return this.session.access_token;
    }
    return null;
  }

  get session() {
    return readFromStore();
  }
}
