/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.FinanceDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Finance;

/**
 *
 * @author andre
 */
@WebServlet(name = "finance", urlPatterns = {"/finance"})
public class financeController extends HttpServlet {

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
            out.println("<title>Servlet finance</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet finance at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (idParam == null) {
            ArrayList<Finance> finance = FinanceDAO.getAllRecords();
            String financeJSON = mapper.writeValueAsString(finance);
            out.print(financeJSON);
            out.flush();
        } else {
            int id = Integer.parseInt(idParam);
            Finance finance = FinanceDAO.getRecordById(id);
            String financeJSON = mapper.writeValueAsString(finance);
            out.print(financeJSON);
            out.flush();
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
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String updateValue = request.getParameter("update");
            String deleteValue = request.getParameter("delete");
            String insertValue = request.getParameter("insert");

            if (insertValue != null) {
                String name = request.getParameter("name");
                String tipo = request.getParameter("tipo");
                String valor = request.getParameter("valor");
                FinanceDAO.saveRecord(new Finance(name, tipo, Double.parseDouble(valor)));
            } else if (updateValue != null) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String tipo = request.getParameter("tipo");
                String valor = request.getParameter("valor");
                
                Finance finance = new Finance(Integer.parseInt(id), name, tipo, Double.parseDouble(valor));
                FinanceDAO.updateRecord(finance);
           
            } else if (deleteValue != null) {
                String name = request.getParameter("name");
                String tipo = request.getParameter("tipo");
                String valor = request.getParameter("valor");
                FinanceDAO.saveRecord(new Finance(name, tipo, Double.parseDouble(valor)));
            }

            response.sendRedirect("http://localhost:8080/app1-crud/");
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
