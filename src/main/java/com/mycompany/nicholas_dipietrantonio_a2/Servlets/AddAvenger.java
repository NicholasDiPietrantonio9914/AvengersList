
package com.mycompany.nicholas_dipietrantonio_a2.Servlets;

import com.mycompany.nicholas_dipietrantonio_a2.Model.Avenger;
import com.mycompany.nicholas_dipietrantonio_a2.Model.AvengerDb;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * class is a servlet that calls a method to add an avenger to the database and
 * forwards the user the confirmation at avengerAdded.jsp
 * @author Nicholas Di Pietrantonio
 */
public class AddAvenger extends HttpServlet{
    
    /**
     * method uses POST and is called when an avenger is to be added to the database
     * @param request servlet request object
     * @param response servlet response object
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String name = request.getParameter("avengerName");
            String description = request.getParameter("avengerDesc");
            int powerSource = Integer.parseInt(request.getParameter("powerSourceList"));
            
            //use getAvengers to check if name already exists in db
            ArrayList <Avenger> avengers = AvengerDb.getAvengers();
            
            for (int i = 0 ; i < avengers.size() ; i ++) {
                if (avengers.get(i).getAvengerName().equals(name)) {
                    throw new Exception("Avenger already exists");
                }
            }
            
            if (name == null || name.trim().equals("")) {
                throw new Exception("Name not valid");
            } else if (description == null || description.trim().equals("")) {
                throw new Exception("Description not valid");
            }
            
            AvengerDb.addAvenger(name, description, powerSource);
            
        } catch (Exception ex) {
            request.setAttribute("error", ex.toString());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("avengerAdded.jsp");
        rd.forward(request, response);
    }

}
