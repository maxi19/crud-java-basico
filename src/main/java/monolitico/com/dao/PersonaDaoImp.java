package monolitico.com.dao;

import monolitico.com.domain.Persona;

public class PersonaDaoImp implements PersonaDao{

	@Override
	public void guardar(Persona persona) {
		System.out.println("seguardo la persona" + persona.toString());
		
	}

}
