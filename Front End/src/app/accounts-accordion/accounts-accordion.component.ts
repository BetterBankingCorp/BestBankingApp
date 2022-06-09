import { Component, OnInit, TemplateRef } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-accounts-accordion',
  templateUrl: './accounts-accordion.component.html',
  styleUrls: ['./accounts-accordion.component.css']
})
export class AccountsAccordionComponent implements OnInit {

  moveAmount !: number

  constructor(public apiService : ApiService) { }

  ngOnInit(): void {
  }

}
