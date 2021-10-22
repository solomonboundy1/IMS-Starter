INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');

CREATE DATABASE ims;
USE ims;

CREATE TABLE Customer(
	customerId int auto_increment,
    firstName varchar(20) NOT NULL,
    surname varchar(40) NOT NULL,
    PRIMARY KEY (id)
    );
    
CREATE TABLE Item (
	itemId int auto_increment,
	itemName varchar(40) NOT NULL,
	price float NOT NULL,
	PRIMARY KEY (itemId)
	);
	
CREATE TABLE Orders (
	ordersId int auto_increment,
    customerId int NOT NULL,
    itemQuantity int NOT NULL,
    total float NOT NULL,
    PRIMARY KEY (ordersId),
    FOREIGN KEY (customerId) REFERENCES customer(customerId)
    );