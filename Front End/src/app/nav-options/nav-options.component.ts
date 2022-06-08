import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-nav-options',
  templateUrl: './nav-options.component.html',
  styleUrls: ['./nav-options.component.css']
})
export class NavOptionsComponent implements OnInit {

  modalRef?: BsModalRef;

  constructor(private modalService : BsModalService, public apiService : ApiService) { }

  ngOnInit(): void {
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  closeModal() {
    this.modalRef?.hide()
    setTimeout( () => { 
      this.apiService.getData() 
    }, 300)
  }

  createAcc() {

  }

}
