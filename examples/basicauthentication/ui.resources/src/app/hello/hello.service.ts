import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HelloService {

  serverUrl: string = environment.BACKEND_URL + '/service/auth/users';

  constructor(private http: HttpClient) { }

  getHelloWorldFromService(): string {
    return 'hello world from the service';
  }

  getHelloWorldFromJava(): Observable<any> {
    return this.http.get(this.serverUrl);
  }

  // New method to get users from the API
  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(this.serverUrl);
  }

  // Method to register a new user
  registerUser(user: any): Observable<any> {
    const registerUrl = environment.BACKEND_URL + '/service/auth/register';
    return this.http.post(registerUrl, user);
  }
}
