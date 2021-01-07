import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Film } from '../models/film';

@Injectable({
  providedIn: 'root'
})
export class FilmService {
  private films: Film[];
  SERVER_URL = 'http://localhost:8080/films';

  constructor(private http: HttpClient) { }

  getFilms() {
    return this.http.get(`${this.SERVER_URL}`);
  }

  getFilmsByPage(page: number) {
    return this.http.get(`${this.SERVER_URL}/${page}`);
  }

  getFilmById(id: number):Observable<any> {
    // return un Film
    if (id <= 0) {
      return of([]);
    }
    return this.http.get(`${this.SERVER_URL}/film/${id}`);
  }

  getByRealisateurId(id: number):Observable<any> {
    if (id <= 0) {
      return of([]);
    }
    return this.http.get(`${this.SERVER_URL}/real/${id}`)
  }

  deleteFilm(id:number) {
    this.http.delete(`${this.SERVER_URL}/${id}`)
    .subscribe((s) => {
      console.log(s);
      window.location.reload();
    });
    console.log("je suis delete film");
  }

  postFilm(film:Film): any {
    return this.http.post(`${this.SERVER_URL}`, film);
  }

  updateFilm(film:Film): any {
    return this.http.put(`${this.SERVER_URL}`, film);
  }
}
