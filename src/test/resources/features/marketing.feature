@RegressionSuite @MarketingModuleTest
  Feature: Marketing module manager should be able to manage marketing

    #Kaysar : Add new catalog price rule






  #Mirehmidi : Add new cart price rule






    #Gulzar : View all reviews






    #Renagul : View pending reviews






      #Omercan : Filter shopping cart






      #Meryem : Update Existing Catalog price rule






      #Memet : Update Existing cart price rule






      #Halit : Update Existing reviews






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





      #Fazilat : delete an existing Newsletter template






      #Rizvangul : view newsletter subscribers