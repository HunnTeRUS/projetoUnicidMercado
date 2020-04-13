package com.unicid.services;

import java.util.List;

import com.unicid.dao.EstoqueDaoImpl;
import com.unicid.model.Estoque;

public class ProdutoServicesImpl{

	EstoqueDaoImpl dao = new EstoqueDaoImpl();
	
	public void persist(Estoque estoque) throws Exception {
		dao.persist(estoque);
	}

	public List<Estoque> list() throws Exception {
		return dao.list();
	}
	
	public void delete(int id) throws Exception {
		dao.delete(id);
	}
	
	public void put(int id, Estoque estoque) throws Exception {
		dao.put(id, estoque);
	}
	
	public Estoque findById(int id) throws Exception {
		return dao.findById(id);
	}
	
}
