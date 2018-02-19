import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent-register',
  templateUrl: './parent-register.component.html',
  styleUrls: ['./parent-register.component.css']
})
export class ParentRegisterComponent implements OnInit {

  alert = false;
  model: any = {};
  constructor() { }

  ngOnInit() {
  }

  parentRegister() {
    if (this.model.password !== this.model.passRetype ) { return; }
    this.alert = !this.alert;
  }
}
