/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.smartpital.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jdt.internal.compiler.batch.Main;

/**
 *
 * @author fenius
 */
public class RegisterServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        ResultSet rs = null;

        
        String medcode ="";
        String stmt="";
        
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String specialty = request.getParameter("specialty");
        String street = request.getParameter("street");
        String number = request.getParameter("hnumber");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String ssn = request.getParameter("ssn");
        medcode= request.getParameter("medcode");
       
        
        String url = "/index.jsp";
        //get the database connection
        DbConx db = new DbConx();
        Connection c = db.getConn();
        Statement st = null;
        //---------------------------
        

        //insert address info
        stmt = "INSERT INTO Address (street, hnumber, city, state) VALUES('"+street+"',"+number+",'"+city+"','"+state+"');";
         st = c.createStatement();
         st.executeUpdate(stmt);
        
         
        //get address id ( because it is auto_increment)
        stmt = "SELECT `AUTO_INCREMENT` " +
            "FROM  INFORMATION_SCHEMA.TABLES " +
            "WHERE TABLE_SCHEMA = 'Smarpital' " +
            "AND   TABLE_NAME   = 'Address';";
        
        st = c.createStatement();
        rs = st.executeQuery(stmt);
        int id = 0;;
        while(rs.next()) id = rs.getInt("AUTO_INCREMENT");
        id--;
        
        
        if(medcode!=null) stmt = "INSERT INTO Medic "
                + "VALUES('"+medcode+"','"+name+"','"+password+"',"+age+",'"+email+"','"+phone+"','"+specialty+"',"+id+");";
        else stmt = "INSERT INTO Patient VALUES('"+ssn+"','"+name+"','"+password+"',"+age+",'"+email+"','"+phone+"',"+id+");";
        
        st.executeUpdate(stmt);
        
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
        
        rs.close();
        st.close();
        c.close();
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
