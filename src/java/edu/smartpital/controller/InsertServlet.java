/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.smartpital.controller;

import edu.smartpital.model.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Monique
 */
public class InsertServlet extends HttpServlet {

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
        
        if(request.getParameter("action")!=null && request.getParameter("action").equals("getMedic") ){
            DbConx db = new DbConx();
            Connection c = db.getConn();
            PreparedStatement p = null;
            ResultSet rs = null;
            List<String> specialties = new ArrayList<String>();
            specialties.add(" ");
            String stmt = "Select Distinct specialty from Medic;";
            p=c.prepareStatement(stmt);
            rs=p.executeQuery();
            while(rs.next()){
                specialties.add(rs.getString("specialty"));
            }
            request.getSession().setAttribute("specialties", specialties);
             
           this.getServletContext().getRequestDispatcher("/newaptmt.jsp").forward(request, response);
            
         
        }
        
         if(request.getParameter("action")!=null && request.getParameter("action").equals("Insert") ){
            DbConx db = new DbConx();
            Connection c = db.getConn();
            PreparedStatement p = null;
            ResultSet rs = null;
            String specialty = request.getParameter("specialty");
            String medcode = request.getParameter("medic");
            
            
            
            Patient pat = (Patient) request.getSession().getAttribute("user");
            String date = request.getParameter("date");       
            String time = request.getParameter("time");
            date += " "+time;
            
            String status = "scheduled";
            String prescription = "";
            
            Statement st = null;            
            String stmt = "INSERT INTO Appointment (medcode,ssn,date,status,prescription) VALUES('"+medcode+"','"+pat.getSsn()+"','"+date+"','"+status+"','"+prescription+"');";           
            st = c.createStatement();
            st.executeUpdate(stmt);
           this.getServletContext().getRequestDispatcher("/AptmtServlet").forward(request, response);
            
         
        }
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
            Logger.getLogger(InsertServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InsertServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertServlet.class.getName()).log(Level.SEVERE, null, ex);
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
