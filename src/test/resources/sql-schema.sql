DROP TABLE IF EXISTS `Orders_Items`;
DROP TABLE IF EXISTS `Orders`;
DROP TABLE IF EXISTS `Item`;
DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);



CREATE TABLE IF NOT EXISTS `Item` (
	`itemId` int auto_increment,
	`itemName` varchar(40) NOT NULL,
	`price` Double NOT NULL,
	PRIMARY KEY (itemId)
	);
	
	


CREATE TABLE `Orders` (
	`ordersId` int auto_increment,
    `customerId` int NOT NULL,
    `itemQuantity` int,
    `total` float,
    PRIMARY KEY (ordersId),
    FOREIGN KEY (customerId) REFERENCES customers(id)
    );
    
    

    
CREATE TABLE `Orders_Items` (
	`ordersItemsId` int auto_increment,
	`ordersId` int NOT NULL,
	`itemId` int NOT NULL,
	PRIMARY KEY (ordersItemsId),
	FOREIGN KEY (ordersId) REFERENCES orders(ordersId),
	FOREIGN KEY (itemId) REFERENCES item(itemId)
);
    