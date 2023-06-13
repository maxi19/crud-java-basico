package monolitico.com.servicios;

import monolitico.com.dao.LoginDao;
import monolitico.com.dao.LoginDaoImp;
import monolitico.com.excepciones.UsuarioNoExisteException;

public class UsuarioServiceImp implements UsuarioService{

	private LoginDao loginDao = new LoginDaoImp();
	
	
	@Override
	public boolean login(String usuario, String password) throws Exception {
		try {
			loginDao.logear(usuario, password);
		} catch (Exception e) {
			throw new UsuarioNoExisteException("no existe el usuario o la pass no es valida");
		}
		return true;
	}

}
