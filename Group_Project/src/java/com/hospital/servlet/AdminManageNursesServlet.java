/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.NurseDAO;
import com.hospital.dao.impl.NurseDAOImpl;
import com.hospital.model.Nurse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fawas
 */
@WebServlet("/admin/manage-nurses")
public class AdminManageNursesServlet extends HttpServlet {
    private NurseDAO dao = new NurseDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Nurse> list = dao.findAll();
        req.setAttribute("nursesList", list);
        req.getRequestDispatcher("/admin/manage-nurses.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("save".equals(action)) {
            Nurse n = new Nurse();
            n.setName(req.getParameter("name"));
            n.setEmail(req.getParameter("email"));
            n.setPassword(req.getParameter("password"));
            n.setSpecialization(req.getParameter("specialization"));
            dao.save(n);
        } else if ("delete".equals(action)) {
            dao.deleteById(Integer.parseInt(req.getParameter("nurseId")));
        }
        resp.sendRedirect(req.getContextPath() + "/admin/manage-nurses");
    }
}