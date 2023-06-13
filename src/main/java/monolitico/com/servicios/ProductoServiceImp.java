package monolitico.com.servicios;

import java.util.List;

import monolitico.com.dao.ProductoDao;
import monolitico.com.dao.ProductoDaoImp;
import monolitico.com.domain.Producto;

public class ProductoServiceImp implements ProductoService{

	private ProductoDao productoDao = new ProductoDaoImp();
	
	@Override
	public List<Producto> listar() {
		return productoDao.listar();
	}

	@Override
	public void agregarProducto(String nombre, int precio, int stock) throws Exception {
		productoDao.agregarProductoS(nombre, precio, stock);
	}

	@Override
	public void eliminar(int id) throws Exception {
		productoDao.eliminar(id);
	}

	@Override
	public void editar(int id, int stock, int precio) throws Exception {
		productoDao.editar(id, stock, precio);
	}

	@Override
	public Producto buscarProducto(int id) throws Exception {
		return productoDao.buscarProducto(id);
	}

}
