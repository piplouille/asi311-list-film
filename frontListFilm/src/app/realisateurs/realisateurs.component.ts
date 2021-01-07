import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Realisateur } from '../models/realisateur';
import { Observable } from 'rxjs/internal/Observable';
import { RealisateurService } from '../services/realisateur.service';

@Component({
  selector: 'app-realisateurs',
  templateUrl: './realisateurs.component.html',
  styleUrls: ['./realisateurs.component.css']
})
export class RealisateursComponent implements OnInit {
  realisateurs: Realisateur[];

  constructor(private realisateurService: RealisateurService) { }

  ngOnInit(): void {
    this.getRealisateurs();
  }

  getRealisateurs() {
    this.realisateurService.getRealisateurs().subscribe( (realisateurs: Realisateur[]) => {
      this.realisateurs = realisateurs;
    })
  }

}
