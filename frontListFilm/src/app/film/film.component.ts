import { Component, Input, OnInit } from '@angular/core';
import { Film } from '../models/film';
import { FilmService } from '../services/film.service';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {
  @Input() film:Film;

  constructor(private filmService:FilmService) { }

  ngOnInit(): void {
  }

  deleteFilm() {
    console.log(this.film.id);
    this.filmService.deleteFilm(this.film.id);
  }

}
