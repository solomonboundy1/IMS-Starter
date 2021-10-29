drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `Item`;

CREATE TABLE IF NOT EXISTS `Item` (
	`itemId` int auto_increment,
	`itemName` varchar(40) NOT NULL,
	`price` float NOT NULL,
	PRIMARY KEY (itemId)
	);
	

DROP TABLE IF EXISTS `Orders`;

CREATE TABLE `Orders` (
	`ordersId` int auto_increment,
    `customerId` int NOT NULL,
    `itemQuantity` int,
    `total` float,
    PRIMARY KEY (ordersId),
    FOREIGN KEY (customerId) REFERENCES customers(id)
    );
    
DROP TABLE IF EXISTS `Orders_Items`;
    
CREATE TABLE `Orders_Items` (
	`ordersItemsId` int auto_increment,
	`ordersId` int NOT NULL,
	`itemId` int NOT NULL,
	PRIMARY KEY (ordersItemsId),
	FOREIGN KEY (ordersId) REFERENCES orders(ordersId),
	FOREIGN KEY (itemId) REFERENCES item(itemId)
);
    