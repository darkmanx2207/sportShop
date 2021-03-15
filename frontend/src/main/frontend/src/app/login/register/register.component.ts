import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from '../../service/User.service';
import {User} from '../../model/User';
import {Observable} from 'rxjs/Observable';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  @ViewChild('form', null) form: NgForm;
  login = 'Login';
  email = 'E-mail';
  password = 'Password';
  user: User = new User();
  hero: {};

  constructor(private userService: UserService) {
  }

  ngOnInit() {
  }

  registration() {
    this.user = this.form.value;
    this.userService.createUser(this.user).subscribe();
    this.form.reset();
    console.log(this.user);
  }

  submited() {
    this.hero = this.form.value;
    console.log('submit', this.form);
    console.log(this.hero);
  }
}
