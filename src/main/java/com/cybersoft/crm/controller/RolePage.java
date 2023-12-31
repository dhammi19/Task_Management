package com.cybersoft.crm.controller;

import com.cybersoft.crm.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "rolePage", urlPatterns = {"/role"})
public class RolePage extends HttpServlet {
    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String name = (String) session.getAttribute("userName");

        req.setAttribute("roles", roleService.getAllRoles());
        req.setAttribute("userName", name);
        req.getRequestDispatcher("/role-table.jsp").forward(req, resp);
    }
}
