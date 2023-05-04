package com.magentoapplication.backend.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
    public boolean addRottCategory(String value, Connection connection) {
        boolean isRootCategoryAdded = false;
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


        String selectProduct = String.format("select value from  mg_catalog_category_entity_varchar where value='%s'", value);

        try {
            resultSet = statement.executeQuery(selectProduct);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultSet == null) {
            System.out.println("No records found!!");
            return isRootCategoryAdded;
        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
//            int count=0;
            String value_name= null;

            while (true) {
                try {
                    if (!cachedRowSet.next()) {
                        break;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                try {
                    String value_id = cachedRowSet.getString("value_id");
                    value = cachedRowSet.getString("value");
                    System.out.println(String.format("value=%s,value_id=%d", value,value_id));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (value_name.equals(value))
                isRootCategoryAdded = true;
            return isRootCategoryAdded;
        }


    }
}

