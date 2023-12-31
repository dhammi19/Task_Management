package com.cybersoft.crm.controller;

import com.cybersoft.crm.service.JobService;
import com.cybersoft.crm.service.StatusService;
import com.cybersoft.crm.service.TaskService;
import com.cybersoft.crm.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "jobDetailPage", urlPatterns = {"/job-detail"})
public class JobDetailPage extends HttpServlet {
    private JobService jobService = new JobService();
    private StatusService statusService = new StatusService();
    private TaskService taskService = new TaskService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String name = (String) session.getAttribute("userName");
        int id = Integer.parseInt(req.getParameter("id"));

        req.setAttribute("userName", name);
        req.setAttribute("job", jobService.getJobById(id));
        req.setAttribute("statuses", statusService);
        req.setAttribute("task", taskService);
        req.setAttribute("user", userService);
        req.getRequestDispatcher("/groupwork-details.jsp").forward(req, resp);
    }
}
