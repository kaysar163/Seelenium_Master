@RegressionSuite @MarketingModuleTest
  Feature: Marketing module manager should be able to manage marketing

    #Kaysar : Add new catalog price rule






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






      #Halit : Update Existing reviews






      #Muyesser : Update Pending reviews






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





      #Fazilat : delete an existing Newsletter template






      #Rizvangul : view newsletter subscribers