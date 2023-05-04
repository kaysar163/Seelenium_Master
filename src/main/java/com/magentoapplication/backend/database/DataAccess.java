package com.magentoapplication.backend.database;


import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DataAccess {

    public boolean getRegisteredCustomer(String customerEmail, Connection connection){
        boolean isRegisteredCustomerExist=false;
        Statement statement=null;
        ResultSet resultSet=null;
        CachedRowSet cachedRowSet=null;
        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String selectRegisteredCustomer=String.format("select * from `i5751295_mg2`.`mg_customer_entity` where email='%s'",customerEmail);
        try {
            resultSet=statement.executeQuery(selectRegisteredCustomer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultSet==null){
            System.out.println("no records found!!");
            return isRegisteredCustomerExist;
        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        int count=0;
        while (true){
            try {
                if (!cachedRowSet.next()){
                    break;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                int entityId=cachedRowSet.getInt("entity_id");
            String email=cachedRowSet.getString("email");
            count=cachedRowSet.getRow();
                System.out.println(String.format("entity_id=%d email=%s",entityId, email));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (count>=1)
            isRegisteredCustomerExist=true;

            return isRegisteredCustomerExist;
    }

        public boolean verifyCustomerGroupName(String customerGroupName, Connection connection){
            String selectCat = String.format("select * from mg_customer_group where customer_group_code='%s'", customerGroupName);
            try (PreparedStatement preparedStatement= connection.prepareStatement(selectCat);
                 ResultSet resultSet= preparedStatement.executeQuery();)
            {boolean isCustomerGroupAdded= resultSet.next();
                return  isCustomerGroupAdded;}
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



