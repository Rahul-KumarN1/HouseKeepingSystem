
import { Adminlogin } from 'src/app/models/adminlogin';
import { CustomersService } from './../../services/customers.service';
import { Customers } from './../../models/customers';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, NgForm } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  customer: Customers = new Customers();
  customerLoggedIn: String ='';
  router: any;
  constructor(private _customersService: CustomersService, private _router: Router, private _activatedRoute: ActivatedRoute, private _formBuilder: FormBuilder) {}
  ngOnInit(): void {}
  registerCustomer(f: NgForm): any {
      console.log('inside registerCustomer () !');

      this._customersService.registerCustomer(this.customer).subscribe((data) => {
         if (data) {
            alert('Successfully Registered !');
            f.reset();
         } else {
            alert('Phone Number Already Registered');
         }
      });
   }
  loginForm = this._formBuilder.group({
    customerEmail: '',
    customerPassword: '',
 });
  title = 'CRS_frontend';
  validateCustomer(): any {
    this._customersService.validateCustomer(this.loginForm.value).subscribe((data) => {
       if (data) {
          this.customerLoggedIn = this.loginForm.value['customerEmail'];
          this._customersService.setCustomerLoggedIn(this.customerLoggedIn.toString());

          console.log('Customer Exists : reached safely !', this.customerLoggedIn);
          this._router.navigateByUrl('/students');
       } else {
          console.log('Customer does not exists !');
          alert('Incorrect Details');
       }
    });
 }

}
