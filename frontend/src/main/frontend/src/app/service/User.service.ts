import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {User} from '../model/User';
import {catchError} from 'rxjs/operators';


@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  getUser(id: number) {
    return this.http.get(`http://localhost:8080/user/${id}`);
    // .pipe(map((response: Response) => response.json()));
  }

  getUsers() {
    return this.http.get(`http://localhost:8080/user`);
    // .pipe(map((response: Response) => response.json()));
  }

  getLoginAccess(login: string, password: string): Observable<boolean> {
    return this.http.get<boolean>(`http://localhost:8080/user/login/${login}/password/${password}`);
  }

  createUser(user: User): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/user/createUser`, user);
   }

}
