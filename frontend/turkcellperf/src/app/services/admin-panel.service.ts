import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class AdminPanelService {
  private baseUrl = 'http://localhost:8080/admin/filtered'; 
  
  constructor(private http: HttpClient, private authService: AuthService) { }

  filterPerformances(memberId: string, startDate: string, endDate: string): Observable<any> {
    const headers = this.authService.getAuthorizationHeaders();
    return this.http.get<any>(`${this.baseUrl}?memberId=${memberId}&startDate=${startDate}&endDate=${endDate}`, {headers});
  }
}
