# OrderHub-SpringBoot

## Overview
OrderHUB is a project designed to manage orders, customers, and products in an e-commerce system. It provides endpoints for creating and retrieving orders, managing customers, and handling products.

### Entity Structure
Entities represent the core data structures of the application. In the OrderHUB project, entities include:
1. **Customer:** Represents individuals who place orders. It contains attributes like id (auto-generated), name, and email.  
                   *Relationships:* One-to-many relationship with OrderItem, Many-to-one relationship with Customer
2. **Order:**    Represents orders placed by customers. It includes attributes like orderId (auto-generated), orderDate, and customerId.
4. **Product:**  Represents items available for purchase. It contains attributes like productId, price, and productName.
5. **OrderItem:** Represents individual items within an order. It includes attributes like orderItemId (auto-generated), orderId, and productId.
                  *Relationships:* Many-to-one relationship with OrderEntity, Many-to-one relationship with Product

### Repository Layer 
The Repository Layer contains interfaces that extend CRUD Repository and are responsible for database interaction. 

CRUD Repository provides a set of methods to perform CRUD operations (Create, Read, Update, Delete) on entities.

**Reason for Usage:** CRUD Repository abstracts away the details of database operations, making it easier to interact with the database.
                      It reduces boilerplate code and simplifies data access operations.
The repository layer includes repositories for each entity:
1. **CustomerRepository:**  Provides CRUD (Create, Read, Update, Delete) operations for the Customer entity.
2. **OrderRepository:**     Provides methods to retrieve orders, including finding orders by customer ID.
3. **ProductRepository:**   Provides CRUD operations for the Product entity.
4. **OrderItemRepository:** Provides CRUD operations for the OrderItem entity.

### Service Layer
The Service Layer contains classes that encapsulate business logic and orchestrate interactions between the Repository Layer and the Controller Layer.

**Reason for Usage:** The Service Layer abstracts away complex business logic from controllers, ensuring better code organization and maintainability. It facilitates 
                    code reuse and enables unit testing of business logic independently of the controller layer.
The service layer includes services for managing business logic:
1. **CustomerService:**  Provides methods for retrieving and saving customers, encapsulating business logic related to customers.
2. **OrderService:**     Manages orders, including calculations of total purchase amounts for customers.
3. **ProductService:**   Handles product-related operations, such as retrieving all products and saving new products.
4. **OrderItemService:** Manages order items and provides methods for retrieving and saving order items.

### Controller Layer 
The Controller Layer consists of classes responsible for handling HTTP requests and returning appropriate responses.

**Reason for Usage:**  The Controller Layer acts as the entry point for incoming HTTP requests. It maps HTTP requests to specific methods and processes the request 
                     data. It also provides a mechanism for handling exceptions and returning meaningful responses to clients.
The controller layer exposes RESTful endpoints to interact with the application:
1. **OrderController:**       Handles requests related to orders, including creating orders, retrieving orders by ID, and calculating total purchase amounts for customers.
2. **OrderItemController:**   Manages order items and provides endpoints for retrieving all order items, retrieving order items by ID, and creating new order items.
3. **ProductController:**     Handles product-related requests, such as retrieving all products, retrieving products by ID, and saving new products.
4. **CustomerController:**    Manages customers and provides endpoints for creating customers, retrieving customers by ID, and retrieving all customers.

### DTO (Data Transfer Object)
DTOs are objects used to transfer data between different layers of an application, often between the client and the server.
1. **OrderDTO:**     Represents the order data transferred between the client and the server. It helps decouple the presentation layer from the business logic and database schema.
2. **OrderItemDTO:** Similar to OrderDTO, it represents order item data transferred between the client and the server.


# Request Flow
* ___Create customers using POST requests to /customers, providing details like name,email as JSON Object.___

* ___Add products using POST requests to /products,providing details like productName and price.___

* ___Place orders using POST requests to /orders, providing the order date and customer ID (please note that customerId sholud be present in customertable in database )___.

* ___Add order items using POST requests to /orderItems, specifying the order ID and product ID (please note that orderId and productId should be presnt in productTAble and Ordertable repesctively).___

* ___Retrieve orders and their details using GET requests to /orders/{orderId} and /orders.___

* ___Calculate the total purchase amount for a customer using GET requests to /orders/calculateTotalPurchaseAmount/{customerId}.___

# Conclusion

### OrderHUB is a comprehensive project for managing orders, customers, and products in an e-commerce system. It provides a robust architecture with clear separation of concerns and easy-to-use endpoints for interacting with the system.

#### For more details, refer to the source code and documentation provided with the project.
