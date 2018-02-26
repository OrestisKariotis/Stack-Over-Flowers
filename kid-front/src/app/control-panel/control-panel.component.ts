import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-control-panel',
  templateUrl: './control-panel.component.html',
  styleUrls: ['./control-panel.component.css']
})
export class ControlPanelComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  responsive() {
    let x = window.document.getElementById('sidenav');
    if (x.className === 'sidenav') {
        x.className += ' responsive';
    } else {
        x.className = 'sidenav';
    }
}

  adminlogout() { }
}
