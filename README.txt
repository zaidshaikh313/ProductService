Product Service Application is designed to perform CRUD Operations On Product Entity.


How To Start The Project - 
1. Open Project in either Intelij or Eclipse or Spring Boot Tool Suit 

2. Check your java version is similar to project's (Project's Java version used is 17 in pom.xml)

3. Run The ProductServiceApplication.java file
	Project will successfully run on localhost:8080 

4. You can Test the Application using url - http://localhost:8080/swagger-ui.html  .

5. You can visit http://localhost:8080/h2-console . For cheecking the database used.
creds for h2 console are - 
	spring.datasource.url=jdbc:h2:mem:testdb
	spring.datasource.username=zaid
	spring.datasource.password=zaid

6. Run FrontEnd application present in https://github.com/zaidshaikh313/ProductServiceFrontEnd .
 By running ng serve command in terminal within the specific location.Provided that you have nodejs and angularCli Installed.

7. You can visit the FrontEnd application on http://localhost:4200/ afterrunning the application.

8. You can see all the products present in DB in UI and also add Product in cart, remove product from cart,see all products in cart.

9. You can also test some unit Test cases present in ProductServiceImplTest in package src/test/java/com.algoDomain.services.
