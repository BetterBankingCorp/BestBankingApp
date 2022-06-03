import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-withdraw-deposit-transfer',
  templateUrl: './withdraw-deposit-transfer.component.html',
  styleUrls: ['./withdraw-deposit-transfer.component.css']
})
export class WithdrawDepositTransferComponent implements OnInit {

  ngOnInit(): void {
  }

  modalRef?: BsModalRef;
  constructor(private modalService: BsModalService) {}
 
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
}