import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  accounts : any = []

  constructor(private http : HttpClient) { }

  getData() {
    return this.http.get('http://localhost:8080/api/accounts').subscribe(res => {
      this.accounts = res;
      console.log(this.accounts);
    });
  }

  withdraw(withdrawAmount : number, accountNum : string) {
    return this.http.patch('http://localhost:8080/api/accounts/withdraw/'+ accountNum, withdrawAmount).subscribe( res => {
      console.log(res)
      console.log(withdrawAmount)
    })
  }

  deposit(depositAmount : number, accountNum : string) {
    return this.http.patch('http://localhost:8080/api/accounts/deposit/'+ accountNum, depositAmount).subscribe( res => {
      console.log(res)
      console.log(depositAmount)
    })
  }
  
}
