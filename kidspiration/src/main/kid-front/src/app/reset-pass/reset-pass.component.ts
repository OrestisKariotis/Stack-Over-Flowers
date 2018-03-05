import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { NewPassService } from '../services/new-pass.service';

@Component({
  selector: 'app-reset-pass',
  templateUrl: './reset-pass.component.html',
  styleUrls: ['./reset-pass.component.css']
})
export class ResetPassComponent implements OnInit {

  model: any = {};
  alert = false;
  di: string;
  lsta: string;

  constructor( private router: Router , private route: ActivatedRoute , private nPService: NewPassService ) { }

  ngOnInit() {
    this.model.mode = 'parent';
    this.route.queryParams.subscribe(params => {
      this.di = params['di'];
      this.lsta = params['lsta'];
    });
  }

  resetPass() {
    this.alert = false;
    this.nPService.resetPass(this.model.password, this.model.mode, this.di, this.lsta)
      .subscribe(
        data => {
          this.router.navigate(['/']);
        },
        error => {
          this.alert = true;
          this.model.error = error.error;
        }
      );
  }

}
