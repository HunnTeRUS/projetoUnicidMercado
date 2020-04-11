package com.unicid.dao;

import java.util.List;

import com.unicid.model.Categoria;

public interface CategoriaDao {
	public void salvar(Categoria categoria) throws Exception;

	public List<Categoria> listar() throws Exception;

	public void delete(int id) throws Exception;

	public void update(Categoria categoria) throws Exception;

	public Categoria findById(int id) throws Exception;
}
