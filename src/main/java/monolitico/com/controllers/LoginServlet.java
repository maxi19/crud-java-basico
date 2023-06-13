package monolitico.com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/login"})
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession misession = req.getSession(true);
		
		String usuario = (String) misession.getAttribute("usuario");
		
		if (usuario !=null ) {
			resp.sendRedirect("/listar");
		}else {
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}
	}

}
