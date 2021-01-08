import { ResourceLoader } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Film } from '../models/film';
import { FilmService } from '../services/film.service';
import { FilmComponent } from '../film/film.component';

@Component({
  selector: 'app-films',
  templateUrl: './films.component.html',
  styleUrls: ['./films.component.css'],
})
export class FilmsComponent implements OnInit {
  films: Film[];
  page: number;
  no_pages: Array<number>;

  constructor(private filmService: FilmService) { }

  ngOnInit(): void {
    this.getNoPage();
    this.getFilmsByPage();
  }

  getNoPage() {
    this.filmService.getFilms().subscribe( (films: Film[]) => {
      this.no_pages = Array(Math.floor(films.length / 5) + 1);
    })
  }

  getFilmsByPage() {
    if (this.page == null) {
      this.page = 1;
    }

    this.filmService.getFilmsByPage(this.page).subscribe( (films: Film[]) => {
      this.films = films;
    })
  }

  changePage(page) {
    console.log(page);
    this.page = page;
    this.getFilmsByPage();
    window.scroll(0,0);
  }

}
