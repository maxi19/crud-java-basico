package monolitico.com.servicios;

import java.util.List;

import monolitico.com.domain.Producto;

public interface ProductoService {

	public List<Producto> listar();
	
	public void agregarProducto(String nombre, int precio, int stock) throws Exception;
	
    public void eliminar(int id) throws Exception;
	
	public void editar(int id , int stock, int precio) throws Exception;

	public Producto buscarProducto(int id) throws Exception;

}
