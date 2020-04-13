package com.unicid.services;

import java.util.List;

import com.unicid.dao.CategoriaDaoImpl;
import com.unicid.model.Categoria;

public class CategoriaServicesImpl {

	CategoriaDaoImpl dao = new CategoriaDaoImpl();
	
	public void persist(Categoria categoria) throws Exception {
		dao.persist(categoria);
	}

	public List<Categoria> list() throws Exception {
		return dao.list();
	}
	
	public void delete(int id) throws Exception {
		dao.delete(id);
	}
	
	public void put(int id, Categoria categoria) throws Exception {
		dao.put(id, categoria);
	}
	
	public Categoria findById(int id) throws Exception {
		return dao.findById(id);
	}
	
}
