package servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import dto.User;
import service.UserService;

@WebServlet("/login")
public class loginservlet extends HttpServlet {

	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userService.getUser(username);
		
		if (username!=null && username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			request.getSession().setAttribute("user", username);
			if(user.getRole().equals("admin")) {
				response.sendRedirect(request.getContextPath() + "/admin");
			} else if(user.getRole().equals("user")) {
				response.sendRedirect(request.getContextPath() + "/user");
			}
		} else {
			request.setAttribute("errorMessage", "Invalid username or password. Try again.");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}
}