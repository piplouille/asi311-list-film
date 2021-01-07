import { Component, OnInit } from '@angular/core';
import { RealisateurService } from 'src/app/services/realisateur.service';

@Component({
  selector: 'app-add-realisateur',
  templateUrl: './add-realisateur.component.html',
  styleUrls: ['./add-realisateur.component.css']
})
export class AddRealisateurComponent implements OnInit {
  
  constructor(private realisateurService:RealisateurService) { }

  ngOnInit(): void {
  }

  processForm(form) {
    if (form.invalid) {
      alert("Bad!");
      return;
    }

    this.realisateurService.postRealisateur(form.value).subscribe(p => {},
      error => {
        alert("Réalisateur n'a pas pu être créé.")
      });
  }
}
