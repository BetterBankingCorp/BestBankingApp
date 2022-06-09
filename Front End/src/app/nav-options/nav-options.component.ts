import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators, FormGroup, FormBuilder } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { UserRegistration } from '../user-registration.model';

import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { ApiService } from '../api.service';


@Component({
  selector: 'app-nav-options',
  templateUrl: './nav-options.component.html',
  styleUrls: ['./nav-options.component.css']
})
export class NavOptionsComponent implements OnInit {

  modalRef ?: BsModalRef;
  userPostAcc ?: UserRegistration;
  accountType : any
  memberID !: string
  password !: string

  constructor(private modalService : BsModalService, public apiService : ApiService) { }

  ngOnInit(): void {
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  closeModal() {
    this.modalRef?.hide()
    setTimeout( () => { 
      this.apiService.getData(this.memberID, this.password) 
    }, 300)
  }

  createAcc(firstName : string, lastName : string, SSN : string, password : string, accountType : string) {
    var name : string = firstName + " " + lastName
    this.memberID = "88" + (Math.floor(Math.random() * (9999999 - 1000000 + 1)) + 1000000)
    this.password = password
    this.apiService.createAccount(name, SSN, accountType, this.memberID, password)
  }

  setRadioValue(value : string) {
    this.accountType = value
    console.log(this.accountType)
  }
}