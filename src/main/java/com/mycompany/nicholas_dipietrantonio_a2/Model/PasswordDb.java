
package com.mycompany.nicholas_dipietrantonio_a2.Model;

import com.mycompany.nicholas_dipietrantonio_a2.Db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class used to get the password for removing avengers
 * @author Nicholas Di Pietrantonio
 */
public class PasswordDb {
    
    /**
     * method returns a password to remove an avenger
     * @return the password
     * @throws Exception 
     */
    public static String getPassword() throws Exception {

        //objects declared as here so they can be accessed anywhere in the method
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        String password = null;

        try {

            String driver = "org.postgresql.Driver";

            Class.forName(driver);

            String dbUrl = System.getenv("JDBC_DATABASE_URL");

            if (dbUrl != null && dbUrl.length() > 0) {
                conn = DBConnector.getConnection(driver, dbUrl);
            } else {
                String connUrl = "jdbc:postgresql://localhost/";
                String database = "AvengersDb";
                String user = "postgres";
                //my passwords are very secure
                String pass = "admin";
                
                conn = DBConnector.getConnection(driver, connUrl, database,
                    user, pass);
            }

            String sql = "select * from pass";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if (rs.next()) {
                password = rs.getString("pass");
            }
            return password;
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            //ensure that conn, ps, and rs are closed even if a error is caught
            DBConnector.closeJDBCObjects(conn, ps, rs);
        }
    }

}
