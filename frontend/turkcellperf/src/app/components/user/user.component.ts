import { Component } from '@angular/core';
import { AuthService } from '../../services/auth-service.service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { LoginComponent } from '../login/login.component';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  constructor(private userService:UserService){}

  private baseUrl = "localhost:8080/profile-infos"
  


  infos: string[] = [];

  getInfo(): void {
   
  this.userService.getInfos()
      .subscribe(infos => this.infos = infos);
  }

 

}
