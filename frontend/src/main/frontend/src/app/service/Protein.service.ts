import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Protein} from '../model/Protein';
import {TableRequest} from '../model/TableRequest';


@Injectable()
export class ProteinService {

  constructor(private http: HttpClient) {
  }

  getProtein(id: number): Observable<Protein> {
    return this.http.get<Protein>(`http://localhost:8080/protein/${id}`);
  }

  getProteinImage(id: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/protein/${id}/image`);
  }

  getListofProteins(tablerequest: TableRequest): Observable<Protein[]> {
    return this.http.post<Protein[]>(`http://localhost:8080/protein/proteins`, tablerequest);
  }

  getPDF(id: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/protein/${id}/pdf`);
  }
}
