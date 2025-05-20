/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.UserDAO;
import com.hospital.dao.impl.UserDAOImpl;
import com.hospital.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
@WebServlet(name = "AddUserServlet", urlPatterns = {"/AddUserServlet"})
public class AddUserServlet extends HttpServlet {
private final UserDAO userDao = new UserDAOImpl();

    // show the form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.getRequestDispatcher("add‑user.jsp")
           .forward(req, resp);
    }

    // process submission
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String fullname = req.getParameter("fullname");
        String email    = req.getParameter("email");
        String pwd      = req.getParameter("password");
        String role     = req.getParameter("role");

        if (role == null || role.isEmpty()) {
            req.setAttribute("error", "Please select a role.");
            req.getRequestDispatcher("add‑user.jsp")
               .forward(req, resp);
            return;
        }

        User u = new User();
        u.setFullname(fullname);
        u.setEmail(email);
        u.setPassword(pwd);
        u.setRole(role);   // ← now set

        userDao.save(u);
        resp.sendRedirect(req.getContextPath() + "/admin/manage-users");
    }
}