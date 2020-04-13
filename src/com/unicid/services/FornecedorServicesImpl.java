package com.unicid.services;

import java.util.List;

import com.unicid.dao.FornecedorDaoImpl;
import com.unicid.model.Fornecedor;

public class FornecedorServicesImpl {

	FornecedorDaoImpl dao = new FornecedorDaoImpl();
	
	public void persist(Fornecedor fornecedor) throws Exception {
		dao.persist(fornecedor);
	}

	public List<Fornecedor> list() throws Exception {
		return dao.list();
	}
	
	public void delete(int id) throws Exception {
		dao.delete(id);
	}
	
	public void put(int id, Fornecedor fornecedor) throws Exception {
		dao.put(id, fornecedor);
	}
	
	public Fornecedor findById(int id) throws Exception {
		return dao.findById(id);
	}
	
}
