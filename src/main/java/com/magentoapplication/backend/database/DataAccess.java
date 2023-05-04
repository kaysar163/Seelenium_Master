package com.magentoapplication.backend.database;

import java.sql.*;

public class DataAccess {

    public boolean verifyCatAdded(String catName, Connection connection){
        String selectCat = String.format("select * from mg_catalog_category_entity_varchar where value='%s'", catName);
        try ( PreparedStatement preparedStatement= connection.prepareStatement(selectCat);

        ResultSet resultSet= preparedStatement.executeQuery();)
        {boolean isCatAdded= resultSet.next();
        return  isCatAdded;}
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

