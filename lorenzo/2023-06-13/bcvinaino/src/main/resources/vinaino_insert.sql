CREATE TABLE menu (
	id_menu SERIAL,
	focaccia VARCHAR(255),
	prezzo DOUBLE PRECISION,
	PRIMARY KEY (id_menu)
);
CREATE TABLE ordini (
	id_ordine SERIAL,
	data_ordine DATE,
	PRIMARY KEY (id_ordine)
);
CREATE TABLE articoli_ordine(
	id_articoli_ordine SERIAL,
	id_ordine INT NOT NULL,
	id_menu INT NOT NULL,
	qta INT,
	PRIMARY KEY (id_articoli_ordine),
	FOREIGN KEY (id_ordine) REFERENCES ordini (id_ordine),
	FOREIGN KEY (id_menu) REFERENCES menu (id_menu)
);
INSERT INTO menu (focaccia, prezzo)
VALUES
('Classica', 5.50),
('Generosa', 5.50),
('Favorita', 6.50),
('Assoluta', 5.70),
('Splendida', 6.20),
('Eroica', 7.50),
('Limitata', 6.60),
('Maestosa', 7.70),
('Fantastica', 8.10),
('Spaziale', 9.90);
INSERT INTO ordini (data_ordine)
VALUES
('2023-06-04'),
('2023-06-03'),
('2023-06-03'),
('2023-06-01'),
('2023-05-30'),
('2023-05-30'),
('2023-05-30'),
('2023-05-30'),
('2023-05-29'),
('2023-05-28'),
('2023-05-27'),
('2023-05-26'),
('2023-05-25'),
('2023-05-25'),
('2023-05-24'),
('2023-05-22'),
('2023-05-21'),
('2023-05-18'),
('2023-05-10'),
('2023-05-06');
INSERT INTO articoli_ordine (id_ordine, id_menu, qta)
VALUES
(1, 2, 1),
(1, 1, 1),
(2, 10, 1),
(3, 1, 1),
(3, 5, 1),
(4, 2, 2),
(5, 4, 1),
(5, 6, 2),
(6, 1, 3),
(7, 8, 1),
(7, 7, 1),
(7, 4, 1),
(8, 2, 1),
(9, 5, 2),
(10, 6, 1),
(11, 2, 1),
(12, 9, 2),
(12, 6, 2),
(13, 5, 1),
(14, 2, 2),
(15, 10, 4),
(16, 1, 1),
(17, 1, 2),
(18, 2, 3),
(19, 4, 1),
(19, 1, 1),
(20, 2, 1)