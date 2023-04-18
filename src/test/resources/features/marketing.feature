@RegressionSuite @MarketingModuleTest
  Feature: Marketing module manager should be able to manage marketing


    @AddNewCatalogPriceRule  #Kaysar : Add new catalog price rule
    Scenario: Marketing manger can add catalog price rule
      Given Admin user is already in the dashboard page
      When  Marketing Manger add a new catalog price rule
      Then  The new catalog price rule should be added




  #Mirehmidi : Add new cart price rule






    #Gulzar : View all reviews






    #Renagul : View pending reviews






     @filterShoppingCart    #Omercan : Filter shopping cart
       Scenario: Marketing manager should be able to filter shopping cart pricing rule by id and rule
         Given Admin user is already in the dashboard page
         When The user fills out shopping cart pricing rule id number and rule name
         Then Filtered shopping cart pricing rule should be display






      #Meryem : Update Existing Catalog price rule






      #Memet : Update Existing cart price rule
    @updateExistingCartPriceRule
      Scenario: marketing manager should be able to update existing cart price rule
      Given Admin user is already in the dashboard page
      When Marketing manager searches existing price rule name in the rule name field and click on search
      And Marketing manager clicks on the filtered rule name and should be navigated to edit rule page
      And Marketing manager changes the status and clicks on save
      Then The rule should have successfully been saved



    @updateExistingReviews  #Kaysar : Update Existing reviews
    Scenario: Marketing Manager can update existing reviews
      Given Admin user is already in the dashboard page
      When  Marketing Manger update the existing  reviews
      Then  The new reviews should be added


    @updtePendingReviews    #Muyesser : Update Pending reviews
   Scenario: Marketing manager should be able to update pending  reviews
        Given Admin user is already in the dashboard page
        When  user update pending reviews
        Then  pending reviews should be updated







      #Irshad : search Catalog Pricing Rule By Id and Rule







    @addNewNewsletterTemplate     #Abdusattar
  Scenario: Marketing Manager should be able to add new Newsletter template
  Given Admin user is already in the dashboard page
  When the user fills out Newsletter template information
  Then A new template should be added



     @editNewNewsletterTemplate #Abdusattar
  Scenario: Marketing Manager should be able to add new Newsletter template
  Given Admin user is already in the dashboard page
  When the user edits newsletter template information
  Then the newsletter template should be edited





      @deleteAnExistingNewsletterTemplate #Fazilat
  Scenario: Marketing Manager can delete an existing newsletter template
    Given Admin user is already in the dashboard page
    When the user deletes newsletter template information
    Then the newsletter template should be deleted





      @viewNewsletterSubscribers   #Rizvangul
  Scenario: Marketing Manager should be able to view Newsletter subscribers
        Given Admin user is already in the dashboard page
        When the user enter the Newsletter subscribers page
        Then Newsletter subscribers should be viewed.