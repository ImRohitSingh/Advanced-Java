/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 * @author Rohit
 */
public class ServletDemo extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletDemo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletDemo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out;
        out = response.getWriter();
        
        //RequestDispatcher rd = request.getRequestDispatcher("index.html");
        //rd.include(request,response);
        
        String name = request.getParameter("uName");
        
        String URL = request.getRequestURL().toString();
        String URI = request.getRequestURI();
        String scheme = request.getScheme();
        String server = request.getServerName();
        int portNo = request.getServerPort();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String query = request.getQueryString();
        
        out.println("<h1>Hello, "+name+", your requested details are as follows: </h1><br/>");
        out.println("URL of the request: "+URL+"<br>");
        out.println("URI of the request: "+URI+"<br>");
        out.println("Scheme of the request: "+scheme+"<br>");
        out.println("Server Name: "+server+"<br>");
        out.println("Port Number: "+portNo+"<br>");
        out.println("Context Path: "+contextPath+"<br>");
        out.println("Servlet Path: "+servletPath+"<br>");
        out.println("Query String: "+query+"<br>");
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
