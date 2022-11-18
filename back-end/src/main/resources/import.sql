insert into bird(color, family, gender, habitat, nameen, namelat, namept, size) values ('Preto', 'Columbidae', 'M', 'Urbano', 'Rock Dove', 'Columba livia', 'Pombo', 10);
insert into bird(color, family, gender, habitat, nameen, namelat, namept, size) values ('Branco', 'Dromadidae', 'F', 'Urbano', 'Mourning Dove', 'Zenaida macroura', 'Pombo-branco', 15);
insert into bird(color, family, gender, habitat, nameen, namelat, namept, size) values ('Verde', 'Phasianidae', 'M', 'Selva', 'Mallard', 'Anas platyrhynchos', 'Pavao', 12);
insert into bird(color, family, gender, habitat, nameen, namelat, namept, size) values ('Azul', 'Anatidae', 'F', 'Selva', 'Blue-winged Teal', 'Spatula discors', 'Pato', 30);
insert into bird(color, family, gender, habitat, nameen, namelat, namept, size) values ('Marrom', 'Anatidae', 'M', 'Selva', 'Northern Shoveler', 'Spatula clypeata', 'Pato', 80);


-- Senha: 1234
insert into users(email, name, password) values ('isadora@gmail.com',  'Isadora Hoelscher', '$2a$10$NQzss5cI4Fn8e5pF4MnbL.C3sfRJHDZCOk2eRc/uVsGgw6cPjdslG');
-- Senha: 5678
insert into users(email, name, password) values ('lucasgomes@gmail.com', 'Lucas Gomes', '$2a$10$8a5tjnoCQeRvleiSiwy4Zeoda33M3LFXCVv.Y0tFHAO5eIiDVqIey');
-- Senha: 9101112
insert into users(email, name, password) values ('dienifer@gmail.com', 'Dienifer Kwi', '$2a$10$PY6nZdCiCmryHjrBkIGHqe1A5P9UXHkZD3ctegspP1KRScw0ssfHO');
-- Senha: 13141516
insert into users(email, name, password) values ('lucaspedroso@gmail.com', 'Lucas Eduardo Pedroso', '$2a$10$dFih0DarK/.A1Yxl3mdftOefVKcKETU5KoSVzVsHCRuUp1rlQdiFO');
-- Senha: 17181920
insert into users(email, name, password) values ('michael@gmail.com', 'Michael Mora', '$2a$10$Lk025U/n5rcVfegMgDNCJuZHqxCsjJ2Mk5qIVUPpLvs0p.Sa1fVlS');.

insert into tb_role(authority) values ('ROLE_ADMIN');
insert into tb_role(authority) values ('ROLE_USER');

insert into tb_user_role(user_id, role_id) values (1, 1);
insert into tb_user_role(user_id, role_id) values (2, 2);
insert into tb_user_role(user_id, role_id) values (3, 1);
insert into tb_user_role(user_id, role_id) values (4, 2);
insert into tb_user_role(user_id, role_id) values (5, 2);

insert into annotation(date, place, text, bird_id, user_id) values (NOW(), 'Porto Alegre', 'Criatura delicada de plumagem furta-cor', 3, 1);
insert into annotation(date, place, text, bird_id, user_id) values (NOW(), 'Braganca Paulista', 'Pato trajado com calcas de shopping', 5, 1);
insert into annotation(date, place, text, bird_id, user_id) values (NOW(), 'Sao Paulo', 'Pato de bico fino e cauda comprida', 4, 1);
insert into annotation(date, place, text, bird_id, user_id) values (NOW(), 'Londrina', 'Pombo Correio', 2, 1);
insert into annotation(date, place, text, bird_id, user_id) values (NOW(), 'Rio de Janeiro', 'Pombo de bico grosso e cauda curta', 1, 1);