DROP TABLE IF EXISTS ordini, menu, menu_ordini;

CREATE TABLE IF NOT EXISTS ordini (
	id_ordine SERIAL PRIMARY KEY,
	data_ordine DATE NOT NULL
	
);

CREATE TABLE IF NOT EXISTS menu (
	id_menu SERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	ingredienti VARCHAR(255) NOT NULL,
	prezzo DOUBLE PRECISION NOT NULL
);

CREATE TABLE IF NOT EXISTS menu_ordini (
	id_menu_ordini SERIAL PRIMARY KEY,
	id_ordini BIGINT,
	id_menu BIGINT,
	quantita INT,
	CONSTRAINT fk_ordini FOREIGN KEY(id_ordini) REFERENCES ordini(id_ordine),
	CONSTRAINT fk_menu FOREIGN KEY(id_menu) REFERENCES menu(id_menu)
);

INSERT INTO menu (nome, ingredienti, prezzo) VALUES 
	('TEXAS','"pane focaccia", Würstel, edamer, bacon, patatine fritte, uovo frittata.', '10.00'),
	('DOLE','"pane focaccia", Salsiccia , formaggio scamorza, melanzane a funghetto, pomodorini semi dried, cipolla fresca, rucola.', '10.00'),
	('CHEESEANGUS', 'Hamburger di Angus 190 gr., edamer, insalata, pomodoro.', '9.00'),
	('HAMBOVO', 'Hamburger Bovino da 190 gr., edamer, uovo a frittata, patatine*fritte, insalata, pomodoro.', '9.00'),
	('CAVALLO', '"pane focaccia", Carne di cavallo, edamer, cipolle, insalata, pomodoro, patatinefritte.', '9.00'),
	('SALSICCIOTTO', '"pane focaccia", Salsiccia , edamer, cipolle, insalata, pomodoro, patatine fritte.','8.00'),
	('BOSCAIOLO', 'Hamburger Bovino da 190 gr., edamer, speck, funghi.', '9.00'),
	('COTOLETTA', 'Cotoletta di pollo 200 gr., edamer, insalata, pomodoro.', '9.00'),
	('KEBAB', 'Panino o piadina, Kebab, edamer, cipolla, insalata, pomodoro.', '10.00'),
	('CHEESEBURGER', 'Hamburger Bovino da 190 gr., edamer, insalata, pomodoro', '9.00');

INSERT INTO ordini (data_ordine) VALUES 
	('2023-05-05'),
	('2023-05-06'),
	('2023-05-06'),
	('2023-05-07'),
	('2023-05-07'),
	('2023-05-08'),
	('2023-05-09'),
	('2023-05-10'),
	('2023-05-11'),
	('2023-05-12'),
	('2023-05-13'),
	('2023-05-14'),
	('2023-05-15'),
	('2023-05-16'),
	('2023-05-17'),
	('2023-05-18'),
	('2023-05-19'),
	('2023-05-20'),
	('2023-05-21'),
	('2023-05-22'),
	('2023-05-23'),
	('2023-05-24'),
	('2023-05-28'),
	('2023-05-29'),
	('2023-05-30'),
	('2023-05-31'),
	('2023-06-01'),
	('2023-06-02'),
	('2023-06-03'),
	('2023-06-04'),
	('2023-06-05');
	
INSERT INTO menu_ordini (id_ordini, id_menu, quantita) VALUES 
	('25','3','1'),
	('12','7','2'),
	('16','2','1'),
	('26','6','3'),
	('19','4','1'),
	('16','1','1'),
	('25','3','2'),
	('12','7','3'),
	('16','2','1'),
	('26','2','2'),
	('19','3','1'),
	('16','6','1');