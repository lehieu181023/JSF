/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example;

import com.Class.taikhoan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lehie
 */
public class dangnhap extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String dangnhap = request.getParameter("dangnhap");
        taikhoan tk = new taikhoan();
        List<taikhoan> ltk = tk.hienthi();
        if(dangnhap != null){
            for(int i = 0;i < ltk.size();i++){
                if(ltk.get(i).getTaikhoan().equals(username) && ltk.get(i).getMatkhau().equals(password) && "on".equals(ltk.get(i).getDuyet())){
                    session.setAttribute("username", username);
                    session.setAttribute("password", password);
                    break;
                }
            }
            if(session.getAttribute("username") != null){
                if("admin".equals((String)session.getAttribute("username"))){
                    request.getRequestDispatcher("pageadmin-qltk.jsp").forward(request, response);
                }
                else{
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
            else
            {
                
            }
        }
        else{
            request.getRequestDispatcher("dangnhap.html").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
