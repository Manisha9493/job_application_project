import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm} from '@angular/forms';
import { UserRegistration, changePassword } from '../UserRegistration';
import { JobserviceService } from '../jobservice.service';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent{
  // firstName:string="";
  // lastName:string="";
  // userName:string="";
  // password:string="";
  // repass:string="";
  // email:string=""; dob:string=""; phone:string="";
  formErrors:any={};
  gender:string;

  

  userRegistration: UserRegistration=new UserRegistration();

  changePassword:changePassword=new changePassword();
  constructor(private loginService: LoginserviceService, private router:Router) { }
  data: any;

  onSubmit(form: NgForm): void {
    if (form.invalid) {
      if(!this.userRegistration.userName || !this.userRegistration.firstName || !this.userRegistration.email || !this.userRegistration.password
        || !this.userRegistration.dob || this.userRegistration.phone || this.userRegistration.repass)
        { this.formErrors = {};
          this.formErrors = {
            
  
              firstName: !this.userRegistration.firstName ? 'Please Enter FirstName' : null,
        
              userName: !this.userRegistration.userName ? 'Please Enter UserName' : null,
        
              email: !this.userRegistration.email ? 'Please  Enter email' : null,
        
              dob: !this.userRegistration.dob ? 'Please Enter dob' : null,
              password: !this.userRegistration.password? 'Please Enter Password' : null,
              phone: !this.userRegistration.phone ? 'Please Enter phone' : null,
              repass: !this.userRegistration.repass? 'Please Enter repassword': null
        
            };  
      
      return;
    }

    // The form is valid, proceed with registration.
    this.register();
  }
}
  register(): void {
    
    // if(!this.userRegistration.userName || !this.userRegistration.firstName || !this.userRegistration.email || !this.userRegistration.password
    //   || !this.userRegistration.dob || this.userRegistration.phone || this.userRegistration.repass)
    //   { this.formErrors = {};
    //     this.formErrors = {
          

    //         firstName: !this.userRegistration.firstName ? 'Please Enter FisrtName' : null,
      
    //         userName: !this.userRegistration.userName ? 'Please Enter UserName' : null,
      
    //         email: !this.userRegistration.email ? 'Please  Enter email' : null,
      
    //         dob: !this.userRegistration.dob ? 'Please Enter dob' : null,
    //         password: !this.userRegistration.password? 'Please Enter Password' : null,
    //         phone: !this.userRegistration.phone ? 'Please Enter phone' : null,
    //         repass: !this.userRegistration.repass? 'Please Enter repassword': null
      
    //       };
      
    //       return;
    //     }

    this.loginService.registration(this.userRegistration).subscribe(
      (response) => {
        this.data=response;
        console.log('User registerted successfully with ID!'+this.data); 
        alert('User Registered Successfully');
      },
      (error: any) => {
        console.error("Error while registering user", error); 
      }
    );
    this.router.navigate(['/login']);
  }
  

  

  changingPassword():void{
    this.loginService.changePassword(this.changePassword).subscribe(
      data=>{
        console.log(data);
      },(error: any)=>
      console.error("Error changing password", error)
    );
  }


  selectedButton: string = '';

  onGenderChange(buttonValue: string): void {
    this.gender = buttonValue;
    this.userRegistration.gender=this.gender;
    console.log('Selected Button:', this.gender);
  }
}
