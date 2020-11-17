import {Component} from '@angular/core';
import {UserService} from './service/User.service';
import {User} from './model/User';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  /*title = 'app works!';
  user: User [];
  test = '';

  constructor(private userService: UserService) {
  }

  getUser() {
    this.userService.getUser(1)
      .subscribe((user: User[]) => {
        console.log(user);
        this.user = user;
      });
  }

  loadUsers() {
    this.userService.getUsers()
      .subscribe((response) => {
        // const data = response.json();
        console.log(response);
      });
  }*/


}
