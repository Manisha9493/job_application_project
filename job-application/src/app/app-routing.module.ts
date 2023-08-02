import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { JobFormComponent } from './job-form/job-form.component';
import { JobapplyFormComponent } from './jobapply-form/jobapply-form.component';
import { AdminComponent } from './admin/admin.component';

const routes: Routes = 
[
  { path: 'registration', component: RegistrationFormComponent },
  { path: 'login', component: LoginFormComponent },
  { path: 'job-form', component: JobFormComponent},
  { path: 'job-apply', component: JobapplyFormComponent},
  { path: 'admin', component: AdminComponent},
  { path: '', redirectTo: '/registration', pathMatch: 'full' }, // Default route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
