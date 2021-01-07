import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GenreService {
  SERVER_URL = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getGenres() {
    return this.http.get(`${this.SERVER_URL}genres`);
  }

  getGenreById(id: number):Observable<any> {
    // return un genre
    if (id <= 0) {
      return of([]);
    }
    return this.http.get(`${this.SERVER_URL}genres/${id}`);
  }
}
