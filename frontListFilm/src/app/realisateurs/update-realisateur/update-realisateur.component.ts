import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Realisateur } from 'src/app/models/realisateur';
import { RealisateurService } from 'src/app/services/realisateur.service';

@Component({
  selector: 'app-update-realisateur',
  templateUrl: './update-realisateur.component.html',
  styleUrls: ['./update-realisateur.component.css']
})
export class UpdateRealisateurComponent implements OnInit {
  realisateur_id: number;
  realisateur: Realisateur;
  routeSub: Subscription;

  constructor(private realisateurService:RealisateurService, private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.routeSub = this.activatedRoute
    .paramMap
    .subscribe((params) => {
      this.realisateur_id = parseInt(params.get("id"));
    })

    this.realisateurService.getRealisateurById(this.realisateur_id)
    .subscribe((realisateur:Realisateur) => {
      this.realisateur = realisateur;
    })
  }

  processForm(form) {
    if (form.invalid) {
      alert("Bad!");
      return;
    }

    this.realisateurService.updateRealisateur(form.value).subscribe(p => {},
      error => {
        alert("Réalisateur n'a pas pu être modifié.")
      });
  }
}
