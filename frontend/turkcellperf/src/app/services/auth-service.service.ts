import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private jwtToken: string = "";

  constructor(private http: HttpClient, private router: Router) {}

  isAdmin(): boolean {
    this.loadToken();
    const decodedToken = this.decodeToken(this.jwtToken);
    return decodedToken.roleName === 'ROLE_ADMIN';
  }

  isUser(): boolean {
   this.loadToken();
    const decodedToken = this.decodeToken(this.jwtToken);
    return decodedToken.roleName === 'ROLE_USER';
  }

  decodeToken(token: string): any {
    const tokenParts = token.split('.');
    if (tokenParts.length !== 3) {
      throw new Error('Invalid JWT token');
    }

    const payload = JSON.parse(atob(tokenParts[1]));
    return payload;
  }


  login(credentials: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/login', credentials, { observe: 'response' })
      .pipe(
        tap(response => {
  
          if (response.status === 200) {
            const token = response.body.token;
            if (token) {
              const decodedToken = this.decodeToken(token);
              console.log(token + " girdi");
              this.saveToken(token);
             
                if (decodedToken.roleName === 'ROLE_USER') {
                  console.log("qweasdzxc");
                
                  this.router.navigate(['/performance-table']);
                } else if (decodedToken.roleName === 'ROLE_ADMIN') {
                  this.router.navigate(['/admin-table']);
                } else {
          
                }
            }
          }
        })
      );
  }

  // JWT'yi saklamak için bir yöntem
  saveToken(token: string) {
    this.jwtToken = token;
    localStorage.setItem('token', token);
  }

  // Her HTTP isteğinde JWT'nin Authorization başlığı altında gönderilmesi
  loadToken() {
    this.jwtToken = localStorage.getItem('token')!;
  }

  getAuthorizationHeaders(): HttpHeaders {
    console.log()
    this.loadToken();
    return new HttpHeaders({ 'Authorization': 'Bearer ' + this.jwtToken });
  }

  // Çıkış işlemi, JWT'yi temizle
  logout() {
    this.jwtToken = null!;
    localStorage.removeItem('token');
  }
}
