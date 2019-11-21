package com.mycompany.nicholas_dipietrantonio_a2.Db;

import java.sql.*;

/**
 * class used to connect to the database
 * @author Nicholas Di Pietrantonio Nov 14, 2019
 */
public class DBConnector {

    private static Connection conn = null;

    /**
     * A method that will connect to the specified JDBC driver
     *
     * @param driver driver to connect to
     * @param url url pointing to your database server
     * @param databaseName the database you want to connect to
     * @param username the db username to connect with
     * @param password password correspond to db username
     * @return returns the connection
     * @throws java.lang.Exception
     */
    public static Connection getConnection(String driver, String url,
            String databaseName, String username, String password) throws Exception {

        if (conn == null || conn.isClosed()) {
            
            try {
                
                Class.forName(driver);
                
                conn = DriverManager.getConnection(url + databaseName, username, password);

            } catch (Exception e) {
                
                StringBuilder message = new StringBuilder(e.getMessage()).append("\n");
                if (e instanceof SQLException) {
                    message.append(((SQLException) e).getSQLState()).append("\n");
                    message.append(((SQLException) e).getErrorCode()).append("\n");
                    message.append(((SQLException) e).getMessage()).append("\n");
                }
                
                throw new Exception(message.toString());
            }
        }
        
        return conn;
    }
    
    /**
     * a method used to connect to heroku
     * @param driver driver to connect to
     * @param herokuDbUrl url to the heroku database
     * @return
     * @throws Exception 
     */
    public static Connection getConnection(String driver, String herokuDbUrl) throws Exception {

        if (conn == null || conn.isClosed()) {
            // not set up yet...
            try {
                // load the class into the JVM. Doing runs the code that
                // registers the class as a JDBC driver
                Class.forName(driver);
                // get the connection from the DriverManager
                conn = DriverManager.getConnection(herokuDbUrl);

            } catch (Exception e) {
                // Build the error message
                StringBuilder message = new StringBuilder(e.getMessage()).append("\n");
                if (e instanceof SQLException) {
                    message.append(((SQLException) e).getSQLState()).append("\n");
                    message.append(((SQLException) e).getErrorCode()).append("\n");
                    message.append(((SQLException) e).getMessage()).append("\n");
                }
                // throw the exception to the caller!
                throw new Exception(message.toString());
            }
        }
        // return the connection
        return conn;
    }


    /**
     * Method to close all of the JDBC objects.
     *
     * @param conn connection to close
     * @param stmt statement to close (note that PreparedStatement is a
     * Statement)
     * @param rs ResultSet to close
     */
    public static void closeJDBCObjects(Connection conn, Statement stmt, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (Exception ignored) {}
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception ignored) {}
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ignored) {}
        }
    }

    /**
     * Method to close Connection and Statement only. Use this method when a
     * ResultSet is not needed
     *
     * @param conn connection to close
     * @param stmt statement to close
     */
    public static void closeJDBCObjects(Connection conn, Statement stmt) {
        closeJDBCObjects(conn, stmt, null);
    }
}