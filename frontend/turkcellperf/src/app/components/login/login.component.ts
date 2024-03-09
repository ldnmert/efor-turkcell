// login.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth-service.service';
import { LoginService } from '../../services/login.service';
import { UserService } from '../../services/user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  agentId: string = '';
  password: string = '';
  errorMessage: string = '';




  constructor(private authService: AuthService, private userService:UserService) {}

  

  login() {
    const credentials = {
      agentId: this.agentId,
      password: this.password
    };

    this.authService.login(credentials).subscribe(
      () => {   

        this.userService.getUserAgentId(credentials.agentId);
        console.log("girmesi lazim")
        // Başarılı giriş durumunda performans tablosuna yönlendir
        // this.router.navigate(['/performance-table']);
      },
      (error) => {
        // Hata durumunda hata mesajını göster
        this.errorMessage = 'Giriş yapılamadı. Lütfen kullanıcı adı ve şifrenizi kontrol edin.';
      }
    );
  }
}
