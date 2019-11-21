package com.mycompany.nicholas_dipietrantonio_a2.Model;

import com.mycompany.nicholas_dipietrantonio_a2.Db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class used to pull information from the power source table
 * @author Nicholas Di Pietrantonio
 */
public class PowerSourceDb {

    /**
     * method used to pull information on the power source from the database
     * @param id power source id
     * @return the avengers power source
     * @throws Exception 
     */
    public static PowerSource getPowerSource(int id) throws Exception {

        //objects declared as here so they can be accessed anywhere in the method
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

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

            String sql = "select * from powersource where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                int tableId = Integer.parseInt(rs.getString("id"));
                String description = rs.getString("description");
                return new PowerSource(tableId, description);
            }
            return null;
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
