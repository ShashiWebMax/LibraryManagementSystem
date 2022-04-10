# Library Management System
## Simple Library management system using JAVA.

This is a Simple Library management system developed using the JAVA programing language. The program was developed using the Apache Netbeans IDE. The application uses JDK 17 and MySQL server. This was developed by me for a campus assigmnet. 

## Setup

The `dbSetup.sql` file in the root directory can be used to create the required database. Database connection can be configured in the `DB/Database.java` file.
```PHP
/**
 * Database Configuration variables
 */
 private String dbName = "LibraryDB";
 private String dbUsername = "root";
 private String dbPassword = ""; 
```


## The system has these basic library management functions 
* Register and manage library members
* Register and manage Books
* Lend books, return books and track landed books
* Register system users

## Class Diagram
![class diagram](screenshots/class_diagram.png)

## Database design Diagram
![Database design](screenshots/database_design.png)

## UI
### Login
![Login](screenshots/login.png)

### User Registration
![User Registration](screenshots/user_registration.png)

### Main screen
![Main screen](screenshots/main_screen.png)

### Book Registration
![Book Registration](screenshots/book_registration.png)

### Book Lending
![Book Lending](screenshots/book_lending.png)

### Member registration
![Member registration](screenshots/member_registration.png)

### Manage Members
![Manage Members](screenshots/manage_members.png)



