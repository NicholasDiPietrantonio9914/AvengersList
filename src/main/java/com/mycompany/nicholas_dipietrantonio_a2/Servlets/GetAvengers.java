package com.mycompany.nicholas_dipietrantonio_a2.Servlets;

import com.mycompany.nicholas_dipietrantonio_a2.Model.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * class is servlet that creates an arraylist of avengers and forwards it
 * to getAvengers.jsp
 * @author Nicholas Di Pietrantonio
 */
public class GetAvengers extends HttpServlet {

    /**
     * method uses GET and is called when the avengers list is needed
     * to be displayed
     * @param request servlet request object
     * @param response servlet response object
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            ArrayList <Avenger> avengers = AvengerDb.getAvengers();
            //no need to check if null because if databse is empty will return an
            //empty ArrayList
            request.setAttribute("avengers", avengers);
            
        } catch (Exception ex) {
            //after seeing these errors 40 times I can attest that this system
            //of multiple catches in different classes works
            request.setAttribute("error", ex.toString());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("getAvengers.jsp");
        rd.forward(request, response);
    }

}
