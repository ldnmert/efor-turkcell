import { Component, OnInit } from '@angular/core';
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
export class UserComponent implements OnInit {

  constructor(private userService:UserService){}

  ngOnInit(): void {
      this.getInfo();
  }
  


  infos: string[] = [];

  getInfo(): void {
   
  this.userService.getInfos()
  .subscribe(infos => {
    this.infos = infos;
    console.log(this.infos[3] + "sfdsfd");
   
});
      
  }



 

}
