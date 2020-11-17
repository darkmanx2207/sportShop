import {Component, OnInit} from '@angular/core';
import {UserService} from '../service/User.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide = true;
  isOpenForm = false;
  login = 'Login';
  password = 'Password';
  loginValue = '';
  passwordValue = '';
  isUserLogin = false;
  isLoginError = false;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
  }

  onEnter() {
    if ((this.loginValue && this.passwordValue) !== '') {
      this.userService.getLoginAccess(this.loginValue, this.passwordValue).subscribe(isUserLogin => {
        this.isUserLogin = isUserLogin;

        if (!isUserLogin) {
          this.isLoginError = true;
        } else {
          this.isLoginError = false;
        }

        console.log(this.loginValue);
        console.log(this.passwordValue);
        console.log(this.isUserLogin);
      });
    }
  }

}
