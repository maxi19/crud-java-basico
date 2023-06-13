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

@WebServlet(urlPatterns = { "/agregarProducto"})
public class AgregarPrductoServlet extends HttpServlet{

	private ProductoService productoService = new ProductoServiceImp();	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/listar");

		String nombre = (String)req.getParameter("nombre");
		String stock = (String)req.getParameter("precio");
		String precio = (String)req.getParameter("stock");
		
		
		Producto nuevoProducto = new Producto();
		nuevoProducto.setNombre(nombre);
		nuevoProducto.setStock(Integer.parseInt(stock));
		nuevoProducto.setPrecio(Integer.parseInt(precio));
		
		try {
			productoService.agregarProducto(nuevoProducto.getNombre(), nuevoProducto.getPrecio(), nuevoProducto.getStock());

		} catch (Exception e1) {
			//redirigir a otra pagina error
			//si el producto existe tambien redirigir

		} 
		
		resp.sendRedirect("/listadoProductos");	

	}

}
