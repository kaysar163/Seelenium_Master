@RegressionSuite @DatabaseTest
  Feature: Database and UI connection tests



  #Kaysar :






  #Meryem :






    @Writer:Omercan :
      @verifyNewlyAddedProductRootCategoryInTheDatabase
      Scenario: Verify that newly added product root category should be in the database
        Given connection is already established
        When the user query the mg_catalog_category_entity_varchar table
        Then the user should add new root category






   @Writer:Abdusattar :
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