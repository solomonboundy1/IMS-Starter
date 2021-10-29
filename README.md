# IMS Fundamental Project

This project is a management system made to to add, remove and update customers, items and orders into a database in an easy and tidy way. It has features such as the total of the order as well as the item quantity. there will be four separate entities within the database that allows us access to customer information, order information item information and an 'orders_items' entity that allows us to add or remove items from an order as well as view every item added to each order.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them
In order to  get started with the project you will need to download and install the following:
- An IDE of your choice that supports Java (Eclipse is recommended)
- MySQL as well as MySQL Workbench
- JUnit
- Mockito

To install Eclipse, follow this link: https://www.eclipse.org/ide/ and click on the download button. Once downloaded, go through the setup.

To install MySQL, follow this link: https://dev.mysql.com/downloads/installer/ and click on the SECOND download button. Once downloaded follow the setup process ensuring that you download MySQL Workbench and MySQL Command Line Client

To install Git, you need to follow this link https://git-scm.com/downloads and choose your Operating system



### Installing

Fork the IMS
create a folder for the project
right click the folder and click git bash here
next, clone the project down to your computer by following the commands on github


## Running the tests

We use two testing frameworks to test the functionality of the program; JUnit and Mockito.

JUnit is used for testing individual units or methods of classes, whereas mockito is used for integration testing to test the functionality between the SQL Database and the code in the java files. 

To run the unit tests, right click on the class in which the unit you would like to test is and click run as, and then JUnit test.

To run an integration test, do the same. 
This will also show the coverage percentage of which tests have passed and which tests have failed.

### Unit Tests 
We use JUnit for testing units.

Unit tests test the functionality of an individual method of a class, if the method is not working correctly you will see a red bar and an error along side a message within the console outlining the issue. Using the 'assertEquals' method, we are able to compare the outcome of the first argument within the parenthesis to the second argument, ensuring that they output the same outcome. 

```
Unit test example:

	@Test
	public void testCreate() {
		final Customer cust = new Customer();
		final Order created = new Order(cust);
		assertEquals(created, DAO.create(created));
	}
```

### Integration Tests 
We use Mockito to for integration tests. We use this to test the functionality between the database and the java classes of the project.

```
Here is an example of the syntax

	@Test
	public void testReadAll() {
		final Customer customer = new Customer(1L, "jordan", "harrison");
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(customer));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [Git](https://git-scm.com/) for versioning.

## Authors

Solomon Boundy

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Chris Perrins
* Jordan Harrison
* Jordan Bendeblaid
* JHarry444
