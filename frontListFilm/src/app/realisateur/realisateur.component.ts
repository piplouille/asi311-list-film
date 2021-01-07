import { Component, OnInit, Input } from '@angular/core';
import { Realisateur } from '../models/realisateur';
import { RealisateurService } from '../services/realisateur.service';

@Component({
  selector: 'app-realisateur',
  templateUrl: './realisateur.component.html',
  styleUrls: ['./realisateur.component.css']
})
export class RealisateurComponent implements OnInit {
  @Input() realisateur:Realisateur;

  constructor(private realisateurService:RealisateurService) { }

  ngOnInit(): void {
  }

  deleteRealisateur() {
    console.log(this.realisateur.id);
    this.realisateurService.deleteRealisateur(this.realisateur.id);
  }

}
