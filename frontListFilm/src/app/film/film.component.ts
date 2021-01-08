import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Film } from '../models/film';
import { Genre } from '../models/genre';
import { FilmService } from '../services/film.service';
import { GenreService } from '../services/genre.service';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {
  @Input() film:Film;
  genre:Genre;

  constructor(private filmService:FilmService, private genreService:GenreService) {
  }

  ngOnInit(): void {
    this.getGenre();
  }

  getGenre() {
    this.genreService.getGenreById(this.film.genre)
      .subscribe((genre:Genre) => {
        this.genre = genre;
      })
  }

  deleteFilm() {
    console.log(this.film.id);
    this.filmService.deleteFilm(this.film.id);
  }

}
