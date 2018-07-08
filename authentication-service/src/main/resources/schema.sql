DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;

CREATE  TABLE users (
  login VARCHAR(100) NOT NULL ,
  password VARCHAR(155) NOT NULL ,
  enabled boolean NOT NULL ,
  avatart VARCHAR(155) NOT NULL ,
  information VARCHAR(155) NOT NULL ,
  devicecount INT NOT NULL ,
  reg DATE NOT NULL ,
  accstatus VARCHAR(55) NOT NULL ,
  name VARCHAR(100) NOT NULL ,
  PRIMARY KEY (login));

CREATE TABLE user_roles (
  user_role_id SERIAL,
  user_name varchar(100) NOT NULL,
  role varchar(100) NOT NULL,
  PRIMARY KEY (user_role_id));

INSERT INTO users VALUES ('admin@gmail.com', '$2y$10$7U2ebt9x0K7AJ/vJcGsUL.JpgIhmj.1dxTFYR5lffxMm8tbO5e7w6', 
  'true', 'https://publicdomainvectors.org/photos/red_avatar.png', 'Веселый, общительный.', 
  2, '2018-06-08', 'Премиум', 'Дмитрий Файчук');

INSERT INTO user_roles (user_name, role) VALUES ('Dmitriy.Faychuk', 'ROLE_USER');
INSERT INTO user_roles (user_name, role) VALUES ('Dmitriy.Faychuk', 'ROLE_ADMIN');