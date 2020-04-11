package com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unicid.model.Estoque;
import com.unicid.util.ConnectionFactory;

public class EstoqueDaoImpl implements EstoqueDao {

	private Connection conn;
	private PreparedStatement stmt;

	public EstoqueDaoImpl() {

		try {
			conn = ConnectionFactory.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void salvar(Estoque produto) throws Exception {

		try {

			String sql = "INSERT INTO estoque (nome, marca, descricao, preco, categoria_id) VALUES (?, ?, ?, ?, ?)";

			stmt = this.conn.prepareStatement(sql);

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getDescricao());
			stmt.setDouble(4, produto.getPreco());
			stmt.setInt(5, (int) produto.getIdCategoria());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}

	@Override
	public List<Estoque> listar() throws Exception {
		List<Estoque> listaEstoques = new ArrayList<Estoque>();

		try {
			String sqlEstoque = "SELECT * FROM estoque";

			stmt = this.conn.prepareStatement(sqlEstoque);
			ResultSet dados = stmt.executeQuery();

			while (dados.next()) {
				Estoque produto = new Estoque();

				produto.setNome(dados.getString("nome"));
				produto.setMarca(dados.getString("marca"));
				produto.setDescricao(dados.getString("descricao"));
				produto.setPreco(dados.getDouble("preco"));
				produto.setIdCategoria(dados.getInt("categoria_id"));

				listaEstoques.add(produto);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}

		return listaEstoques;
	}

	@Override
	public void delete(int id) throws Exception {

		try {
			String sqlExcluir = "DELETE FROM estoque WHERE id = " + id;

			stmt = this.conn.prepareStatement(sqlExcluir);

			stmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}

	@Override
	public void update(Estoque produto) throws Exception {

		try {
			String sqlEstoquexProdutos = "UPDATE estoque SET nome = ?, marca = ?, descricao = ?, preco = ?, categoria_id = ? WHERE id = ?";

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getDescricao());
			stmt.setDouble(4, produto.getPreco());
			stmt.setInt(5, (int) produto.getIdCategoria());

			stmt = this.conn.prepareStatement(sqlEstoquexProdutos);

			stmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}

	@Override
	public Estoque findById(int id) throws Exception {
		try {
			String sqlEstoque = "SELECT * FROM estoque where id = " + id;
			Estoque produto = new Estoque();

			stmt = this.conn.prepareStatement(sqlEstoque);
			ResultSet dados = stmt.executeQuery();

			while (dados.next()) {
				produto.setNome(dados.getString("nome"));
				produto.setMarca(dados.getString("marca"));
				produto.setDescricao(dados.getString("descricao"));
				produto.setPreco(dados.getDouble("preco"));
				produto.setIdCategoria(dados.getInt("categoria_id"));
			}

			return produto;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}

		return null;
	}
}
