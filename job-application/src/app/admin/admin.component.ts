import { Component } from '@angular/core';
import { JobserviceService } from '../jobservice.service';
import { Router } from '@angular/router';
import { User } from '../job';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  users:User[]=[];
  showTableFlag:boolean=false;

  
  constructor(private jobService: JobserviceService,private router:Router) { }


  getUsers(): void{
    this.jobService.getUsers().subscribe((users: User[])=>{
      this.users=users;
     console.log(this.users);
    },(error)=>{console.log(error)});
  }
  

  showTable() {
    this.showTableFlag = true;
    this.getUsers();
  }
}
