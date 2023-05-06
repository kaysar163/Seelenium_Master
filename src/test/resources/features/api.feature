@RegressionSuite @ApiTest
  Feature: An Authorized User Should Be Able To Manage Customers CustomersGroups Products and Categories




          #Muradil :






         #Rizvangul :






         #Muyesser :






         #Fazilat :






            #Halit :






         #Abdustatar : We have a bug in this test but did automation test anyway upon Dolkun Tarim's request
    @PostCustomer
    Scenario: An authorized user should be able to post customer
      Given a valid username and a password
      When an authorized user sends a request to the customer end point
      Then the api should return created customer with 500 response code



         #Kaysar :






         #Renagul :






         #Mirehmidi :






         #Irsahd :






         #Memet :






         #Abdustatar
    @GetAllProducts
  Scenario: An authorized user should be able to get all products
  Given a valid username and a password
  When an authorized user sends a request to the product end point
  Then the api should return all product with 200 response code


         #Gulzar :






         #meryem :






         #Omercan
    @PutProduct
    Scenario: An authorized user should be able to put product
      Given a valid username and a password
      When an authorized user sends a request to the product put in point
      Then the api should return update product with 405 response code
