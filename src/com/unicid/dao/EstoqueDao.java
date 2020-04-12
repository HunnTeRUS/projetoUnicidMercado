package com.unicid.dao;

import java.util.List;

import com.unicid.model.Estoque;

public interface EstoqueDao {

	public void salvar(Estoque estoque) throws Exception;

	public List<Estoque> listar() throws Exception;

	public void delete(int id) throws Exception;

	public void update(int id, Estoque estoque) throws Exception;

	public Estoque findById(int id) throws Exception;
}
