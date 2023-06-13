package monolitico.com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monolitico.com.servicios.ProductoService;
import monolitico.com.servicios.ProductoServiceImp;

@WebServlet(urlPatterns = { "/editarProducto"})
public class EditarProductoServlet extends HttpServlet{

	private ProductoService productoService = new ProductoServiceImp();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getParameter("id");
		String stock = (String) req.getParameter("stock");
		String precio = (String) req.getParameter("precio");
		
		try {
			int idParseado = Integer.parseInt(id);
			int stockParseado = Integer.parseInt(stock);
			int precioParseado = Integer.parseInt(precio);
			productoService.editar(idParseado, stockParseado , precioParseado);
			resp.sendRedirect("/listadoProductos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	
}
