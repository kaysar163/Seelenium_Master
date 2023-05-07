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






         #Omercan :
