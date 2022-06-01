import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-accounts-accordion',
  templateUrl: './accounts-accordion.component.html',
  styleUrls: ['./accounts-accordion.component.css']
})
export class AccountsAccordionComponent implements OnInit {

  constructor(public apiService : ApiService) { }

  ngOnInit(): void {
    this.apiService.getData();
    console.log(this.apiService.getData());
  }


}
