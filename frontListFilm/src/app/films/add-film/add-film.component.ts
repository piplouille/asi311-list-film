import { Component, OnInit } from '@angular/core';
import { Genre } from 'src/app/models/genre';
import { Realisateur } from 'src/app/models/realisateur';
import { FilmService } from 'src/app/services/film.service';
import { GenreService } from 'src/app/services/genre.service';
import { RealisateurService } from 'src/app/services/realisateur.service';

@Component({
  selector: 'app-add-film',
  templateUrl: './add-film.component.html',
  styleUrls: ['./add-film.component.css']
})
export class AddFilmComponent implements OnInit {
  realisateurs: Realisateur[];
  genres: Genre[];

  constructor(private filmService:FilmService, private realisateurService:RealisateurService, private genreService:GenreService) { }

  ngOnInit(): void {
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

    this.filmService.postFilm(form.value).subscribe(p => {},
      error => {
        alert("Film n'a pas pu être créé.")
      });
  }

}
