DROP TABLE IF EXISTS bards;

CREATE TABLE bards (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL
);

INSERT INTO bards (first_name, last_name) VALUES ('Adam', 'Mickiewicz');
INSERT INTO bards (first_name, last_name) VALUES ('Juliusz', 'Słowacki');
INSERT INTO bards (first_name, last_name) VALUES ('Zygmunt', 'Krasiński' );
