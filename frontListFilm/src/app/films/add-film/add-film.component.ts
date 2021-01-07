import { Component, OnInit } from '@angular/core';
import { Realisateur } from 'src/app/models/realisateur';
import { FilmService } from 'src/app/services/film.service';
import { RealisateurService } from 'src/app/services/realisateur.service';

@Component({
  selector: 'app-add-film',
  templateUrl: './add-film.component.html',
  styleUrls: ['./add-film.component.css']
})
export class AddFilmComponent implements OnInit {
  realisateurs: Realisateur[];

  constructor(private filmService:FilmService, private realisateurService:RealisateurService) { }

  ngOnInit(): void {
    this.getRealisateurs();
  }

  getRealisateurs() {
    this.realisateurService.getRealisateurs().subscribe( (realisateurs: Realisateur[]) => {
      this.realisateurs = realisateurs;
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
