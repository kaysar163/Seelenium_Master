package com.magentoapplication.backend.database;

import com.magentoapplication.ui.frontend.usermodule.TestHelperFrontEnd;
import com.magentoapplication.utility.ApplicationConfig;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DataAccess {

    public boolean getRegisteredCustomer(String customerEmail, Connection connection) {
        boolean isRegisteredCustomerExist = false;
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String selectRegisteredCustomer = String.format("select * from `i5751295_mg2`.`mg_customer_entity` where email='%s'", customerEmail);
        try {
            resultSet = statement.executeQuery(selectRegisteredCustomer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultSet == null) {
            System.out.println("no records found!!");
            return isRegisteredCustomerExist;
        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        int count = 0;
        while (true) {
            try {
                if (!cachedRowSet.next()) {
                    break;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                int entityId = cachedRowSet.getInt("entity_id");
                String email = cachedRowSet.getString("email");
                count = cachedRowSet.getRow();
                System.out.println(String.format("entity_id=%d email=%s", entityId, email));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (count >= 1)
            isRegisteredCustomerExist = true;

        return isRegisteredCustomerExist;

    }

    public boolean assertStoreExists(String storeName, Connection connection) {
        String addedStore = String.format("SELECT * FROM `i5751295_mg2`.`mg_core_store_group` WHERE store_name = %s", storeName);

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(addedStore);
                ResultSet resultSet = preparedStatement.executeQuery();) {
            boolean storeExists = resultSet.next();

            return storeExists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean theAddedRefundShouldBeInTheDatabase(String refundName, Connection connection) {
        String addedStore = String.format("Select * from mg_sales_refunded_aggregated", refundName);

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(addedStore);
                ResultSet resultSet = preparedStatement.executeQuery();) {
            boolean storeExists = resultSet.next();

            return storeExists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifyCustomerGroupName(String customerGroupName, Connection connection) {
        String selectCat = String.format("select * from mg_customer_group where customer_group_code='%s'", customerGroupName);
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectCat);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            boolean isCustomerGroupAdded = resultSet.next();
            return isCustomerGroupAdded;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //*********************************************************************
    //Kaysar - Verify that newly added customers should be in the database
    public boolean getCustomerEmail(String email, Connection connection) {
        boolean isCustomerEmailExist = false;
        Statement statement = null;//to execute SQL Script S
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String emailSqlScript = String.format("select entity_id,email from mg_customer_entity where email='%s'", email);
        try {
            resultSet = statement.executeQuery(emailSqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //verify the result set
        if (resultSet == null) {
            System.out.println("No Customer Found");

        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
//count the record lines
        int count = 0;
        while (true) {
            try {
                if (!cachedRowSet.next()) {
                    break;
                }
                try {
                    //  int websiteId=cachedRowSet.getInt("website_id");
                    int entityId = cachedRowSet.getInt("entity_id");
                    String customerEmail = cachedRowSet.getString("email");
                    System.out.println(String.format(" entity_id=%d email=%s", entityId, customerEmail));
                    count = cachedRowSet.getRow();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (count >= 1)
                isCustomerEmailExist = true;
        }
        return isCustomerEmailExist;
    }

    public boolean verifyCatAdded(String catName, Connection connection) {
        String selectCat = String.format("select * from mg_catalog_category_entity_varchar where value='%s'", catName);
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectCat);

             ResultSet resultSet = preparedStatement.executeQuery();) {
            boolean isCatAdded = resultSet.next();
            return isCatAdded;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public boolean verifyCartPriceRuleAdded(String  ruleName, Connection connection){
        String selectCartPriceRule=String.format("SELECT * FROM `i5751295_mg2`.`mg_catalog_category_entity_varchar` WHERE value ='%s'",
                ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties","ruleName"));

        PreparedStatement preparedStatement= null;

        try {
            preparedStatement = connection.prepareStatement(selectCartPriceRule);
            ResultSet resultSet=preparedStatement.executeQuery();
            {
                boolean cartPriceRuleExist = resultSet.next();
                return cartPriceRuleExist;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    public boolean verifyNewlyAddedSubCategoriesInTheDatabase(String subName, Connection connection){
        String selectSubCat=String.format("SELECT * FROM `i5751295_mg2`.`mg_catalog_category_entity_varchar` WHERE value ='%s'",subName);

        PreparedStatement preparedStatement= null;

        try {
            preparedStatement = connection.prepareStatement(selectSubCat);
            ResultSet resultSet=preparedStatement.executeQuery();
            {
                boolean isSubCatAdded = resultSet.next();
                return isSubCatAdded;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean verifyNewlyAddedStoreView(String storeViewName, Connection connection) {
        String selectStore = String.format("select * from mg_core_store where name='%s'", storeViewName);
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectStore);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            boolean isNewStoreViewAdded = resultSet.next();
            return isNewStoreViewAdded;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}




