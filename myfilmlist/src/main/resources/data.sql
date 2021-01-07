CREATE TABLE IF NOT EXISTS Realisateur(id INT primary key auto_increment, prenom VARCHAR(100), nom VARCHAR(100), naissance VARCHAR(100));
INSERT INTO Realisateur(prenom, nom, naissance) VALUES('Jean-Luc', 'Godard', '3 décembre 1930');
INSERT INTO Realisateur(prenom, nom, naissance) VALUES('Luc', 'Besson', '18 mars 1959');
INSERT INTO Realisateur(prenom, nom, naissance) VALUES('Sophia', 'Coppola', '14 mai 1971');


CREATE TABLE IF NOT EXISTS Film(id INT primary key auto_increment, titre VARCHAR(100), duration INT, id_realisateur INT);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('A bout de souffle', 150, 1);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Le Mépris', 150, 1);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Pierrot le Fou', 150, 1);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Sauve qui peut (la vie)', 150, 1);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Histoire(s) du cinéma', 150, 1);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Subway', 220, 2);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Le Grand Bleu', 220, 2);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Nikita', 220, 2);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Léon', 220, 2);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Le Cinquième Elément', 220, 2);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Lost in Translation', 160, 3);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Virgin Suicides', 160, 3);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Marie-Antoinette', 160, 3);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Somewhere', 160, 3);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('The Bling Ring', 160, 3);
INSERT INTO Film(titre, duration, id_realisateur) VALUES('Les proies (The Beguiled)', 160, 3);