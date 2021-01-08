import { Component, OnInit } from '@angular/core';
import { Film } from '../models/film';
import { Genre } from '../models/genre';
import { FilmService } from '../services/film.service';
import { GenreService } from '../services/genre.service';

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
  genre: String;

  constructor(private filmService: FilmService, private genreService:GenreService) { }
  
  ngOnInit(): void {
    this.getFilms();
  }
  
  getFilms() {
    this.filmService.getFilms().subscribe( (films: Film[]) => {
      this.films = films;
      this.total = this.films.length;
      this.film_id = films[Math.floor(this.randomNumber(1, this.total))].id;
      this.getFilmById();
    })
  }

  getFilmById() {
    this.filmService.getFilmById(this.film_id)
        .subscribe((film:Film) => {
          this.film = film;
          this.getGenre();
        })
  }

  getGenre() {
    this.genreService.getGenreById(this.film.genre)
      .subscribe((genre:Genre) => {
        this.genre = genre.genre;
      })
  }

  randomNumber(min, max) {
    return Math.random() * (max - min) + min;
  }
}
