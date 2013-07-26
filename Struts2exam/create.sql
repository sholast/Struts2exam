CREATE DATABASE IF NOT EXISTS strutsexam CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS strutsexam.customer 
		(id BIGINT PRIMARY KEY AUTO_INCREMENT,  
		firstname VARCHAR(50)  NOT NULL, 
		lastname VARCHAR(50)  NOT NULL, 
		email VARCHAR(70), 
		birthdate DATE, 
		sex VARCHAR(20));
		
CREATE USER strutsexam IDENTIFIED BY 'struts';

GRANT ALL ON strutsexam.* TO strutsexam;