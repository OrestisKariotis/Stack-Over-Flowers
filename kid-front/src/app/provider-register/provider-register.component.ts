import { Component, OnInit } from '@angular/core';
import { ProviderRegisterModel } from '../models/ProviderRegisterModel';

import { ProviderRegisterService } from '../services/provider-register.service';

@Component({
  selector: 'app-provider-register',
  templateUrl: './provider-register.component.html',
  styleUrls: ['./provider-register.component.css']
})
export class ProviderRegisterComponent implements OnInit {

  model: any = {};
  alert: boolean;
  popup: string;
  logoFile: File = null;
  authFileList: FileList = null;

  constructor(private providerRegisterService: ProviderRegisterService) { }

  ngOnInit() {
  }

  providerRegister() {
    this.alert = false;
    if (!this.logoFile) {
      this.model.error = 'select logo pic';
    } else if (!this.authFileList) {
      this.model.error = 'upload auth files';
    } else {
      this.model.id = 0;
      this.providerRegisterService.register(new ProviderRegisterModel(this.model), this.logoFile, this.authFileList)
      .subscribe(
        data => {
          this.alert = true;
          this.popup = 'H εγγραφή έχει υποβληθεί για αποδοχή. Θα σας αποσταλεί μαιλ σχετικά με την εξέλιξή της.';
        },
        error => {
          this.model.error = error.error;
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
