@RegressionSuite @ApiTest
  Feature: An Authorized User Should Be Able To Manage Customers CustomersGroups Products and Categories




          #Muradil :
    @GetAllCategories
    Scenario: An authorized user should be able to get all categories
      Given a valid username and a password
      When an authorized user sends a request to the category end point
      Then the api should return all categories with 200 response code





         #Rizvangul :






         #Muyesser :
    @putCategory
      Scenario:  An authorized user should be able to put category
      Given a valid username and a password
      When  an authorized user sends a put request to the category end point
      Then  the api should return a category with 200 response code






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
    @Getcustomergroups
    Scenario: An authorized user should be able to post customer
      Given a valid username and a password
      When user should be able to send Get request with customer group end point
      Then the api should return a response code of 200






         #Irsahd :






         #Memet :
    @CustomerGroupUpdate
      Scenario: It should be possible to Update a Customer Group
      Given a valid username and a password
      When user makes a request to update customer group info
      Then user should have the status code "204" displayed






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
      Then the api should return update product with 204 response code
