import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CurrentUser } from '../models/CurrentUser';
import { ProviderRegisterModel } from '../models/ProviderRegisterModel';

import { ProviderRegisterService } from '../services/provider-register.service';
import { CurrentUserService } from '../services/current-user.service';

@Component({
  selector: 'app-provider-register',
  templateUrl: './provider-register.component.html',
  styleUrls: ['./provider-register.component.css']
})
export class ProviderRegisterComponent implements OnInit {

  model: any = {};
  alert: boolean;
  logoFile: File = null;
  authFileList: FileList = null;
  user: CurrentUser;

  constructor(private currentUserService: CurrentUserService, private router: Router,
    private providerRegisterService: ProviderRegisterService) { }

  ngOnInit() {
    this.currentUserService.currentUser.subscribe(user => this.user = user);
  }

  providerRegister() {
    if (!this.logoFile) {
      this.alert = true;
      this.model.error = 'select logo pic';
    } else if (!this.authFileList) {
      this.alert = true;
      this.model.error = 'upload auth files';
    } else {
      this.alert = false;
      this.providerRegisterService.register(new ProviderRegisterModel(this.model), this.logoFile, this.authFileList)
      .subscribe(
        data => {
          this.currentUserService.changeUser(new CurrentUser(data));
          this.router.navigate(['/']);
        },
        error => {
          this.alert = true;
          this.model.error = error;
        }
      );
    }
  }

  logoChange(logo: any) {
    this.logoFile = logo[0];
  }

  authChange(auth: any) {
    this.authFileList = auth;
  }

}
