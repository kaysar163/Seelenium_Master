package com.magentoapplication.backend.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.magentoapplication.backend.database.ConnectionType.MSSQL;
import static com.magentoapplication.backend.database.ConnectionType.MYSQL;

public class DatabaseConnection {

    public static Connection connection(String dbUrl,String dbPort,String defaultDb,String dbUsername,
                                        String dbPassword,ConnectionType connectionType){
        Connection connection=null;
        String jtds_Driver="net.sourceforge.jtds.jdbc.Driver";
        String mySql_Driver="com.mysql.cj.jdbc.Driver";
        switch (connectionType){
            case MSSQL:
                try {
                    Class.forName(jtds_Driver);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String connectionUrl="jdbc:jtds:sqlserver://"+dbUrl+":"+dbPort+";DataBaseName="+defaultDb;
                try {
                    connection= DriverManager.getConnection(connectionUrl,dbPassword,dbPassword);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case MYSQL:
                try {
                    Class.forName(mySql_Driver);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Please Check mysql driver information");
                }
                String mySqlConnectionUrl = "jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + defaultDb + "?useSSL=false";
                try {
                    connection = DriverManager.getConnection(mySqlConnectionUrl, dbUsername, dbPassword);
                } catch (SQLException e) {
                    throw new RuntimeException("connection failed");
                }
                break;

            default:
                System.out.println("You need to specify a data base connection type MSSQL OR MYSQL!!");
        }
        try {
            //verify connection is established
            if (!connection.isClosed()){
                System.out.println("Database connection is established");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
        }

    public static void closeDataBaseConnection(Connection connection){
        try {
            if (connection.isClosed()){
                System.out.println("Connection has already closed!!");
            } else {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }


