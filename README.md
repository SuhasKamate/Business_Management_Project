# Business Management Web Application : <br>
![home](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/068df66a-163e-413b-913f-2f66bafd814d)

## Project Desc : Business Management Web Application 
  => The Business Management web application is a comprehensive tool designed to help businesses manage various aspects of their operations. 
          It provides a user-friendly interface for tasks like managing customer data, inventory, orders, and more.

## Features  :

- **Customer Management**: Easily add, update, and delete customer information.
- **Inventory Management**: Keep track of your inventory items, including stock levels and pricing.
- **Order Management**: Manage customer orders such as order creation .
- **User Authentication**: Secure login and authentication for admin and staff members.
- **Role-Based Access Control**: Define roles and permissions for different user types.
- **Thymeleaf Templates**: Utilizes Thymeleaf for dynamic HTML templates.
- **Database Integration**: Integrated with MySQL for data storage.

## Technologies Used :

- Spring Boot: Backend framework for building Java-based web applications.
- Thymeleaf: Server-side Java template engine for dynamic HTML generation.
- MySQL: Relational database management system for data storage.
- IDE/Tool : Spring Tool Suite 4 (Eclipse)

## Installation :

1. Clone the repository : $ git clone https://github.com/SuhasKamate/SPRING_BOOT_PROJECT.git
2. Import the project inside STS/Eclipse :
     Open STS/Eclipse > file > import > maven > existing project > browse > finish .
3. Make sure in the BusinessProject directory.
4.Configure the database connection is application.properties (check the Database section for more information)
5.Run the project (by running main method is BusinessProjectApplication.java) OR right clink on the project > Run As > Spring Boot App
6.Open http://localhost:2330/home in any browser.
7.Now your tables will be created in the databse
   - You have to add one admin data manually to login as admin, So add one admin data.
    

## Database :

MySQL can be used as the database for this project. 
The database connection can be configured in the application.properties file, with the appropriate values for the following properties:
spring.datasource.name=[Your Database Name]
spring.datasource.url=jdbc:mysql://localhost:3306/[Your Database Name]
spring.datasource.password=[Your password]
spring.datasource.username=[Your username]
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
server.port=2330[Optional]

## WorkFlow :

![workflow](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/6c2c1857-70a0-40f5-aaa9-293a3b4c87a6)

## Preview :

![home](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/068df66a-163e-413b-913f-2f66bafd814d)
![products](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/1302b1a5-4ebe-4d02-aac5-7539eb4a6b3b)
![locate](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/e923ba3c-f5b7-4d4a-903f-840a93c1d157)
![login](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/3af269e3-87dd-438c-ba03-d8733b28c235)
![adminpanel](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/89304e46-476e-4846-895b-09d49c8945af)
![userpanel](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/9034a930-decb-409f-8d22-67d40eeee5a6)

### Exception page

![exceptionPage](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/7d097910-f56e-4201-8c5a-2b445d7f3bf9)
