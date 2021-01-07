import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { FilmsComponent } from './films/films.component';
import { RealisateursComponent } from './realisateurs/realisateurs.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FilmDetailComponent } from './films/film-detail/film-detail.component';
import { RealisateurDetailComponent } from './realisateurs/realisateur-detail/realisateur-detail.component';
import { RealisateurComponent } from './realisateur/realisateur.component';
import { FilmComponent } from './film/film.component';
import { AddRealisateurComponent } from './realisateurs/add-realisateur/add-realisateur.component';
import { AddFilmComponent } from './films/add-film/add-film.component';
import { UpdateRealisateurComponent } from './realisateurs/update-realisateur/update-realisateur.component';
import { UpdateFilmComponent } from './films/update-film/update-film.component';

@NgModule({
  declarations: [
    AppComponent,
    FilmsComponent,
    RealisateursComponent,
    HomeComponent,
    FilmDetailComponent,
    RealisateurDetailComponent,
    RealisateurComponent,
    FilmComponent,
    AddRealisateurComponent,
    AddFilmComponent,
    UpdateRealisateurComponent,
    UpdateFilmComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
