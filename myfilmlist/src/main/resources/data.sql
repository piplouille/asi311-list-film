CREATE TABLE IF NOT EXISTS Realisateur(id INT primary key auto_increment, prenom VARCHAR(100), nom VARCHAR(100), naissance VARCHAR(100));
INSERT INTO Realisateur(prenom, nom, naissance) VALUES('Jean-Luc', 'Godard', '3 décembre 1930');
INSERT INTO Realisateur(prenom, nom, naissance) VALUES('Luc', 'Besson', '18 mars 1959');
INSERT INTO Realisateur(prenom, nom, naissance) VALUES('Sophia', 'Coppola', '14 mai 1971');


CREATE TABLE IF NOT EXISTS Film(id INT primary key auto_increment, titre VARCHAR(100), duration INT, id_realisateur INT, id_genre INT);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('A bout de souffle', 150, 1, 2);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Le Mépris', 150, 1, 2);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Pierrot le Fou', 150, 1, 2);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Sauve qui peut (la vie)', 150, 1, 2);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Histoire(s) du cinéma', 150, 1, 4);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Subway', 220, 2, 3);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Le Grand Bleu', 220, 2, 1);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Nikita', 220, 2, 1);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Léon', 220, 2, 1);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Le Cinquième Elément', 220, 2, 1);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Lost in Translation', 160, 3, 2);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Virgin Suicides', 160, 3, 2);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Marie-Antoinette', 160, 3, 2);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Somewhere', 160, 3, 2);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('The Bling Ring', 160, 3, 2);
INSERT INTO Film(titre, duration, id_realisateur, id_genre) VALUES('Les proies (The Beguiled)', 160, 3, 4);

CREATE TABLE IF NOT EXISTS Genre(id INT primary key auto_increment, genre VARCHAR(10));
INSERT INTO Genre(genre) VALUES('Action');
INSERT INTO Genre(genre) VALUES('Drame');
INSERT INTO Genre(genre) VALUES('Thriller');
INSERT INTO Genre(genre) VALUES('Autre');