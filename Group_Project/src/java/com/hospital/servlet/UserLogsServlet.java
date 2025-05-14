/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.LogDAO;
import com.hospital.dao.impl.LogDAOImpl;
import com.hospital.model.LogEntry;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/user-logs")
public class UserLogsServlet extends HttpServlet {
    private LogDAO logDAO = new LogDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LogEntry> logs = logDAO.findAllUserLogs();
        req.setAttribute("logsList", logs);
        req.getRequestDispatcher("/WEB-INF/admin/user-logs.jsp").forward(req, resp);
    }
}