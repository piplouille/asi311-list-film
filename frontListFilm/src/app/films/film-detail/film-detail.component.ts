import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Film } from 'src/app/models/film';
import { Genre } from 'src/app/models/genre';
import { FilmService } from 'src/app/services/film.service';
import { GenreService } from 'src/app/services/genre.service';

@Component({
  selector: 'app-film-detail',
  templateUrl: './film-detail.component.html',
  styleUrls: ['./film-detail.component.css']
})
export class FilmDetailComponent implements OnInit {
  film_id: number;
  film: Film;
  genre: Genre;
  routeSub: Subscription;

  constructor(private filmService: FilmService, private genreService: GenreService, private activatedRoute: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.routeSub = this.activatedRoute
    .paramMap
    .subscribe((params) => {
      this.film_id = parseInt(params.get("id"));
    })
    this.filmService.getFilmById(this.film_id)
      .subscribe((film:Film) => {
        this.film = film;
        this.getGenre();
      })
  }

  getGenre() {
    this.genreService.getGenreById(this.film.genre)
      .subscribe((genre:Genre) => {
        this.genre = genre;
      })
  }

  deleteFilm() {
    this.filmService.deleteFilm(this.film.id);
    this.router.navigate(['/films']);
  }

}
