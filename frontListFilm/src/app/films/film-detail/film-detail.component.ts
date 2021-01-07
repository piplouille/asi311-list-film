import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Film } from 'src/app/models/film';
import { FilmService } from 'src/app/services/film.service';

@Component({
  selector: 'app-film-detail',
  templateUrl: './film-detail.component.html',
  styleUrls: ['./film-detail.component.css']
})
export class FilmDetailComponent implements OnInit {
  film_id: number;
  film: Film;
  routeSub: Subscription;

  constructor(private filmService: FilmService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.routeSub = this.activatedRoute
    .paramMap
    .subscribe((params) => {
      this.film_id = parseInt(params.get("id"));
    })
    this.filmService.getFilmById(this.film_id)
      .subscribe((film:Film) => {
        this.film = film;
      })
  }


}
