import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from '../service/User.service';
import {User} from '../model/User';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @ViewChild('form', null) form: NgForm;
  hide = true;
  login = 'Login';
  password = 'Password';
  isUserLogin = false;
  isLoginError = false;
  user: User;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
  }

  onEnter() {
    this.user = this.form.value;
    this.userService.getLoginAccess(this.user.login, this.user.password).subscribe(isUserLogin => {
      this.isUserLogin = isUserLogin;

      if (!isUserLogin) {
        this.isLoginError = true;
      } else {
        this.isLoginError = false;
      }

      this.form.reset();

      console.log(this.user.login);
      console.log(this.user.password);
      console.log(this.isUserLogin);
    });
  }
}
