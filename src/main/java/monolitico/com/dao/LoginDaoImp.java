package monolitico.com.dao;

import monolitico.com.excepciones.UsuarioNoExisteException;

public class LoginDaoImp implements LoginDao{

	@Override
	public boolean logear(String usuario, String password) throws Exception {

		if (usuario.equals("admin") && password.equals("admin") ) {
			return true;
		}
		throw new UsuarioNoExisteException("El usuario  y el password no existe");
	}

}
