import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminPanelService {
  private baseUrl = 'http://localhost:8080/rest/filtered'; // Spring Boot API'nizin URL'si
  
  constructor(private http: HttpClient) { }

  filterPerformances(memberId: string, startDate: string, endDate: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}?memberId=${memberId}&startDate=${startDate}&endDate=${endDate}`);
  }
}
