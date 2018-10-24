DROP TABLE attendances;
DROP TABLE movies;
DROP TABLE people;

CREATE TABLE movies (
	id SERIAL8 PRIMARY KEY,
	title VARCHAR(255),
	year INT2,
	show_time VARCHAR(255)
);

CREATE TABLE people (
	id SERIAL8 PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE attendances (
	id SERIAL8 PRIMARY KEY,
	person_id INT REFERENCES people(id) ON DELETE CASCADE,
	movie_id INT REFERENCES movies(id) ON DELETE CASCADE
);

INSERT INTO people (name) VALUES ('Alise Rees');
INSERT INTO people (name) VALUES ('Allyson Wilson');
INSERT INTO people (name) VALUES ('Andrew Samtoy');
INSERT INTO people (name) VALUES ('Benjamin Conway');
INSERT INTO people (name) VALUES ('Dan Kelsey');
INSERT INTO people (name) VALUES ('Daniel Lara');
INSERT INTO people (name) VALUES ('David Burnett');
INSERT INTO people (name) VALUES ('David Mulligan');
INSERT INTO people (name) VALUES ('David Ryan');
INSERT INTO people (name) VALUES ('David Sturgeon');
INSERT INTO people (name) VALUES ('David');
INSERT INTO people (name) VALUES ('Gabriela Lewandowska');
INSERT INTO people (name) VALUES ('Heather Rae');
INSERT INTO people (name) VALUES ('Iain Paterson');
INSERT INTO people (name) VALUES ('Kyle Miller');
INSERT INTO people (name) VALUES ('Michael Leadley');
INSERT INTO people (name) VALUES ('Nicholas Holloway');
INSERT INTO people (name) VALUES ('Raul Ruiz');
INSERT INTO people (name) VALUES ('Robert Bowes');
INSERT INTO people (name) VALUES ('Ryan Forgie');
INSERT INTO people (name) VALUES ('Simon Anger');
INSERT INTO people (name) VALUES ('Craig Morton');

INSERT INTO movies (title, year, show_time) VALUES ('Iron Man', 2008, '21:00');
INSERT INTO movies (title, year, show_time) VALUES ('The Incredible Hulk', 2008, '14:05');
INSERT INTO movies (title, year, show_time) VALUES ('Iron Man 2', 2010, '15:55');
INSERT INTO movies (title, year, show_time) VALUES ('Thor', 2011, '16:10');
INSERT INTO movies (title, year, show_time) VALUES ('Guardians of the Galaxy', 2014, '16:15');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: The First Avenger', 2011, '12:20');
INSERT INTO movies (title, year, show_time) VALUES ('Avengers Assemble', 2012, '18:10');
INSERT INTO movies (title, year, show_time) VALUES ('Iron Man 3', 2013, '14:55');
INSERT INTO movies (title, year, show_time) VALUES ('Thor: The Dark World', 2013, '18:20');
INSERT INTO movies (title, year, show_time) VALUES ('Batman Begins', 2005, '15:35');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: The Winter Soldier', 2014, '19:40');
INSERT INTO movies (title, year, show_time) VALUES ('Avengers: Age of Ultron', 2015, '12:55');
INSERT INTO movies (title, year, show_time) VALUES ('Ant-Man', 2015, '21:40');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: Civil War', 2016, '14:05');
INSERT INTO movies (title, year, show_time) VALUES ('Doctor Strange', 2016, '13:00');
INSERT INTO movies (title, year, show_time) VALUES ('Guardians of the Galaxy 2', 2017, '20:00');

INSERT INTO attendances (person_id, movie_id) VALUES (12, 4);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (16, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (14, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (16, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (5, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (7, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (18, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (18, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (15, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (18, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (5, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (5, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (14, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (1, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (1, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (7, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (14, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 4);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (14, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (7, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (1, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (18, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (16, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (16, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 6);
