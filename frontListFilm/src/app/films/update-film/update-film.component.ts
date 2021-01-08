import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Film } from 'src/app/models/film';
import { Genre } from 'src/app/models/genre';
import { Realisateur } from 'src/app/models/realisateur';
import { FilmService } from 'src/app/services/film.service';
import { GenreService } from 'src/app/services/genre.service';
import { RealisateurService } from 'src/app/services/realisateur.service';

@Component({
  selector: 'app-update-film',
  templateUrl: './update-film.component.html',
  styleUrls: ['./update-film.component.css']
})
export class UpdateFilmComponent implements OnInit {
  film_id: number;
  film: Film;
  realisateurs: Realisateur[];
  genres: Genre[];
  routeSub: Subscription;

  constructor(private realisateurService:RealisateurService, private filmService:FilmService, private genreService:GenreService, private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.routeSub = this.activatedRoute
    .paramMap
    .subscribe((params) => {
      this.film_id = parseInt(params.get("id"));
    })

    this.filmService.getFilmById(this.film_id)
    .subscribe((film:Film) => {
      this.film = film;
    })
    
    this.getRealisateurs();
    this.getGenres();
  }

  getRealisateurs() {
    this.realisateurService.getRealisateurs().subscribe( (realisateurs: Realisateur[]) => {
      this.realisateurs = realisateurs;
    })
  }
  getGenres() {
    this.genreService.getGenres()
      .subscribe((genres:Genre[]) => {
        this.genres = genres;
      })
  }


  processForm(form) {
    if (form.invalid) {
      alert("Bad!");
      return;
    }

    this.filmService.updateFilm(form.value).subscribe(p => {},
      error => {
        alert("Réalisateur n'a pas pu être modifié.")
      });
  }
}
