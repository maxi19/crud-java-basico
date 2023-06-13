package monolitico.com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monolitico.com.domain.Producto;
import monolitico.com.servicios.ProductoService;
import monolitico.com.servicios.ProductoServiceImp;

@WebServlet(urlPatterns = { "/editarProductoForm"})
public class CargarFormularioEditarProductoServlet extends HttpServlet{

	private ProductoService productoService = new ProductoServiceImp();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().
				getRequestDispatcher("/editProductoForm.jsp");
		
		String idProducto = req.getParameter("idProducto");
		int id = Integer.parseInt(idProducto);
		
		try {
			
			Producto prod = productoService.buscarProducto(id);
			req.setAttribute("producto",prod);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dispatcher.forward(req, resp);
	}

	
	
}
