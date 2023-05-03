package com.magentoapplication.backend.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
    public boolean verifyNewProductAddedSuccessfully(String email, Connection connection) {
        boolean isProductAdded = false;
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;

        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String selectCatalog = String.format("select * from mg_catalog_category_entity_int where email='%s';", email);
        try {
            resultSet = statement.executeQuery(selectCatalog);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultSet == null) {
            System.out.println("No records found");
            return isProductAdded;
        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            String emailAddress = null;
            int count = 0;
            while (true) {
                try {
                    if (!cachedRowSet.next()) {
                        break;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                int entity_id = 0;
                try {
                    entity_id = cachedRowSet.getInt("entity_id");
                    emailAddress = cachedRowSet.getString("email");
                    System.out.println(String.format("catalog id=%d email=%s", entity_id, emailAddress));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (count >= 1 & emailAddress.equalsIgnoreCase(email))
                isProductAdded = true;
            return isProductAdded;
        }
    }
}



