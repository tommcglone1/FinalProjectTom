import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginUser: User = new User();

  login(user: User){
    console.log("Logging in:")
    console.log(user);
    this.auth.login(user.username, user.password).subscribe({
      next: (loggedInUser) => {

        this.router.navigateByUrl('/home');
        this.ngOnInit();
      },
      error: (problem) => {
        console.error('RegisterComponent.register(): Error logging in user:');
        console.error(problem);
      }
    });
  }

  ngOnInit(){

  }

  constructor(private auth : AuthService, private router : Router){

  }

  loggedIn() : boolean {
    return this.auth.checkLogin();
  }
}
