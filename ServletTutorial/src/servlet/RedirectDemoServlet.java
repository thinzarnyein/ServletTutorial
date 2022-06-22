package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/redirectDemo")
public class RedirectDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Request:
	// http://localhost:8080/ServletTutorial/other/redirectDemo?redirect=true
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get the value of parameter on the URL.
		String redirect = request.getParameter("redirect");

		if ("true".equals(redirect)) {
			System.out.println("Redirect to ShowMeServlet");

			// contextPath: Is an empty string "" or non-empty.
			// If it is non-empty, it always starts with /
			// and does not ends with /
			String contextPath = request.getContextPath();

			// ==> /ServletTutorial/showMe
			response.sendRedirect(contextPath + "/showMe");
			return;
		}

		ServletOutputStream out = response.getOutputStream();
		out.println("<h3>Text of RedirectDemoServlet</h3>");
		out.println("- servletPath=" + request.getServletPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
