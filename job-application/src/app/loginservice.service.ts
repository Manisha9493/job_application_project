import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserRegistration, changePassword } from './UserRegistration';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  url: 'http://localhost:8083';
  responseType:string;

  constructor(
    private http: HttpClient) { }

    registration(userRegistration: UserRegistration): Observable<any> {
      return this.http.post<any>('http://localhost:8083/registration', userRegistration);
    }

  authenticate(userName: string, password: string): Observable<string>{
    return this.http.get(`http://localhost:8083/authenticate/${userName}/${password}`,{ responseType: 'text' });
  }

  changePassword(changePassword: changePassword): Observable<string>
  {
    return this.http.put<string>('http://localhost:8083/change-password',changePassword);
  }
}
