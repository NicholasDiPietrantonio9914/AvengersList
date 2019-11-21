
package com.mycompany.nicholas_dipietrantonio_a2.TagHandlers;

import com.mycompany.nicholas_dipietrantonio_a2.Db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * class creates a custom tag to display power sources as a list
 * @author Nicholas Di Pietrantonio
 */
public class PowerSourceHandler extends SimpleTagSupport {
    
    /**
     * method creates connects to the data base and creates a list of power sources
     * @throws JspException 
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try {
            
            String driver = "org.postgresql.Driver";

            Class.forName(driver);
            
            //I forgot to do this for heroku in this class and had to re upload :(
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

            String sql = "select * from powersource";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            
            out.println("<select name='powerSourceList'>");
            
            while (rs.next()) {
                out.println("<option value='" + rs.getInt("id") +
                        "'>" + rs.getString("description") + "</option>");
            }
            
            out.println("</select>");
            
            
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in powerSourceList tag", ex);
        } catch (ClassNotFoundException ex) {
            throw new JspException("Error in powerSourceList tag", ex);
        } catch (Exception ex) {
            throw new JspException("Error in powerSourceList tag", ex);
        } finally {
            //ensure that conn, ps, and rs are closed even if a error is caught
            DBConnector.closeJDBCObjects(conn, ps, rs);
        }
    }

}
