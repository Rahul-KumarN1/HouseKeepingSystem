import { Customers } from './../../models/customers';
import { StudentsService} from './../../services/students.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  viewCustomersStatus: boolean = false;
  updateCustomerStatus: boolean = false;
  customerUpdating: Customers = new Customers();

  customers: Customers[] = [];

  constructor(private route: Router) { }

  ngOnInit(): void {
  }

}
