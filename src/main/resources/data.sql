DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

INSERT INTO product (name) VALUES('Face cream');
INSERT INTO product (name) VALUES('Shaving foam');
INSERT INTO product (name) VALUES('Hair gel');

---------------------------------------------------

DROP TABLE IF EXISTS USER_CHARACTER;
DROP TABLE IF EXISTS WEAPON;

CREATE TABLE WEAPON (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    race VARCHAR(50),
    cost INT NOT NULL
);

INSERT INTO WEAPON VALUES(1, 'Broad Sword', 'Barbarian', 300);
INSERT INTO WEAPON VALUES(2, 'Magic Wand', 'Wizard', 500);
INSERT INTO WEAPON VALUES(3, 'Staff', 'Druid', 50);
INSERT INTO WEAPON VALUES(4, 'Shiv', 'Rouge', 100);
INSERT INTO WEAPON VALUES(5, 'Bare Hands', NULL, 0);

-------------------------------------

CREATE TABLE USER_CHARACTER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  race VARCHAR(50) NOT NULL,
  gold INT NOT NULL,
  questing INT NOT NULL,
  weapon INT NOT NULL
);


INSERT INTO USER_CHARACTER VALUES(2, 'Tim', 'Druid', 50, 1, 3);
INSERT INTO USER_CHARACTER VALUES(3, 'Ali', 'Rouge', 600, 1,4);
INSERT INTO USER_CHARACTER VALUES(4, 'Gordon', 'Barbarian', 500, 0,1);

------------------------------------------------------