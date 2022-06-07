import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  accounts : any = []
  URL : string = 'http://bankingapp.us-east-1.elasticbeanstalk.com/api/accounts'

  constructor(private http : HttpClient) { }
  

  getData() {
    return this.http.get(this.URL).subscribe(res => {
      this.accounts = res;
      console.log(this.accounts);
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
    })
  }

  //createAccount(accountType : string, formData : FormData) {
   // return this.http.post(this.URL + '/' + accountType, JSON.stringify(Object.fromEntries(formData))
 // }
  
}
