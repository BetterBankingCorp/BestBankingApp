import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  accounts : any = []

  constructor(private http : HttpClient) { }

  getData() {
    return this.http.get('http://localhost:8080/bestbanking_app/allaccounts').subscribe(res => {
      this.accounts = res;
      console.log(this.accounts);
    });
  }

}
