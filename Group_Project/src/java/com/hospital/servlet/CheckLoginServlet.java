/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.UserDAO;
import com.hospital.dao.impl.UserDAOImpl;
import com.hospital.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;
import java.sql.SQLException;

@WebServlet("/admin/login")
public class CheckLoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserDAO dao = new UserDAOImpl() {};
        User user = dao.validateUser(email, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("dashboard.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }}

       /** Optional<User> optionalUser = userDAO.findByUsernameAndPassword(email, password);
        if (optionalUser.isPresent()) {
            HttpSession session = req.getSession(true);
            session.setAttribute("userId", optionalUser.get().getId());
            resp.sendRedirect(req.getContextPath() + "/dashboard");
        } else {
            req.setAttribute("error", "Invalid credentials");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
*/