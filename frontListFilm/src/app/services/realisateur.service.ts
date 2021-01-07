import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Realisateur } from '../models/realisateur';

@Injectable({
  providedIn: 'root'
})
export class RealisateurService {
  SERVER_URL = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getRealisateurs() {
    return this.http.get(`${this.SERVER_URL}realisateur`);
  }

  getRealisateurById(id: number):Observable<any> {
    // return un Film
    if (id <= 0) {
      return of([]);
    }
    return this.http.get(`${this.SERVER_URL}realisateur/${id}`);
  }

  deleteRealisateur(realId:number) {
    this.http.delete(`${this.SERVER_URL}realisateur/${realId}`)
    .subscribe((s) => {
      console.log(s);
      window.location.reload();
    });
  }

  postRealisateur(realisateur:Realisateur): any {
    return this.http.post(`${this.SERVER_URL}realisateur`, realisateur);
  }

  updateRealisateur(realisateur:Realisateur): any {
    return this.http.put(`${this.SERVER_URL}realisateur`, realisateur);
  }
}
