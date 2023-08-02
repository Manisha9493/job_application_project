export class JobApplication {
jobId:number;
title:string="";
qualification:string="";
location:string="";
yearOfPassedOut:number;
percentage:number;
userId: number;
constructor(){}
}


export class User{
	userId: number;
	jobApplications: JobApplication[]=[];
    constructor(){
		this.jobApplications = []; 
	}
}

export class AppliedJobs{
    "userId": number;
	"jobId": number;
	"jobTitle": string;
	
}
