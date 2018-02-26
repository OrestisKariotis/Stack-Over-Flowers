import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-points',
  templateUrl: './points.component.html',
  styleUrls: ['./points.component.css']
})
export class PointsComponent implements OnInit {

  model: any = { };
  commitable: boolean;
  constructor(private router: Router) { }

  ngOnInit() {
    this.commitable = false;
  }

  setInfo() {
    this.commitable = true;
    window.document.getElementById('tab3').removeAttribute('style');
    window.document.getElementById('tab3').click();
    window.document.getElementById('tab2').setAttribute('style', 'pointer-events:none');
  }


  packetSet(num: number) {
    switch (num) {
      case 1:
        this.model.price = 5;
        this.model.points = 500;
        break;
      case 2:
        this.model.price = 10;
        this.model.points = 1025;
        break;
      case 3:
        this.model.price = 20;
        this.model.points = 2100;
        break;
      case 4:
        this.model.price = 50;
        this.model.points = 5300;
        break;
    }
    window.document.getElementById('tab2').removeAttribute('style');
    window.document.getElementById('tab2').click();
    window.document.getElementById('tab1').setAttribute('style', 'pointer-events:none');
  }

  buyReset() {
    this.model = {};
    this.commitable = false;
    this.router.navigate(['home']);
  }

  buySubmit() {
    // TODO
  }
}
