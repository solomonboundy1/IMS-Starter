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
	
CREATE TABLE Order (
	orderId int auto_increment,
	