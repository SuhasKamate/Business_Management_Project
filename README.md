# Business Management Web Application : <br>

![home (2)](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/e8db8f17-72d6-42a0-b264-def0bf883bbf)



## Project Desc : Business Management Web Application 
  => The Business Management Web Application is a comprehensive tool designed to help businesses manage various aspects of their operations. 
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

1. Clone the repository : $ git clone https://github.com/SuhasKamate/Business_Management_Project.git <br>

2. Import the project inside STS/Eclipse : <br>
     - Open STS/Eclipse > file > import > maven > existing project > browse > finish . <br>
     
3. Make sure you are in the Business_Management_Project directory. <br>

![packageExplorer](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/3ea1eb7f-8e49-4b76-96e4-798b6b8e8715)


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

![workflow](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/aea72470-49c8-41a4-8974-48737638ae19)





## Preview :


#### Products 

![products (2)](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/0496f63a-f30c-4108-91a7-966bd37b2b54)


#### Location 

![locateus](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/30e40d74-d2f0-48cb-91b3-ea515f12c498)



#### Login Page

![logins](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/9c1efb48-5b23-4a43-8c96-81d55a7b1180)




#### AdminPanel

![adminpanel](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/b89aa5ee-3f7f-4145-b063-048729e7fbe9)


#### UserPanel 

![userpanel](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/e0f81692-c049-4a2f-a78d-30d3906f4429)


### Exception page

![exceptionPage](https://github.com/SuhasKamate/Business_Management_Project/assets/126138738/4349a429-61ff-4ecd-a463-2900874e1ea5)
