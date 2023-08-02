import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserRegistration } from '../UserRegistration';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {
  userRegistration: UserRegistration=new UserRegistration();
  constructor(private loginService: LoginserviceService, private router:Router) { }

  selectedGender: any = '';
  data:string;
  showAdmin:boolean=false;

  genderArr = [
    {
      label:'Male',
      value: 'Male'
    },
    {
      label:'Female',
      value: 'Female'
    },
    {
      label:'Others',
      value: 'Others'
    },
  ];
  authentication(): void {
    if (this.userRegistration.userName === "admin" && this.userRegistration.password === "admin") {
      this.showAdmin = true;
      this.router.navigate(['/admin']);
    }

    this.loginService.authenticate(this.userRegistration.userName, this.userRegistration.password).subscribe(
      (response) => { // Assuming the response is a string
        this.data = response;
        console.log(this.data);
        this.router.navigate(['/job-form']);
      },
      (error: any) => {
        this.data = error;
        console.error("Error authenticating user", error);
      }
    );
  }
}


  
