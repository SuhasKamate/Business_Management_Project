# Business Management Web Application : <br>

![home (2)](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/3eac6609-a88c-4219-a44a-a87ec6d55916)



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

1. Clone the repository : $ git clone https://github.com/SuhasKamate/SPRING_BOOT_PROJECT.git <br>

2. Import the project inside STS/Eclipse : <br>
     - Open STS/Eclipse > file > import > maven > existing project > browse > finish . <br>
     
3. Make sure you are in the Business_Management_Project directory. <br>
![packageExplorer](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/be818e01-1a2b-47da-9764-2727064faa93)

4.Configure the database connection is application.properties (check the Database section for more information). <br>

5.Run the project (by running main method is BusinessProjectApplication.java) OR right clink on the project > Run As > Spring Boot App. <br>

6.Open http://localhost:2330/home in any browser. <br>

7.Now your tables will be created in the databse. <br>
   - You have to add one admin data manually to login as admin, So add one admin data. <br>
    

## Database :

MySQL can be used as the database for this project. 
The database connection can be configured in the application.properties file, with the appropriate values for the following properties: <br>

spring.datasource.name=[Your Database Name] <br>
spring.datasource.url=jdbc:mysql://localhost:3306/[Your Database Name] <br>
spring.datasource.password=[Your password] <br>
spring.datasource.username=[Your username] <br>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver <br>
spring.jpa.hibernate.ddl-auto=update <br>
server.port=2330[Optional] <br>

## WorkFlow :

![workflow](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/6c2c1857-70a0-40f5-aaa9-293a3b4c87a6)


## Preview :

#### Products 
![products (2)](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/d4ed0d8a-e72d-42ee-8714-55ea521f3f76)


#### Location 
![locateus](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/d41482a8-8e80-4e2b-a1c6-07793d4e4d22)


#### Login Page
![logins](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/d596b345-23f9-4b77-aed1-359d073d75ad)


#### AdminPanel
![adminpanel](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/89304e46-476e-4846-895b-09d49c8945af)

#### UserPanel 
![userpanel](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/9034a930-decb-409f-8d22-67d40eeee5a6)

### Exception page

![exceptionPage](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/7d097910-f56e-4201-8c5a-2b445d7f3bf9)
