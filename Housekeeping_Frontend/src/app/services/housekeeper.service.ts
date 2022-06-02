import { Customers } from './../models/customers';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn: 'root',
 })

 export class HousekeeperService{
  newCustomerUpdates(customerPincode: string, customerEmail: string) {
    throw new Error('Method not implemented.');
  }
  deleteCustomer(customerEmail: string) {
    throw new Error('Method not implemented.');
  }
    private getAllCustomersUrl: string = 'http://localhost:8080/customers/getAllCustomers';
    private deleteCustomerByEmailUrl: string = 'http://localhost:8080/customers/deleteCustomer';
    private updateCustomerUrl: string = 'http://localhost:8080/customers/updateCustomer';
 
    constructor(private _httpClient: HttpClient) {}

     //customers
   getAllCustomers() {
    return this._httpClient.get<Customers[]>(this.getAllCustomersUrl);
 }
}