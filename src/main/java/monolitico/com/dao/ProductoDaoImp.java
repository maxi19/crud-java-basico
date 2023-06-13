package monolitico.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import monolitico.com.config.Connexion;
import monolitico.com.domain.Producto;

public class ProductoDaoImp implements ProductoDao {

	private List<Producto> productos = new ArrayList<Producto>();
	
	private Connexion conexion = Connexion.getInstance();

	@Override
	public List<Producto> listar() {
		 Statement st =null;
		 ResultSet rs = null;
		 Producto producto = null;
		 try{
			st = conexion.dameConnection().createStatement();
			rs = st.executeQuery ("select * from producto");
			productos = new ArrayList<Producto>();
			 while (rs.next()) {
				 producto = new Producto();
				 producto.setId(rs.getInt(1));
				 producto.setNombre(rs.getString(2));
				 producto.setPrecio(rs.getInt(3));
				 producto.setStock(rs.getInt(4));
				productos.add(producto);
			}
				
		 }catch (Exception e) {
			// TODO: handle exception
		}finally {
			finalizarConexion(st, rs);
		}
		 
		return productos;
	
	}
	
	

	private void finalizarConexion(Statement st, ResultSet rs) {
		try {
			st.close();
			rs.close();
			System.out.println("Se cierra la conexion");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void finalizarConexion(Statement st) {
		try {
			st.close();
			System.out.println("Se cierra la conexion");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void agregarProductoS(String nombre, int precio, int stock) throws Exception {
		
		 Statement st =null;
		 ResultSet rs = null;
		 try{
			st = conexion.dameConnection().createStatement();
			int registros = st.executeUpdate ("INSERT INTO producto (nombre, precio,stock) values "
					+ "('"+nombre+"', "+precio+", "+stock+")");
			if (registros == 0) {
				throw new Exception("algo paso que no se agrego");
			}
		 }catch (Exception e) {
			 throw new Exception(e.getMessage());
		 }finally {
			finalizarConexion(st, rs);
		}

	}



	@Override
	public void eliminar(int id) throws Exception {
		 Statement st =null;
		 try{
			st = conexion.dameConnection().createStatement();
			int registros = st.executeUpdate ("DELETE FROM producto WHERE id = " + id);
			if (registros == 0) {
				throw new Exception("algo paso que no se elimino");
			}
		 }catch (Exception e) {
			 throw new Exception(e.getMessage());
		 }finally {
			finalizarConexion(st);
		}
		
	}



	@Override
	public void editar(int id, int stock, int precio) throws Exception {
		 Statement st =null;
		 try{
			st = conexion.dameConnection().createStatement();
			  st.executeUpdate("UPDATE producto SET precio = "+precio+" , stock = "+stock+ " WHERE id="+ id);
		 }catch (Exception e) {
			 throw new Exception(e.getMessage());
		 }finally {
			finalizarConexion(st);
		}
		
	}



	@Override
	public Producto buscarProducto(int id) throws Exception {
		 Statement st =null;
		 ResultSet rs = null;
		 Producto producto = null;
		 try{
			st = conexion.dameConnection().createStatement();
			rs = st.executeQuery ("select * from producto where id =" +id);
			if (rs.next()) {
				producto = new Producto();
				producto.setId(rs.getInt(1));
				producto.setNombre(rs.getString(2));
				producto.setPrecio(rs.getInt(3));
				producto.setStock(rs.getInt(4));
				
			}	
		 }catch (Exception e) {
			// TODO: handle exception
		}finally {
			finalizarConexion(st, rs);
		}
		 
		return producto;
	}





}
