import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-register',
  templateUrl: './event-register.component.html',
  styleUrls: ['./event-register.component.css']
})
export class EventRegisterComponent implements OnInit {

  model: any = {};

  constructor() { }

  ngOnInit() {
  }

  eventRegister() { }

}
