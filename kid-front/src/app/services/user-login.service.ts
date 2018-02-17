import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OnInit } from '@angular/core';



@Injectable()
export class UserLoginService implements OnInit {

  private backend: string;

  constructor(private http: HttpClient) { }

  ngOnInit() {  }

}
