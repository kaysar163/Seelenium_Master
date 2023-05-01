@RegressionSuite @ReportingModuleTest
Feature: Reporting module manager should be able to manage reporting module


    @ViewTotalOrderedReport  #Omercan :
      Scenario Outline: Reporting Manager should be able to see Sales - Total Ordered Report
        Given Admin user is already in the dashboard page reporting
        When reporting manager fills out report date "<dateFrom>" and"<dateTo>"
        Then total ordered report should display
        Examples:
          |dateFrom  |dateTo    |
          |3/26/2023 |4/27/2023 |






    #Gulzar :






   @TotalInvoicedVsPaidReport  #Meryem :
  Scenario Outline: Reporting Manager should be able to see Sales - Total Invoiced vs Paid Report
    Given Admin user is already in the dashboard page reporting
    When Reporting Manager Navigate to Total Invoiced vs Paid Report page and select period and date "<dateFrom>" "<dateTo>" and click show Report button
    Then  Total Invoiced Vs Paid report view successfully
    Examples:
      | dateFrom |   dateTo|
      | 4/20/2023 | 4/25/2023 |



  @salesTotalShippedReport #Meryem :
  Scenario Outline: Reporting Manager should be able to see Sales - Total Shipped Report
    Given Admin user is already in the dashboard page reporting
    When reporting manager fills out report date for the shipped  "<dateFrom>" and"<dateTo>"
    Then   Total Shipped Report view successfully
    Examples:
      | dateFrom  | dateTo    |
      | 4/22/2023 | 4/28/2023 |






  @SeeSalesTotalRefundedReport   #Kaysar :
  Scenario Outline: Reporting Manage Should be able to see sales Total Refunded Report
    Given Admin user is already in the dashboard page reporting
    When reporting manager opens the Sales Total Refunded Report and fills out report data "<dateFrom>" and"<dateTo>"
    Then  Total Refunded should be displayed
    Examples:
      | dateFrom  | dateTo    |
      | 4/25/2023 | 4/28/2023 |









  @SeeSalesCouponsUsageReport   #Kaysar :
  Scenario: Reporting Manage Should be able to see sales Coupons Usage Report
    Given Admin user is already in the dashboard page reporting
    When  reporting manager opens the Sales Coupons Report
    Then  Coupons Usage should be displayed




      #Mirehmidi :
  @SeeAbandonedCartsReport
  Scenario: Reporting Manager should be able to see Shopping Cart Abandoned carts Report
    Given Admin user is already in the dashboard page reporting
    When  see Shopping Cart - Abandoned carts Report
    Then  verify see Shopping Cart - Abandoned carts Report





      #Fazilat :






  @ViewProductBestsellerReport  #Omercan :
  Scenario Outline: Reporting Manager should be able to see Products - Products Bestsellers Report
    Given Admin user is already in the dashboard page reporting
    When Reporting Manager view bestsellers page between time period "<dateFrom>" and"<dateTo>"
    Then Reporting manager should see bestsellers report
    Examples:
      | dateFrom  | dateTo    |
      | 4/11/2023 | 4/29/2023 |






      @ViewProductsOrderedReport  #Muradil :
    Scenario Outline: Reporting Manager should be able to see Products - Products Ordered Report
      Given Admin user is already in the dashboard page reporting
      When Reporting Manager view products "<dateFrom>" and "<dateTo>"
      Then Reporting Manager should see Ordered Report
      Examples:
        | dateFrom  | dateTo    |
        | 4/28/2023 | 4/29/2023 |








   #Muyesser :
  @seeMostViewedReport
  Scenario Outline: Reporting manager should be able to see products most viewed report
    Given Admin user is already in the dashboard page reporting
    When Reporting Manager view most viewed page between time period "<dateFrom>" and"<dateTo>"
    Then Reporting Manager should see most viewed report
    Examples:
      | dateFrom  | dateTo    |
      | 4/25/2023 | 4/28/2023 |







    @writer:Muyesser
      @seeLowStockReport
      Scenario: Reporting manager should be able to see low stock report
      Given Admin user is already in the dashboard page reporting
      When Reporting manager views low stock page
      Then Reporting manager should see low stock reports






     @writer:Rizvangul
       @seeProductsDownloadsReport
       Scenario: Reporting manager should be able to see products-products downloads report
       Given Admin user is already in the dashboard page reporting
       When Reporting manager views downloads page
       Then Reporting manager should see downloaded reports






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







