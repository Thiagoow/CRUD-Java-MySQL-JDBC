drop database gamestore;

create database gamestore;

USE gamestore;

create table gamestore.customers (
  id BIGINT NOT NULL AUTO_INCREMENT,
  username VARCHAR(255),
  password VARCHAR(255),
  name VARCHAR(255),
  cpf VARCHAR(255),
  email VARCHAR(255),
  primary key (id)
);

create table gamestore.games (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  value DOUBLE,
  type VARCHAR(255),
  primary key (id)
);

create table gamestore.purchases (
  id_purchases BIGINT NOT NULL AUTO_INCREMENT primary key,
  total_value DOUBLE,
  id_games BIGINT,
  id_customers BIGINT
);

ALTER TABLE gamestore.purchases ADD CONSTRAINT FK_PURCHASESCUSTOMERS_ID FOREIGN KEY (id_customers) REFERENCES customers (ID);
ALTER TABLE gamestore.purchases ADD CONSTRAINT FK_PURCHASESGAMES_ID FOREIGN KEY (id_games) REFERENCES games (ID);

INSERT INTO `gamestore`.`customers` (`username`, `password`, `name`, `cpf`, `email`) VALUES ('Thi', '123456', 'Thiago Lopes', '123456789', 'thiagolopes@email.com');
INSERT INTO `gamestore`.`customers` (`username`, `password`, `name`, `cpf`, `email`) VALUES ('Gui', '123456', 'Guilherme Silva', '9123456789', 'guisilva@email.com');

INSERT INTO `gamestore`.`games` (`name`, `value`, `type`) VALUES ('Red Dead Redemption 2', 400, 'PC');
INSERT INTO `gamestore`.`games` (`name`, `value`, `type`) VALUES ('God Of War', 200, 'PS4');

INSERT INTO `gamestore`.`purchases` (`total_value`, `id_games`, `id_customers`) VALUES (120, 1, 1);
