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

  

  constructor(private authService: AuthService, private http: HttpClient, private loginService:LoginService) { }
  private baseUrl2 = "localhost:8080/profile-infos"
  private agentId = this.loginService.getAgentId();
  
  getInfos(): Observable<string[]> {
    const headers = this.authService.getAuthorizationHeaders();
    return this.http.get<string[]>(`${this.baseUrl2}/GLB1111`, { headers });
  }
}
