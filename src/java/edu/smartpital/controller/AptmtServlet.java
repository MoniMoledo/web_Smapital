/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.smartpital.controller;

import edu.smartpital.model.Appointment;
import edu.smartpital.model.Medic;
import edu.smartpital.model.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class AptmtServlet extends HttpServlet {

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
        
        //logged patient
        Patient pa = null;
        //logged medic
        Medic me = null;
        //medic of the logged patient appointment
        Medic medp = null;
        Patient pam = null;
        //String medName = "";
        String teste = null;
        Date date = null;
        Time time = null;
        String prescription = "";
        List<Appointment> aptmts = new ArrayList<Appointment>();
        Appointment ap = null;
        
        DbConx db = new DbConx();
        Connection c = db.getConn();
        PreparedStatement p = null;
        System.out.println("conectou com o banco");
        boolean isPatient = (Boolean) request.getSession().getAttribute("isPatient");
        if(isPatient){
            pa = (Patient) request.getSession().getAttribute("user");
            String stmt = "Select * from Medic m,Appointment ap, Address a "
                + "where m.medcode=ap.medcode and ssn='"+pa.getSsn()+"' and m.address= a.id order by ap.status";
            p = c.prepareStatement(stmt);
           
            ResultSet rs = null;
            rs =p.executeQuery();
            System.out.println("É PACIENTE!!!!!!");
            while(rs.next()){
                date = rs.getDate("date");
                time = rs.getTime("date");
                 //teste = rs.getString("m.name");
                medp = new Medic(rs.getString("m.name"), rs.getString("m.email"), rs.getString("m.phone"), rs.getString("a.street"),
                    rs.getString("a.city"),rs.getString("a.state"), rs.getInt("m.age"),rs.getInt("a.hnumber"),rs.getString("ap.medcode"),rs.getString("m.specialty"));
                teste = medp.getName();
                ap = new Appointment(Integer.valueOf(rs.getString("ap.id")), medp, pa, date, time, rs.getString("ap.status"), rs.getString("ap.prescription"));
                
                aptmts.add(ap);
            }
            
        }else{
            me = (Medic) request.getSession().getAttribute("user");
            String stmt = "Select * from Patient p, Appointment ap, Address a "
                + "where p.ssn=ap.ssn and medcode='"+me.getMedcode()+"' and p.address= a.id order by ap.status";
            p = c.prepareStatement(stmt);

            ResultSet rs = null;
            rs =p.executeQuery();
            while(rs.next()){
                date = rs.getDate("date");
                time = rs.getTime("date");
                //String teste = rs.getString("p.name");
                pam = new Patient(rs.getString("p.name"), rs.getString("p.email"), rs.getString("p.phone"), rs.getString("a.street"),
                    rs.getString("a.city"),rs.getString("a.state"), rs.getInt("p.age"),rs.getInt("a.hnumber"),rs.getString("ap.ssn"));
                
                ap = new Appointment(Integer.valueOf(rs.getString("ap.id")), me, pam, date, time, rs.getString("ap.status"), rs.getString("ap.prescription"));               
                aptmts.add(ap);
        }}
            
            String url = "/aptmts.jsp";

            request.setAttribute("aptmts",aptmts);
            
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
            Logger.getLogger(AptmtServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AptmtServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AptmtServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AptmtServlet.class.getName()).log(Level.SEVERE, null, ex);
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