@RegressionSuite @DatabaseTest
  Feature: Database and UI connection tests




    @Writer:Kaysar
    @VerifyNewAddedCustomer
    Scenario: Verify that newly added customers should be in the database
      Given connection is already established
      When customer manager add a new customer
      Then customer manager should verify added customer  in the database






    @Writer:Meryem
    @VerifyCustomerGroup
    Scenario: Verify that new added customer groups should be in the database
      Given connection is already established
      When  add new customer group
      Then  Verify new added customer groups in database






    #Omercan :
    @verifyNewlyAddedProductRootCategoryInTheDatabase
    Scenario: Verify that newly added product root category should be in the database
      Given connection is already established
      When user can add root category
      Then the user should added new root category






   @Writer:Abdusattar
   @verifyNewlyRegisteredUsersInTheDatabase
  Scenario: Verify that newly registered users should be in the database
  Given connection is already established
  When a new user registers to the system
  Then the user should be in the database





      #Fazilat :






      #Irsahd :






      #Muradil:
      @verifyNewlyAddedStoreInTheDatabase
        Scenario: Verify that newly added store should be in the database
        Given connection is already established
        When a user can add new store in database
        Then the user should added new store







      #Memet :
    Scenario: verify that newly added stock should be present in the database
      Given connection is already established
      When a new store should be added on the store page
      Then the added store should appear in the database






      #Muyesser :






      #Renagul :






      #Rizvangul :






      #halit :






      #Mirehmidi :
    @Verifynewlyaddedrefundshouldbeinthedatabase
    Scenario Outline: Verify that newly added refund should be in the database
      Given  connection is already established
      When  view a new refund  from "<dateFrom>" and"<dateTo>"
      Then   the added refund should be in the database
      Examples:
        | dateFrom  | dateTo    |
        | 4/25/2023 | 4/28/2023 |







     #Gulzar :