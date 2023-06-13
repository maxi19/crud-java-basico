package monolitico.com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monolitico.com.servicios.ProductoService;
import monolitico.com.servicios.ProductoServiceImp;

@WebServlet(urlPatterns = { "/eliminarProducto"})
public class EliminarProductoServlet extends HttpServlet {

	private ProductoService productoService = new ProductoServiceImp();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id =(String)req.getParameter("idproducto");
			int idProducto = Integer.parseInt(id);
			productoService.eliminar(idProducto);
			//resp.sendRedirect("/listadoProductos");	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
