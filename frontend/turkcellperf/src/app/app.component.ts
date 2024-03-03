import { Component } from '@angular/core';
// import { AuthService } from './auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  isAdmin: boolean = false;
  title = 'turkcellperf';
  
  // constructor(private authService: AuthService) {
  //   // Kullanıcının rolüne göre isAdmin değişkenini güncelle
  //   this.isAdmin = this.authService.isAdmin();
  // }

}
