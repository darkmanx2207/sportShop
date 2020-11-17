import { Component, OnInit } from '@angular/core';
import {UserService} from '../../service/User.service';
import {User} from '../../model/User';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  login = 'Login';
  email = 'E-mail';
  loginValue = '';
  emailValue = '';
  password = 'Password';
  passwordValue = '';
  user: User = new User();

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  registration() {
    this.user.login = this.loginValue;
    this.user.password = this.passwordValue;
    this.user.email = this.emailValue;

    this.userService.createUser(this.user).subscribe();
    console.log(this.loginValue, this.emailValue, this.passwordValue);
  }
}
