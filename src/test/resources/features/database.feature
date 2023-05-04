@RegressionSuite @DatabaseTest
  Feature: Database and UI connection tests



  #Kaysar :






    @Writer:Meryem
    @VerifyCustomerGroup
    Scenario: Verify that new added customer groups should be in the database
      Given connection is already established
      When  add new customer group
      Then  Verify new added customer groups in database






    #Omercan :






   @Writer:Abdusattar
   @verifyNewlyRegisteredUsersInTheDatabase
  Scenario: Verify that newly registered users should be in the database
  Given connection is already established
  When a new user registers to the system
  Then the user should be in the database





      #Fazilat :






      #Irsahd :






      #Muradil :






      #Memet :






      #Muyesser :






      #Renagul :






      #Rizvangul :






      #halit :






      #Mirehmidi :






     #Gulzar :