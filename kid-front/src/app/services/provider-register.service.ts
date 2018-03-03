import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { ProviderRegisterModel } from '../models/ProviderRegisterModel';
import { CurrentUser } from '../models/CurrentUser';
@Injectable()
export class ProviderRegisterService {

  constructor(private http: HttpClient) { }

  register(provider: ProviderRegisterModel, logo: File, authdocs: FileList) {

    let fd = new FormData();
    fd.append('data', JSON.stringify(provider));
    fd.append('logo', logo);
    for (let i = 0; i < authdocs.length; i++ ) {
      let auth = authdocs[i];
      if (auth) {
        fd.append('file', auth);
      }
    }
    return this.http.post<CurrentUser>('/api/register/provider', fd);
  }
}
