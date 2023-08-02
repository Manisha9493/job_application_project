import { Component } from '@angular/core';
import { JobserviceService } from '../jobservice.service';
import { AppliedJobs, JobApplication, User } from '../job';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-jobapply-form',
  templateUrl: './jobapply-form.component.html',
  styleUrls: ['./jobapply-form.component.css']
})
export class JobapplyFormComponent {
  isNewUser: boolean = false;
  jobapplication: JobApplication=new JobApplication();
  user: User=new User();
  createdUser: User;
  jobApplications: JobApplication[] = [];
  appliedJobs: AppliedJobs[]=[];
  constructor(private jobService: JobserviceService) {
    this.user.userId=0;
   }
    applyJobs(): void {
    this.jobapplication.userId = this.user.userId; 

    
    console.log('User object:', this.user);
    
    this.jobService.applyJob(this.user).subscribe((jobApplied: User)=>{

      this.user=jobApplied;
      
      console.log("job applied successfully");  
      alert('Job applied successfully');
      this.jobapplication = new JobApplication();

    }, (error: any)=>console.error("Error while applying for a job", error));
  
}  
// applyJobs(): void {
//   this.user.userId = this.user.userId;
  
//   // Create a new instance of User and JobApplication if it's a new user
//   if (this.isNewUser) {
//     this.user = new User();
//     this.user.jobApplications = [this.jobapplication];
//   } else {
//     // If it's not a new user, fetch the existing user and add the job application to it
//     this.jobService.getUserById(this.user.userId).subscribe((user: User) => {
//       this.user = user;
//       this.user.jobApplications.push(this.jobapplication);
//       this.saveUserWithJobApplication();
//     });
//   }

//   // Call the saveUserWithJobApplication method directly if it's a new user
//   if (this.isNewUser) {
//     this.saveUserWithJobApplication();
//   }
// }

saveUserWithJobApplication(): void {
  console.log('User object:', this.user);
  this.jobService.applyJob(this.user).subscribe(
    (jobApplied: User) => {
      this.user = jobApplied;
      console.log('job applied successfully');
      alert('Job applied successfully');
      // Reset the job application after successful submission
      this.jobapplication = new JobApplication();
    },
    (error: any) => console.error('Error while applying for a job', error)
  );
}


  
updateJobs(): void{
  this.jobService.updateJob(this.user).subscribe(data=>{
  console.log(data);
  }, error=> console.log(error));
}

deleteJob(){
  this.jobService.deleteJobs(this.user.userId).subscribe(data=>{
    console.log(data);
  }, error=> console.log(error));
}

getUsers(){
  this.jobService.getUsers().subscribe(data=>{
    console.log(data);
  },error=>console.log(error));
}






}

