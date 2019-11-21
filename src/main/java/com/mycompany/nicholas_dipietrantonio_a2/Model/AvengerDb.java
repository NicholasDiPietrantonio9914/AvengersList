package com.mycompany.nicholas_dipietrantonio_a2.Model;

import com.mycompany.nicholas_dipietrantonio_a2.Db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Contains methods to add and retrieve from the database
 *
 * @author Nicholas Di Pietrantonio
 */
public class AvengerDb {

    /**
     * method is used to get a list of all the avengers
     *
     * @return All the avengers in the database
     * @throws Exception
     */
    public static ArrayList<Avenger> getAvengers() throws Exception {

        //objects declared as here so they can be accessed anywhere in the method
        //though about putting them as data fields so they could be used in both methods
        //but decided against, just felt wrong
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        ArrayList<Avenger> avengers = new ArrayList();

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

            String sql = "select * from avengers";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                //it would be nice if you could do an inner join to draw
                //from two table at once
                String name = rs.getString("avengername");
                String description = rs.getString("description");
                int id = Integer.parseInt(rs.getString("id"));
                int powerSourceId = Integer.parseInt(rs.getString("powersource"));

                PowerSource powerSource = PowerSourceDb.getPowerSource(powerSourceId);

                avengers.add(new Avenger(id, name, description, powerSource));
            }

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            //ensure that conn, ps, and rs are closed even if a error is caught
            DBConnector.closeJDBCObjects(conn, ps, rs);
        }
        return avengers;

    }

    /**
     * method used to add an avenger to the database
     *
     * @param name Avenger name
     * @param description Avenger description
     * @param powerSource Avenger powerSource
     * @throws Exception
     */
    public static void addAvenger(String name, String description,
            int powerSource) throws Exception {

        //objects declared as here so they can be accessed anywhere in the method
        //thought about putting them as data fields so they could be used in both methods
        //but decided against, just felt wrong
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {

            String driver = "org.postgresql.Driver";

            Class.forName(driver);

            //I also forgot to insert this heroku code and had to reupload the .war :((
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

            String sql = "insert into avengers(avengername, description, powersource)"
                    + "values(?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, powerSource);

            //use execute update because you are not pulling any information from
            //the database just updating
            ps.executeUpdate();

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            //ensure that conn, ps, and rs are closed even if a error is caught
            DBConnector.closeJDBCObjects(conn, ps, rs);
        }

    }
    
    /**
     * method used to remove an avenger from the database
     * @param avengerName the name of the avenger to remove
     * @throws Exception 
     */
    public static void removeAvenger(String avengerName) throws Exception {

        //objects declared as here so they can be accessed anywhere in the method
        //thought about putting them as data fields so they could be used in both methods
        //but decided against, just felt wrong
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

            String sql = "delete from avengers where avengername like ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, avengerName);

            //use execute update because you are not pulling any information from
            //the database just updating
            ps.executeUpdate();

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
