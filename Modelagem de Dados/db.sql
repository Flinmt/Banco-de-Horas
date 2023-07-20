CREATE TABLE projeto (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    cliente VARCHAR(30) NOT NULL,
    valor_hora REAL NOT NULL,
    valor_total REAL
);

CREATE TABLE data (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    data_inicio DATE NOT NULL,
    data_limite DATE NOT NULL,
    data_finalização DATE
);

CREATE TABLE projeto_data (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_projeto INTEGER,
    id_data INTEGER,
    FOREIGN KEY (id_projeto) REFERENCES projeto(id),
    FOREIGN KEY (id_data) REFERENCES data(id)
);

CREATE TABLE jornada (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_projeto INTEGER,
    FOREIGN KEY (id_projeto) REFERENCES projeto(id),
    hora_inicio TIME NOT NULL,
    hora_termino TIME,
    total TIME
);