import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountsAccordionComponent } from './accounts-accordion/accounts-accordion.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AccordionComponent, AccordionModule } from 'ngx-bootstrap/accordion';
import { ModalModule, BsModalService } from 'ngx-bootstrap/modal';
import { WithdrawDepositTransferComponent } from './accounts-accordion/withdraw-deposit-transfer/withdraw-deposit-transfer.component';
import { NavOptionsComponent } from './nav-options/nav-options.component';
import { LoginComponent } from './login/login.component';
import { UserRegistration } from './user-registration.model';
import { FormsModule } from '@angular/forms';

const routes: Routes = [
  { path: 'accounts', component: AccountsAccordionComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    AccountsAccordionComponent,
    WithdrawDepositTransferComponent,
    NavOptionsComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AccordionModule.forRoot(),
    HttpClientModule,
    ModalModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [BsModalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
