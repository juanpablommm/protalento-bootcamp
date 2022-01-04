package ar.com.educacionit.dao;

import ar.com.educacionit.domain.Socios;

public interface ICrud {
	
	public Socios create(Socios SocioACrear);
	
	
	public Socios findById(Long id);
	
	
	public Socios[] findAll();
	
//	depues completo los demas

}
