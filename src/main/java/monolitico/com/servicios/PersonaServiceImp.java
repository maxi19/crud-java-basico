package monolitico.com.servicios;

import monolitico.com.dao.PersonaDao;
import monolitico.com.dao.PersonaDaoImp;
import monolitico.com.domain.Persona;

public class PersonaServiceImp implements PersonaService {

	private PersonaDao personaDao = new PersonaDaoImp();
	
	
	@Override
	public void guardar(Persona persona) {

		personaDao.guardar(persona);
	}

}
