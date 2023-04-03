package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class feedbackservlet extends HttpServlet {

	  public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    PrintParams(request, response);

	  }

	  public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	    PrintParams(request, response);
	  }

	  public void PrintParams(HttpServletRequest request,
	      HttpServletResponse response) throws IOException {

	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    String htmlHeader = "<HTML><HEAD><TITLE> Printed Form Parameters </TITLE></HEAD><BODY>";
	    String htmlFooter = "</BODY></HTML>";

	    out.println(htmlHeader);
	    out.println("<TABLE ALIGN=CENTER BORDER=1>");
	    out.println("<tr><th> Input Name </th><th> Value </th>");

	    Enumeration enum = request.getParameterNames();

	    while (enum.hasMoreElements()) {
	      String inputName = (String) enum.nextElement();
	      String value = request.getParameter(inputName);

	      if (value.length() != 0) {
	        out.println("<tr><td align=center>" + inputName + "</td>");
	        out.println("<td align=center>" + value + "</td></tr>");
	      } else {
	        out.println("<tr><td align=center>" + inputName + "</td>");
	        out.println("<td align=center><i>Null</i></td></tr>");
	      }

	    }
	    out.println("</TABLE><BR>");
	    out.println(htmlFooter);
	  }
	}
