import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Performance } from '../model/performance'; 
import { response } from 'express';
import { AuthService } from './auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class PerformanceService {

  private baseUrl = 'http://localhost:8080/rest'; 
  constructor(private http: HttpClient, private authService: AuthService) { }
  private agentId:string = "";

  getUserAgentId(agentId: string): void {
    this.agentId = agentId;

  }

  getPerformances(): Observable<Performance[]> {
    const headers = this.authService.getAuthorizationHeaders();
    return this.http.get<Performance[]>(`${this.baseUrl}/${this.agentId}`, { headers });
  }

  deletePerformance(id: number): Observable<any> {
    const headers = this.authService.getAuthorizationHeaders();
    console.log(id);
    console.log(id);
    return this.http.delete<void>(`${this.baseUrl}/${id}` ,{ headers } );
    
  }
  addPerformance(performance: Performance): Observable<Performance> {
    const headers = this.authService.getAuthorizationHeaders();
    return this.http.post<Performance>(`${this.baseUrl}`, performance, { headers });
  }
  
  updatePerformance(performance: Performance): Observable<Performance> {
    const url = `${this.baseUrl}/${performance.id}`;
    const headers = this.authService.getAuthorizationHeaders();
    return this.http.put<Performance>(url, performance, { headers });
  }
  



}