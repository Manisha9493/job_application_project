import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { RouterModule} from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule} from '@angular/forms';
import { JobFormComponent } from './job-form/job-form.component';

import { HttpClientModule } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { LoginFormComponent } from './login-form/login-form.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { JobapplyFormComponent } from './jobapply-form/jobapply-form.component';
import { JobserviceService } from './jobservice.service';
import { LoginserviceService } from './loginservice.service';
import { ReactiveFormsModule } from '@angular/forms';
import { AdminComponent } from './admin/admin.component';


@NgModule({
  declarations: [
    AppComponent,
    JobFormComponent,
    LoginFormComponent,
    RegistrationFormComponent,
    JobapplyFormComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule

  ],
  providers: [JobserviceService, LoginserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }