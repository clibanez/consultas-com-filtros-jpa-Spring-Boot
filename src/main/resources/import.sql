INSERT INTO categorias (nome) VALUES ('frutas');
INSERT INTO categorias (nome) VALUES ('legumes');


INSERT INTO produtos (nome,quantidade, categoria_id, data_validade) VALUES ('banana',10,1, CURRENT_TIMESTAMP);
INSERT INTO produtos (nome,quantidade, categoria_id, data_validade) VALUES ('uva',8,1, CURRENT_TIMESTAMP);
INSERT INTO produtos (nome,quantidade, categoria_id, data_validade) VALUES ('cogumelo',3,2, CURRENT_TIMESTAMP);
INSERT INTO produtos (nome,quantidade, categoria_id, data_validade) VALUES ('pepino',6,2, CURRENT_TIMESTAMP);
