import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FilmsComponent } from './films/films.component';
import { RealisateursComponent } from './realisateurs/realisateurs.component';
import { FilmDetailComponent } from './films/film-detail/film-detail.component';
import { RealisateurDetailComponent } from './realisateurs/realisateur-detail/realisateur-detail.component';
import { AddRealisateurComponent } from './realisateurs/add-realisateur/add-realisateur.component';
import { AddFilmComponent } from './films/add-film/add-film.component';
import { UpdateRealisateurComponent } from './realisateurs/update-realisateur/update-realisateur.component';
import { UpdateFilmComponent } from './films/update-film/update-film.component';

const routes: Routes = [
  {path:"", component: HomeComponent},
  {path:"films", component: FilmsComponent},
  {path:"films/:id", component:FilmDetailComponent},
  {path:"realisateurs", component: RealisateursComponent},
  {path:"realisateurs/:id", component: RealisateurDetailComponent},
  {path:"add-realisateur", component: AddRealisateurComponent},
  {path:"add-film", component: AddFilmComponent},
  {path:"realisateurs/update/:id", component: UpdateRealisateurComponent},
  {path:"films/update/:id", component:UpdateFilmComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
