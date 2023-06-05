DROP TABLE IF EXISTS conto_corrente, transazioni, estratto_conto_mensile;


CREATE TABLE IF NOT EXISTS conto_corrente (
  	conto_corrente_id SERIAL PRIMARY KEY,
	iban VARCHAR(29) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	cognome VARCHAR(255) NOT NULL,
	indirizzo VARCHAR(255) NOT NULL,
	numero_telefono VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS estratto_conto_mensile (
	estratto_conto_mensile_id SERIAL PRIMARY KEY,
	conto_corrente_id INTEGER NOT NULL,
	anno SMALLINT NOT NULL,
	mese VARCHAR(255) NOT NULL,
	giacenza_inizio_mese FLOAT(2) NOT NULL,
	
	CONSTRAINT fk_riferimento_conto_corrente
      FOREIGN KEY(conto_corrente_id)
	  REFERENCES conto_corrente(conto_corrente_id)
);

CREATE TABLE IF NOT EXISTS transazioni (
	transazioni_id SERIAL PRIMARY KEY,
	conto_corrente_id INTEGER NOT NULL,
	importo float(2) NOT NULL,
	data_transazione DATE NOT NULL, 
	ora_transazione TIME NOT NULL, 
	iban_destinatario VARCHAR(29) NOT NULL,
	mezzo_pagamento VARCHAR(255) NOT NULL,
	
	CONSTRAINT fk_riferimento_conto_corrente
      FOREIGN KEY(conto_corrente_id)
	  REFERENCES conto_corrente(conto_corrente_id)
);

INSERT INTO conto_corrente (iban,nome,cognome,indirizzo,numero_telefono) VALUES 
	('IT41G0300203280173229983299','Mario','Rossi','Via Vai, Firenze','3473425220'),
	('IT41G0300203280173229983298','Lucia','Rossi','Via buia, Firenze','3473425210'),
	('IT41G0300203280173229983297','Mario','Bianchi','Via morte, Firenze','3473429220'),
	('IT41G0300203280173229983296','Lorenzo','Chini','Via dai coglioni, Firenze','34789425220'),
	('IT41G0300203280173229983295','Linus','Torvalds','Via pinguino, Firenze','3923425220'),
	('IT41G0300203280173229983294','Mario','Rossi','Via aa, Firenze','3473425220'),
	('IT41G0300203280173229983293','Luca','Rossi','Via esplodi, Firenze','3473425820'),
	('IT41G0300203280173229983292','Aurelio','Rossi','Via kebab, Roma','3473425288');
	
INSERT INTO transazioni (importo, conto_corrente_id, 
								data_transazione,ora_transazione, 
								iban_destinatario, mezzo_pagamento) VALUES
	('400.00', '2', '2023/05/25', '11:18', 'IT41G0300203280173229983294', 'BONIFICO'),
	('200.00', '5', '2023/05/02', '11:18', 'IT41G0300203280173229983292', 'GIROCONTO'),
	('1200.00', '7', '2023/05/25', '12:18', 'IT41G0300203280173229983299', 'APP'),
	('400.00', '8', '2022/05/12', '11:18', 'IT41G0300203280173229983291', 'CARTA'),
	('200.00', '5', '2023/05/02', '11:18', 'IT41G0300203280173229983292', 'GIROCONTO'),
	('1200.00', '3', '2023/05/25', '12:18', 'IT41G0300203280173229983298', 'APP');

INSERT INTO estratto_conto_mensile (conto_corrente_id, anno, mese, giacenza_inizio_mese) VALUES
	('2', '2022', 'APRIL', '4000'),
	('4', '2012', 'DECEMBER', '80000');