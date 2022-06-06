import { Component, OnInit, Input, TemplateRef } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { ApiService } from 'src/app/api.service';
import { AccountsAccordionComponent } from '../accounts-accordion.component';

@Component({
  selector: 'app-withdraw-deposit-transfer',
  templateUrl: './withdraw-deposit-transfer.component.html',
  styleUrls: ['./withdraw-deposit-transfer.component.css']
})
export class WithdrawDepositTransferComponent implements OnInit {

  @Input('accountNum') currentAccountNum : any
  moveAmount !: any

  ngOnInit(): void {
  }

  modalRef?: BsModalRef;

  constructor(private modalService: BsModalService, public apiService : ApiService) {}

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  closeModal() {
    this.modalRef?.hide()
    setTimeout( () => { 
      this.apiService.getData() 
    }, 300)
  }

  getUserInputAmount(value : string) : number {
    var moveAmount = parseInt(value)
    return moveAmount
  }
  
  withdrawAcc(withdrawAmount : number) {
    this.apiService.withdraw(withdrawAmount, this.currentAccountNum)
    console.log(withdrawAmount)
    console.log(this.currentAccountNum)
  }

  depositAcc(depositAmount : number) {
    this.apiService.deposit(depositAmount, this.currentAccountNum)
    console.log(depositAmount)
    console.log(this.currentAccountNum)
  }
}