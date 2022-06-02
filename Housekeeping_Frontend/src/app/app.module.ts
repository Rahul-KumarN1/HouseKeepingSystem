import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomersComponent } from './components/customers/customers.component';
import { ManagersComponent } from './components/managers/managers.component';
import { EngineersComponent } from './components/engineers/engineers.component';
import { ComplaintsComponent } from './components/complaints/complaints.component';
import { FeedbacksComponent } from './components/feedbacks/feedbacks.component';
import { AdminComponent } from './components/admin/admin.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { StudentsComponent } from './components/students/students.component';
import { RoomsComponent } from './components/rooms/rooms.component';
import { HousekeeperComponent } from './components/housekeeper/housekeeper.component';



const routers: Routes = [
   { path: 'home', component: HomeComponent },
   { path: 'adminlogin', component: AdminLoginComponent },
   { path: 'admin', component: AdminComponent },
   { path: 'customers', component: CustomersComponent },
   { path: 'customers/registerComplaints', component: ComplaintsComponent },
   { path: 'feedbacks/sendFeedback', component: FeedbacksComponent },
   { path: 'students', component:StudentsComponent },
   { path: 'rooms', component:RoomsComponent },
   { path: 'housekeeper', component:HousekeeperComponent},
   { path: 'engineers', component: EngineersComponent },
   { path: 'managers', component: ManagersComponent },
   { path: 'aboutus', component: AboutusComponent },
   { path: 'contact', component: ContactComponent },
   { path: 'complaint', component: ComplaintsComponent },

   { path: '', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
   declarations: [
      AppComponent,
      CustomersComponent,
      ManagersComponent,
      EngineersComponent,
      ComplaintsComponent,
      FeedbacksComponent,
      AdminComponent,
      AboutusComponent,
      ContactComponent,
      HomeComponent,
      AdminLoginComponent,
      StudentsComponent,
      RoomsComponent,
      HousekeeperComponent,
      ComplaintsComponent,
    
      
      
   ],
   imports: [RouterModule.forRoot(routers), BrowserModule, AppRoutingModule, FormsModule, HttpClientModule, ReactiveFormsModule],
   providers: [],
   bootstrap: [AppComponent],
})
export class AppModule {}
