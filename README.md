# IMS Fundamental Project

This project is a management system made to to add, remove and update customers, items and orders into a database in an easy and tidy way. It has features such as the total of the order as well as the item quantity. there will be four separate entities within the database that allows us access to customer information, order information item information and an 'orders_items' entity that allows us to add or remove items from an order as well as view every item added to each order.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them
In order to  get started with the project you will need to download and install the following:
- An IDE of your choice that supports Java (Eclipse is recommended)
- MySQL as well as MySQL Workbench


```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

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
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Chris Perrins
* Jordan Harrison
* Jordan Bendeblaid
