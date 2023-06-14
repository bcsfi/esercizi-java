CREATE TABLE menu (
	id_menu INT NOT NULL,
	focaccia VARCHAR(255),
	prezzo DOUBLE PRECISION,
	PRIMARY KEY (id_menu)
);
CREATE TABLE ordini(
	id_ordine INT NOT NULL,
	data_ordine DATE,
	PRIMARY KEY (id_ordine)
);
CREATE TABLE articoli_ordine(
	id_articoli_ordine INT NOT NULL,
	id_ordine INT NOT NULL,
	id_menu INT NOT NULL,
	qta INT,
	PRIMARY KEY (id_articoli_ordine),
	FOREIGN KEY (id_ordine) REFERENCES ordini (id_ordine),
	FOREIGN KEY (id_menu) REFERENCES menu (id_menu)
);
INSERT INTO menu (id_menu, focaccia, prezzo)
VALUES
(1, 'Classica', 5.50),
(2, 'Generosa', 5.50),
(3, 'Favorita', 6.50),
(4, 'Assoluta', 5.70),
(5, 'Splendida', 6.20),
(6, 'Eroica', 7.50),
(7, 'Limitata', 6.60),
(8, 'Maestosa', 7.70),
(9, 'Fantastica', 8.10),
(10, 'Spaziale', 9.90);
INSERT INTO ordini (id_ordine, data_ordine)
VALUES
(1, '2023-06-04'),
(2, '2023-06-03'),
(3, '2023-06-03'),
(4, '2023-06-01'),
(5, '2023-05-30'),
(6, '2023-05-30'),
(7, '2023-05-30'),
(8, '2023-05-30'),
(9, '2023-05-29'),
(10, '2023-05-28'),
(11, '2023-05-27'),
(12, '2023-05-26'),
(13, '2023-05-25'),
(14, '2023-05-25'),
(15, '2023-05-24'),
(16, '2023-05-22'),
(17, '2023-05-21'),
(18, '2023-05-18'),
(19, '2023-05-10'),
(20, '2023-05-06');
INSERT INTO articoli_ordine (id_articoli_ordine, id_ordine, id_menu, qta)
VALUES
(1, 1, 2, 1),
(2, 1, 1, 1),
(3, 2, 10, 1),
(4, 3, 1, 1),
(5, 3, 5, 1),
(6, 4, 2, 2),
(7, 5, 4, 1),
(8, 5, 6, 2),
(9, 6, 1, 3),
(10, 7, 8, 1),
(11, 7, 7, 1),
(12, 7, 4, 1),
(13, 8, 2, 1),
(14, 9, 5, 2),
(15, 10, 6, 1),
(16, 11, 2, 1),
(17, 12, 9, 2),
(18, 12, 6, 2),
(19, 13, 5, 1),
(20, 14, 2, 2),
(21, 15, 10, 4),
(22, 16, 1, 1),
(23, 17, 1, 2),
(24, 18, 2, 3),
(25, 19, 4, 1),
(26, 19, 1, 1),
(27, 20, 2, 1)