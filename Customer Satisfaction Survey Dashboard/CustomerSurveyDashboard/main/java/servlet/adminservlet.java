package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class adminservlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String user = (String) request.getSession().getAttribute("user");
    if (!"admin".equals(user)) {
      response.sendRedirect(request.getContextPath() + "/login");
      return;
    }

    request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String user = (String) request.getSession().getAttribute("user");
    if (!"admin".equals(user)) {
      response.sendRedirect(request.getContextPath() + "/login");
      return;
    }

    String action = request.getParameter("action");
    if ("addProduct".equals(action)) {
      String productName = request.getParameter("productName");
      // Add the product to the database or wherever you're storing the products

      request.setAttribute("message", "Product added successfully");
    } else if ("defineKPI".equals(action)) {
      String kpiName = request.getParameter("kpiName");
      String kpiDefinition = request.getParameter("kpiDefinition");
      // Save the KPI to the database or wherever you're storing the KPIs

      request.setAttribute("message", "KPI defined successfully");
    } else if ("createUser".equals(action)) {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      String role = request.getParameter("role");
      // Save the user to the database or wherever you're storing the users

      request.setAttribute("message", "User created successfully");
    } else if ("assignRole".equals(action)) {
      String username = request.getParameter("username");
      String role = request.getParameter("role");
      // Assign the role to the user in the database or wherever you're storing the users

      request.setAttribute("message", "Role assigned successfully");
    } else if ("tagToProject".equals(action)) {
      String username = request.getParameter("username");
      String project = request.getParameter("project");
      // Tag the user to the project in the database or wherever you're storing the projects

      request.setAttribute("message", "User tagged to project successfully");
    }
    request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
}
}
