import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppliedJobs, JobApplication, User } from '../job';
import { JobserviceService } from '../jobservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-job-form',
  templateUrl: './job-form.component.html',
  styleUrls: ['./job-form.component.css']
})
export class JobFormComponent {
  @Input() showAdmin:boolean;
  jobTitle: string ="";
  showTableFlag = false;
  showTextFlag=false;
  jobapplication: JobApplication=new JobApplication();
  user: User=new User();
  createdUser: User;

  appliedJobs: AppliedJobs[]=[];
  constructor(private jobService: JobserviceService,private router:Router) { }


  showText()
  {
    this.showTextFlag =true;
  }
  
  showTable() {
    this.showTableFlag = true;
    this.getAppliedJobs();
  }
   
  getAppliedJobs():void{
    this.jobService.getAppliedJobs(this.user.userId).subscribe((appliedJobs: AppliedJobs[])=>
    {
      this.appliedJobs=appliedJobs;
    },(error)=>{console.error("Error while applying for a job", error)});
  }

  showTextBox():void{

  }
  applyButton():void{
    this.router.navigate(['/job-apply']);
  }

  applyJobs(): void {
    this.jobService.applyJob(this.user).subscribe((createdUser: User)=>{
      this.createdUser=createdUser;
      
    }, (error: any)=>console.error("Error while applying for a job", error));

    
  
}

}
