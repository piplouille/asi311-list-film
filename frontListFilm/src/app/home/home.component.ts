import { Component, OnInit } from '@angular/core';
import { Film } from '../models/film';
import { FilmService } from '../services/film.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  films: Film[];
  film: Film;
  total: number;
  film_id: number;

  constructor(private filmService: FilmService) { }
  
  ngOnInit(): void {
    this.getFilms();
  }

  getFilms() {
    this.filmService.getFilms().subscribe( (films: Film[]) => {
      this.films = films;
      this.total = this.films.length;
      this.film_id = Math.floor(this.randomNumber(1, this.total));
      this.getFilmById();
    })
  }

  getFilmById() {
    this.filmService.getFilmById(this.film_id)
        .subscribe((film:Film) => {
          this.film = film;
        })
  }

  randomNumber(min, max) {
    return Math.random() * (max - min) + min;
  }
}
