@RegressionSuite @SalesModuleTest
  Feature: Sales Module Manager should be able to manage sales module


    @createNewOrder #Omercan :
    Scenario: Sales Manager should be able to create a new order
      Given Admin user is already in the dashboard page sales
      When the user create a new order
      Then the new order should be created






  #Mirehmidi :
    @SalesManagerViewInvoicesAndCommentsToInvoices
    Scenario: Sales Manager should be able to view invoices and add comments to invoice history
      Given Admin user is already in the dashboard page sales
      When  sales manager can view invoices on the invoices page
      Then sales manager should be able to view invoices





  @updateShipmentHistory #Meryem :
    Scenario: Sales Manager should be able to update (add shipment history and tracking information) shipments
      Given Admin user is already in the dashboard page sales
      When sales manager can update tracking and history information shipments
      Then sales manager should be able to comments to shipments





    @updateorderswithnstorpickup  #Kaysar :
    Scenario: Sales Manager should be able to update orders with in store pickup
      Given Admin user is already in the dashboard page sales
      When Sales Manager Update orders
      Then Orders should be Updated






      #Memet :
    @DeleteOrder
    Scenario: Sales manager should able to delete orders with in-store pickup
      Given Admin user is already in the dashboard page sales
      When Sales manager deletes order with in-store pickup
      Then Order should be successfully deleted






      #Halit :






      #Gulzar :






      #Irsahd :






    @ViewShoppingCartForCustomers  #Abdusattar :
  Scenario: Sales Manager should be able to manage view shopping cart for customers
  Given Admin user is already in the dashboard page sales
  When the user view shopping cart for customers
  Then shopping list display





      #Rizvangul :






      #Renagul :