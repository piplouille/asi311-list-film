import { Component, OnInit } from '@angular/core';
import { Film } from '../../models/film';
import { FilmService } from '../../services/film.service';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { RealisateurService } from 'src/app/services/realisateur.service';
import { Realisateur } from 'src/app/models/realisateur';

@Component({
  selector: 'app-realisateur-detail',
  templateUrl: './realisateur-detail.component.html',
  styleUrls: ['./realisateur-detail.component.css']
})
export class RealisateurDetailComponent implements OnInit {
  realisateur_id: number;
  realisateur: Realisateur;
  films: Film[];
  routeSub: Subscription;

  constructor(private filmService:FilmService, private realisateurService:RealisateurService, private activatedRoute:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.routeSub = this.activatedRoute
    .paramMap
    .subscribe((params) => {
      this.realisateur_id = parseInt(params.get("id"));
    })

    this.filmService.getByRealisateurId(this.realisateur_id)
      .subscribe((films:Film[]) => {
        this.films = films;
      });

    this.realisateurService.getRealisateurById(this.realisateur_id)
      .subscribe((realisateur:Realisateur) => {
        this.realisateur = realisateur;
      })
  }

  deleteRealisateur() {
    this.realisateurService.deleteRealisateur(this.realisateur.id);
    this.router.navigate(['/realisateurs']);
  }

}
