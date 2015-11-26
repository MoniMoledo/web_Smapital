/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.smartpital.controller;

import edu.smartpital.model.Medic;
import edu.smartpital.model.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fenius
 */
public class LoginServlet extends HttpServlet {

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
        boolean isPatient = true;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String url = "/index.jsp";
        DbConx db = new DbConx();
        Connection c = db.getConn();
        PreparedStatement p = null;
        //--------------------------
        String dbuser = "";
        String dbpass = "";
        //Medic variable
        String dbspecialty="";
        //Common variables
        String dbname="",dbemail="",dbphone="",dbstreet="",dbcity="",dbstate="";
        int dbage=0,dbhnumber=0;
        
        
        //check if it is a patient
        String stmt = "Select p.ssn,p.password,p.name,p.email,p.phone,a.street,a.city,a.state,p.age,a.hnumber from Patient p,Address a "
                + "where ssn='"+username+"' and password='"+password+"' and p.address=a.id;";
        p = c.prepareStatement(stmt);
       
        ResultSet rs = null;
        rs =p.executeQuery();
        while(rs.next()){
             dbuser = rs.getString("ssn");
             dbpass = rs.getString("password");
             dbname = rs.getString("name");
             dbemail = rs.getString("email");
             dbphone = rs.getString("phone");
             dbstreet = rs.getString("street");
             dbcity = rs.getString("city");
             dbstate = rs.getString("state");
             dbage = rs.getInt("age");
             dbhnumber = rs.getInt("hnumber");
        }
        if(dbuser=="" && dbpass ==""){
            //check if is a Medic
            isPatient=false;
            stmt = "Select p.medcode,p.password,p.name,p.email,p.phone,a.street,a.city,a.state,p.age,a.hnumber, p.specialty from Medic p,Address a "
                + "where medcode='"+username+"' and password='"+password+"' and p.address=a.id;";
            System.out.println(stmt);
            p=c.prepareStatement(stmt);
            rs=p.executeQuery();
             while(rs.next()){
              dbuser = rs.getString("medcode");
              dbpass = rs.getString("password");
              dbname = rs.getString("name");
              dbemail = rs.getString("email");
              dbphone = rs.getString("phone");
              dbstreet = rs.getString("street");
              dbcity = rs.getString("city");
              dbstate = rs.getString("state");
              dbage = rs.getInt("age");
              dbhnumber = rs.getInt("hnumber");
              dbspecialty = rs.getString("specialty");
             }
            }
        //check valid login
        if(dbuser.equals(username)&& dbpass.equals(password)){
            //correct login!
            //put the user at the session
            //foward to profile page
            url = "/profile.jsp";
            if(isPatient){
                Patient pa = new Patient(dbname,dbemail,dbphone,dbstreet,dbcity,dbstate,dbage,dbhnumber,dbuser);
                request.getSession().setAttribute("user",pa);
            }else{
                Medic me = new Medic(dbname,dbemail,dbphone,dbstreet,dbcity,dbstate,dbage,dbhnumber,dbuser,dbspecialty);
                request.getSession().setAttribute("user",me);
            }
        }else{
            //incorrect login!
            url= "/login.jsp";
            request.setAttribute("login_error", "Invalid login, Please Retry Credentials");
        }
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
