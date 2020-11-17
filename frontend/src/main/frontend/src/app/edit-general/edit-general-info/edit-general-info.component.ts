import {Component, OnInit} from '@angular/core';
import {UserService} from '../../service/User.service';
import {User} from '../../model/User';
import {ActivatedRoute, Route} from '@angular/router';


@Component({
  selector: 'app-edit-general-info',
  templateUrl: './edit-general-info.component.html',
  styleUrls: ['./edit-general-info.component.css']
})
export class EditGeneralInfoComponent implements OnInit {

  constructor(private userService: UserService) {
  }

  ngOnInit() {
  }

  getProtein() {

  }
}
