package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.jdb.AdministradorDeConexiones;
import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class MainJDBC2 {

	public static void main(String[] args) throws GenericException, SQLException {
		// TODO Auto-generated method stub
	CategoriaService categoriaService = new CategoriaServiceImpl();
	
	List<Categorias> lista = categoriaService.findAll();
	
	System.out.println(lista);
	
	SociosServiceImpl sociosServiceImpl = new SociosServiceImpl();
	
	List<Socios> listaSocios = sociosServiceImpl.findAll();
	
	System.out.println(listaSocios);
	
	}
}
