@RegressionSuite @ReportingModuleTest
Feature: Reporting module manager should be able to manage reporting module


    @VeiwTotalOrderedReport  #Omercan :
      Scenario Outline: Reporting Manager should be able to see Sales - Total Ordered Report
        Given Admin user is already in the dashboard page reporting
        When reporting manager fills out report date "<dateFrom>" and"<dateTo>"
        Then total ordered report should display
        Examples:
          |dateFrom  |dateTo    |
          |3/26/2023 |4/27/2023 |






    #Gulzar :






    #Meryem :






    #Meryem :






      #Kaysar :






      #Kaysar :






      #Mirehmidi :






      #Fazilat :






      #Halit :






      #Muradil :






      #Muyesser :






    #Muyesser :






     #Rizvangul :






     #Renagul :






      #Fazilat :





  @writer:Abdusattar
  @seeCustomersByNumberOfOrdersReport #Abdusattar :
  Scenario: Reporting Manager should be able to see Customers - Customers by number of orders Report
    Given Admin user is already in the dashboard page reporting
    When the user views the customers by number of orders report
    Then the user sees customers by number of orders report

  @writer:Abdusattar
  @seeTagsForCustomersReport #Abdusattar :
  Scenario: Reporting Manager should be able to see Tags for Customers Report
    Given Admin user is already in the dashboard page reporting
    When the user views tags for customers report
    Then the user sees customers tags



      #Irsahd :






      #Memet :
  @@writer:Memet
  @ViewPopularTags
  Scenario: Reporting manager should be able to view popular tags
    Given Admin user is already in the dashboard page reporting
    When Reporting manager clicks on popular button under tags button
    Then Reporting manager should view popular tags on popular tags page






      #Memet :
  @writer:Memet
  @ViewProductReviews
  Scenario: Reporting manager should be able to see product reviews
    Given Admin user is already in the dashboard page reporting
    When Reporting manager click on show reviews button on product reviews page
    Then reporting manager should be able to view all product reviews







