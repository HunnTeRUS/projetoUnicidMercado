package com.unicid.dao;

import java.util.List;

import com.unicid.model.Fornecedor;

public interface FornecedorDao {
	public void salvar(Fornecedor fornecedor) throws Exception;

	public List<Fornecedor> listar() throws Exception;

	public void delete(int id) throws Exception;

	public void update(Fornecedor fornecedor) throws Exception;

	public Fornecedor findById(int id) throws Exception;
}
