import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/service/token';

@Component({
  selector: 'app-logo-ap',
  templateUrl: './logo-ap.component.html',
  styleUrls: ['./logo-ap.component.css']
})
export class LogoAPComponent implements OnInit {
  isLogged = false;
  
  constructor(private router:Router, private tokeService: TokenService) {}

  ngOnInit(): void {
    if(this.tokeService.getToken()){
      this.isLogged=true;
    }else{
      this.isLogged=false;
    }
  }

  onLogOut():void{
    this.tokeService.logOut();
    window.location.reload();
  }

  login(){
    this.router.navigate(['/login'])
  }

}
