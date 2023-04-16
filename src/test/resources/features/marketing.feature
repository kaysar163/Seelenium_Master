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






      #Muyesser : Update Pending reviews






      #Irshad : search Catalog Pricing Rule By Id and Rule






    @addNewNewsletterTemplate     #Abdusattar
  Scenario: Marketing Manager should be able to add new Newsletter template
  Given Admin user is already in the dashboard page
  When the user fills out Newsletter template information
  Then A new template should be added





      #Abdusattar : Update an existing Newsletter template






      #Fazilat : delete an existing Newsletter template






      @viewNewsletterSubscribers   #Rizvangul
  Scenario: Marketing Manager should be able to view Newsletter subscribers
        Given Admin user is already on the dashboard page
        When the user enter the Newsletter subscribers page
        Then Newsletter subscribers should be viewed.