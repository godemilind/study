create table tutorials(id NUMBER(10), title varchar(255), description varchar(255), published NUMBER(1), createdAt timestamp);
create table authors(id NUMBER(10), first_name varchar(255), last_name varchar(255));
INSERT INTO tutorials (id, title, description, published) VALUES (1, 'Java', 'Java is awesome', 1);
INSERT INTO tutorials (id, title, description, published) VALUES (2, 'PHP', 'PHP is awesome', 1);
INSERT INTO tutorials (id, title, description, published) VALUES (3, '.net', '.net is awesome', 1);
INSERT INTO tutorials (id, title, description, published) VALUES (4, 'spring', 'spring is awesome', 1);
INSERT INTO tutorials (id, title, description, published) VALUES (5, 'jpa', 'jpa is awesome', 1);