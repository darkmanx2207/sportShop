import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UserService} from '../../service/User.service';
import {User} from '../../model/User';
import {ActivatedRoute, Route, Router} from '@angular/router';
import {DataService} from '../../service/DataService';
import {Protein} from '../../model/Protein';


@Component({
  selector: 'app-edit-general-info',
  templateUrl: './edit-general-info.component.html',
  styleUrls: ['./edit-general-info.component.css']
})
export class EditGeneralInfoComponent implements OnInit {

  @Output() newItemEvent = new EventEmitter<number>();

  constructor(private userService: UserService,
              private router: Router,
              private sharedData: DataService) {
  }

  ngOnInit() {
  }

  getProtein(id: number) {
    this.sharedData.sharedData = id;
    this.router.navigateByUrl('/protein');
  }

  getListofProteins(type: string) {
    this.sharedData.type = type;
    this.router.navigateByUrl('/proteins');
  }
}
