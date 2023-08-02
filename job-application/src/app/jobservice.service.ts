import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { AppliedJobs, User } from './job';

@Injectable({
  providedIn: 'root'
})
export class JobserviceService {
  url = 'http://localhost:8082';

  constructor(
    private http: HttpClient) { }

  applyJob(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8082/applyjob', user);
  }
  getUserById(userId: number): Observable<User> {
    return this.http.get<User>(`http://localhost:8082/users/${userId}`);
  }

  getAppliedJobs(id: number): Observable<AppliedJobs[]> {
    return this.http.get<AppliedJobs[]>(`http://localhost:8082/get-applied-jobs/${id}`);

  }
  updateJob(user: User): Observable<string> {
    return this.http.put<string>('http://localhost:8082/update-jobs', user);

  }

  deleteJobs(id: number): Observable<string>{
    return this.http.delete<string>('http://localhost:8082/delete-jobs/${id}');
  }

  getUsers(): Observable<User[]>
  { return this.http.get<User[]>('http://localhost:8082/getUsers');

  }

}




