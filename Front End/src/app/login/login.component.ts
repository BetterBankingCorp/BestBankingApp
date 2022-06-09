import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public apiService : ApiService) { }

  ngOnInit(): void {
  }

  getDataByLogin(memberID : string, password : string) {
    this.apiService.getData(memberID, password)
  }
}
