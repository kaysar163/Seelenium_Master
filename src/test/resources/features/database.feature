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


  @verifyNewlyAddedOrdersInTheDatabase    #Fazilet :
  Scenario: Verify that newly added orders should be in the database
    Given connection is already established
    When the user add new order
    Then Newly added order should be in the database


       #Irshad
  @verifyCreditMemoOnDB
  Scenario: Verify that newly added credit memos should be in the database
    Given connection is already established
    When a credit memo should be created
    Then the newly created credit memo should be appeared on database

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






     @Writer:Muyesser   #Muyesser :
     @VerifyNewlyAddedSubCategoriesInTheDatabase
     Scenario: Verify that newly added sub categories should be in the database
       Given connection is already established
       When a new sub category should be added to the category page under root category
       Then the newly added sub category should be ın the data base






     @verifyNewlyAddedStoreViewInTheDatabase  #Renagul :
       Scenario: verify that newly added store view should be in the database
       Given connection is already established
       When  new added store should be added to the store page
       Then  newly added store view should be in the database






  @Writer:Rizvangul
    @verifyNewlyAddedCartPriceRuleInTheDatabase
    Scenario:verify that newly added cart price rule should be in the database
    Given connection is already established
    When a new cart price rule should be added on the shopping cart price rules page
    Then the newly added cart price rule should be in the database






    @verifyNewlyAddedTaxRuleShouldBeInTheDatabase  #Fazilet :
      Scenario: verify that newly added tax rule should be in the database
      Given connection is already established
      When a new tax rule add to the manage tax rule page
      Then the newly added tax rule should be in the database






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
  @writer:Gülzar
  @VerifynewAddedProductsShouldBeInTheDatabase
  Scenario: Verify that  new added products should be in the database
    Given   connection is already established
    When    a user add new product to system
    Then    new added product should be in the database