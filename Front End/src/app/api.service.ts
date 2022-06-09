import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserRegistration } from './user-registration.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  accounts : any = []
  URL : string = 'http://bankapp.us-east-1.elasticbeanstalk.com/api/accounts'

  constructor(private http : HttpClient) { }
  

  getDataModalClose() {
    return this.http.get(this.URL + '/all').subscribe(res => {
      console.log(res)
      this.accounts = res;
      console.log(this.accounts);
    });
  }

  getData(memberID ?: any, password ?: any) {
    if(password === "" || password == undefined) {
    return this.http.get(this.URL + '/all').subscribe(res => {
      this.accounts = res;
      console.log(this.accounts);
    });
    }
    else {
      console.log(password)
      return this.getDataByMemberID(memberID, password)
    }
  }

  getDataByMemberID(memberID : string, password : string) : any {
    return this.http.get(this.URL + '?memberID=' + memberID + '&password=' + password).subscribe(res => {
      this.accounts = res;
    });
  }

  withdraw(withdrawAmount : number, accountNum : string) {
    return this.http.patch(this.URL + '/withdraw/'+ accountNum, withdrawAmount).subscribe( res => {
      console.log(res)
      console.log(withdrawAmount)
    })
  }

  deposit(depositAmount : number, accountNum : string) {
    return this.http.patch(this.URL + '/deposit/'+ accountNum, depositAmount).subscribe( res => {
      console.log(res)
      console.log(depositAmount)
    })
  }

  transfer(transferAmount : number, fromAccountNum : string, toAccountNum : string) {
    return this.http.patch(this.URL + '/transfer/'+ fromAccountNum + "/" + toAccountNum + '/' + transferAmount, null).subscribe( res => {
      console.log(res)
      console.log(transferAmount)
      this.getDataModalClose()
    })
  }

  createAccount(name : string, SSN : string, accountType : string, memberID : string, password : string) {
    return this.http.post(this.URL + '/' + accountType, {
      "name" : name,
      "ssn" : SSN,
      "memberId" : memberID,
      "password" : password
  }).subscribe( res => {
      console.log(res)
      console.log(accountType)
    })
  }
  
}
