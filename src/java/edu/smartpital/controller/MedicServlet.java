/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.smartpital.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Monique
 */
public class MedicServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
            DbConx db = new DbConx();
            Connection c = db.getConn();
            PreparedStatement p = null;
            ResultSet rs = null;
            List<String> specialties = new ArrayList<String>();
            specialties = (List<String>) request.getSession().getAttribute("specialties");
           List < Pair<String,String> > lpair = new ArrayList< Pair<String,String> >();
           String chosenSpclt = request.getParameter("option");
           
           if(chosenSpclt != null && !chosenSpclt.equals("---")){
               System.out.println("adsasdad");
            String stmt = "Select name,medcode from Medic where specialty= '"+chosenSpclt+"';";
            p=c.prepareStatement(stmt);
            rs=p.executeQuery();
            while(rs.next()){
                lpair.add(new Pair(rs.getString("medcode"),rs.getString("name")));
            }
            request.setAttribute("medics", lpair);
           
            specialties.remove(chosenSpclt);
            specialties.add(0, chosenSpclt);
            request.getSession().setAttribute("specialties", specialties);
            }
            if(chosenSpclt.equals("---")){
                specialties.remove(chosenSpclt);
                specialties.add(0, chosenSpclt);
              this.getServletContext().getRequestDispatcher("/newaptmt.jsp").forward(request, response); 
           }

            this.getServletContext().getRequestDispatcher("/newaptmt.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MedicServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MedicServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
