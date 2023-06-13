package monolitico.com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import monolitico.com.servicios.ProductoService;
import monolitico.com.servicios.ProductoServiceImp;

@WebServlet(urlPatterns = { "/listadoProductos"})
public class ListadoProductosServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductoService productoService = new ProductoServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/productosPage.jsp");
		req.setAttribute("productos",productoService.listar());
		dispatcher.forward(req, resp);
	}

}
