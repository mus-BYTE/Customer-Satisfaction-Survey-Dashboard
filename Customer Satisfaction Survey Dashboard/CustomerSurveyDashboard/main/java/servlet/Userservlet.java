package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/user")
public class Userservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = (String) request.getSession().getAttribute("user");
		if (user== null || user.isBlank()) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = (String) request.getSession().getAttribute("user");
		if (user.isBlank()) {
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
		}

		request.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request, response);
	}
}
