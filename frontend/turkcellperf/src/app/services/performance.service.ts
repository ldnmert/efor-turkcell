import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Performance } from '../model/performance'; 

@Injectable({
  providedIn: 'root'
})
export class PerformanceService {

  private baseUrl = 'http://localhost:8080/rest'; 
  constructor(private http: HttpClient) { }

  getPerformances(): Observable<Performance[]> {
    return this.http.get<Performance[]>(`${this.baseUrl}`);
  }

  deletePerformance(id: number): Observable<any> {
    console.log(id);
    console.log(id);
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<void>(url);
    
  }
  addPerformance(performance: Performance): Observable<Performance> {
    return this.http.post<Performance>(`${this.baseUrl}`, performance);
  }

  updatePerformance(performance: Performance): Observable<Performance> {
    const url = `${this.baseUrl}/${performance.id}`;
    return this.http.put<Performance>(url, performance);
  }

}