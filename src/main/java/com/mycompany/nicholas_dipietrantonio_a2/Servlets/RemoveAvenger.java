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
 * 
 * @author Nicholas Di Pietrantonio
 */
public class RemoveAvenger extends HttpServlet {

    /**
     * 
     * @param request servlet request object
     * @param response servlet response object
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String password = request.getParameter("password");
        String avengerName = request.getParameter("avengerName");
        boolean throwException = false;
        request.setAttribute("avengerName", avengerName);

        try {
            ArrayList <Avenger> avengers = AvengerDb.getAvengers();
            for (int i = 0 ; i < avengers.size() ; i++) {
                //kind of awkward if statements but I wanted different messages
                //for wrong nam and wrong password
                if(!password.equals(PasswordDb.getPassword())) {
                    throw new Exception("Password not correct");
                } else if (avengers.get(i).getAvengerName().equals(avengerName)) {
                    AvengerDb.removeAvenger(avengerName);
                    throwException = false;
                } else {
                    throwException = true;
                }
            }
            if (throwException) {
                throw new Exception("Avenger name does not Exist");
            }
            
        } catch (Exception ex) {
            request.setAttribute("error", ex.toString());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("avengerRemoved.jsp");
        rd.forward(request, response);
    }

}
