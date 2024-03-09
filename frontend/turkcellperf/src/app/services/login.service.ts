import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { }
  private agentId:string =  "";
  setAgentId(agentId:string){
    this.agentId = agentId;
  } 

  getAgentId():string{
    return this.agentId;
  }
}
