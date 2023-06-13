package monolitico.com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import monolitico.com.servicios.UsuarioService;
import monolitico.com.servicios.UsuarioServiceImp;

@WebServlet(urlPatterns = { "/identificar"})
public class VerificarLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UsuarioService usuarioService = new UsuarioServiceImp();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = (String) req.getParameter("usuario");
		String password = (String) req.getParameter("password");
		
		HttpSession misession = null;

		boolean existeUsuario;
		try {
			existeUsuario = usuarioService.login(usuario, password);
			if (existeUsuario) {
				misession = req.getSession(true);
				misession.setAttribute("usuario", usuario);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/home.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/pantallaError.jsp");
			dispatcher.forward(req, resp);
		}
	
	}

	
	
	
}
