import { Injectable } from '@angular/core';
import { AuthService } from './auth-service.service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { LoginComponent } from '../components/login/login.component';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  

  constructor(private authService: AuthService, private http: HttpClient) { }
  private baseUrl2 = "http://localhost:8080/profile-info"
  
  private agentId:string = "";

  getUserAgentId(agentId:string):void{
    this.agentId = agentId;
  }

  
  getInfos(): Observable<string[]> {
    const headers = this.authService.getAuthorizationHeaders();
    return this.http.get<string[]>(`${this.baseUrl2}/${this.agentId}`, { headers });
  }
}
