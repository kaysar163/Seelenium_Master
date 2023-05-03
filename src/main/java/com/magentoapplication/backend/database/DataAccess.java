package com.magentoapplication.backend.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
    public boolean getRefundedReport(String period, Connection connection) {
        boolean isCustomerExist = false;
        Statement statement = null;
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
        String refundedReportSQLScrip = String.format("select * from mg_sales_refunded_aggregated where period='%s'", period);
        try {
            assert statement != null;
            resultSet = statement.executeQuery(refundedReportSQLScrip);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultSet == null) {
            System.out.println("No records Found");
            return isCustomerExist;
        } else {
            try {
                assert cachedRowSet != null;
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count = 0, ordersCuntSum = 0;
            double refundedSum = 0;
            while (true) {
                try {
                    if (!cachedRowSet.next()) {
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String refundDate = cachedRowSet.getString("period");
                    int ordersCount = cachedRowSet.getInt("orders_count");
                    double refunded = cachedRowSet.getDouble("refunded");
                    System.out.printf("period=%s    orders_count=%d    refunded=%.2f%n", refundDate, ordersCount, refunded);
                    count = cachedRowSet.getRow();
                    ordersCuntSum = ordersCuntSum + ordersCount;
                    refundedSum = refundedSum + refunded;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            System.out.printf("On day %s refunded orders total = %d    Refunded sum = %.2f%n", period, ordersCuntSum, refundedSum);
            if (count >= 1)
                isCustomerExist = true;
            return isCustomerExist;
        }
    }


}
