import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { CurrentUserService } from '../services/current-user.service';
import { PurchaseService } from '../services/purchase.service';

import { CurrentUser } from '../models/CurrentUser';
import { PointsPurchaseModel } from '../models/PurchaseModel';


@Component({
  selector: 'app-points',
  templateUrl: './points.component.html',
  styleUrls: ['./points.component.css']
})
export class PointsComponent implements OnInit {

  model: any = { };
  commitable: boolean;
  user: CurrentUser;
  alert: any = {};
  constructor(private router: Router, private currentUserService: CurrentUserService, private purchaseService: PurchaseService) { }

  ngOnInit() {
    this.commitable = false;
    this.currentUserService.currentUser.subscribe(user => this.user = user);
  }

  setInfo() {
    this.commitable = true;
    window.document.getElementById('tab3').removeAttribute('style');
    window.document.getElementById('tab3').click();
    window.document.getElementById('tab2').setAttribute('style', 'pointer-events:none');
  }


  packetSet(num: number) {
    switch (num) {
      case 1: {
        this.model.points = 500;
        this.model.price = 5;
        break;
      }
        case 2: {
        this.model.points = 1025;
        this.model.price = 10;
        break;
      }
        case 3: {
        this.model.points = 2100;
        this.model.price = 20;
        break;
      }
        default: {
        this.model.points = 5300;
        this.model.price = 50;
        break;
      }
    }
    this.model.pointsCode = num;
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
    this.model.id = this.user.id;
    this.purchaseService.purchasePoints(new PointsPurchaseModel(this.model)).subscribe(
        data => {
          this.user.wallet = data.wallet;
          this.currentUserService.changeUser(this.user);
          this.alert.head = 'ΕΠΙΤΥΧΙΑ';
          this.alert.body = 'Τα εισιτήρια αγοράστικαν επιτυχώς! Θα σας αποσταλεί μαιλ με τα στοιχεία τους.';
        },
        error => {
          this.alert.head = 'Αποτυχία';
          this.alert.error = error.error;
        }
      );
    window.document.getElementById('openModalButton').click();
  }
}
