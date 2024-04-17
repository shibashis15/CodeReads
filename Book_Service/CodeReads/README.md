# Online_BookStore_Backend


## Table of Contents
1. Backend Services:
   - User Service: Handles user registration, authentication, and profile management.
   - Book Service: Manages books, including retrieval, creation, and updates.
   - Cart Service: Manages the user's shopping cart and handles cart-related operations.
   - Order Service: Processes orders asynchronously using RabbitMQ for communication.
   - Notification Service: Sends notifications to users about order status updates using RabbitMQ.

2. RabbitMQ Message Broker:
   - Acts as a messaging system for asynchronous communication between services.
   - Publishes and subscribes to messages exchanged between services.
   - Provides reliability, scalability, and decoupling of backend services.

3. Database:
   - Utilizes a relational database (e.g., MySQL, PostgreSQL) to store data.
   - User Service, Book Service, Cart Service, and Order Service interact with the database for data retrieval and storage.

4. RESTful APIs:
   - Each backend service exposes RESTful APIs for communication with other services.
   - User Service API handles user-related operations.
   - Book Service API manages book-related operations.
   - Cart Service API manages cart-related operations.
   - Order Service API processes orders and communicates with the RabbitMQ broker.
   - Notification Service API sends notifications to users.

5. User Authentication and Authorization:
   - User Service handles user registration, authentication, and authorization using tokens or sessions.
   - Implements security measures to protect sensitive user information.

6. Event-Driven Order Processing:
   - When a user places an order, the Cart Service publishes an order message to the RabbitMQ broker.
   - The Order Service consumes the order message from the RabbitMQ queue and processes the order asynchronously.
   - The Order Service calculates the order total, updates inventory, and stores order information in the database.
   - Implement concurrency and multithreading within the Order Service to parallelize order processing and improve throughput.

7. Order Notifications:
   - When an order is placed or updated, the Order Service publishes a notification message to the RabbitMQ broker.
   - The Notification Service consumes the notification message and sends email notifications to users about order status updates.

8. Administrative Dashboard:
   - Provides an admin interface for managing books, categories, and user orders.
   - Admin users have elevated privileges to perform administrative tasks.
     
9. Event-Driven Order Processing:
   - When a user places an order, the Cart Service publishes an order message to the RabbitMQ broker.
   - The Order Service consumes the order message from the RabbitMQ queue and processes the order asynchronously.
   - The Order Service calculates the order total, updates inventory, and stores order information in the database.
   - Implement concurrency and multithreading within the Order Service to parallelize order processing and improve throughput.



## Description

Online BookStore Backend Made Using Java , SpringBoot 3x  , SpringSecurity 6x , RabbiMQ and MySQL as Database
