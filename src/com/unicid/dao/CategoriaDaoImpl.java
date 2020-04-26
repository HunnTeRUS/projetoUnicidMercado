package com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.unicid.model.Categoria;
import com.unicid.model.Estoque;
import com.unicid.util.ConnectionFactory;

public class CategoriaDaoImpl {
	private Connection conn;
	private PreparedStatement stmt;

	public CategoriaDaoImpl() {

		try {
			this.conn = ConnectionFactory.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void persist(Categoria categoria) throws Exception {

		try {
			String sql = "INSERT INTO categorias (nome) VALUES (?)";

			stmt = this.conn.prepareStatement(sql);

			stmt.setString(1, categoria.getNome());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}

	public List<Categoria> list() throws Exception {
		List<Categoria> listaCategorias = new ArrayList<>();

		try {
			String sqlCategoria = "SELECT * FROM categorias";

			stmt = this.conn.prepareStatement(sqlCategoria);
			ResultSet dados = stmt.executeQuery();

			while (dados.next()) {
				Categoria categoria = new Categoria();

				categoria.setId(dados.getInt("id"));
				categoria.setNome(dados.getString("nome"));
				listaCategorias.add(categoria);
			}

			//-------------------------------------------
			
			for (int i = 0; i < listaCategorias.size(); i++) {
				String sqlCategoriaxProdutos = "SELECT * FROM estoque WHERE categoria_id = ?";

				stmt = this.conn.prepareStatement(sqlCategoriaxProdutos);
				stmt.setInt(1, (int) listaCategorias.get(i).getId());
				ResultSet dadosCategoriasxPermissao = stmt.executeQuery();

				while (dadosCategoriasxPermissao.next()) {
					Estoque produto = new Estoque();
					produto.setId(Integer.parseInt(dadosCategoriasxPermissao.getString("id")));
					produto.setNome(dadosCategoriasxPermissao.getString("nome"));
					produto.setMarca(dadosCategoriasxPermissao.getString("marca"));
					produto.setDescricao(dadosCategoriasxPermissao.getString("descricao"));
					produto.setPreco(dadosCategoriasxPermissao.getDouble("preco"));
					produto.setQuantidade(dadosCategoriasxPermissao.getInt("quantidade"));
					produto.setId_fornecedor(dadosCategoriasxPermissao.getInt("fornecedor_id"));
					produto.setIdCategoria(dadosCategoriasxPermissao.getInt("categoria_id"));

					listaCategorias.get(i).getIdsProdutos().add(produto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}

		return listaCategorias;
	}

	public void delete(int id) throws Exception {

		try {
			String sqlCategoriaxProdutos = "SELECT categoria_id FROM estoque WHERE categoria_id = " + id;

			stmt = this.conn.prepareStatement(sqlCategoriaxProdutos);

			ResultSet dadosCategoriasxPermissao = stmt.executeQuery();

				String sqlExcluir = "DELETE FROM categorias WHERE id = " + id;

				stmt = this.conn.prepareStatement(sqlExcluir);

				stmt.executeUpdate();

		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new MySQLIntegrityConstraintViolationException("Essa categoria não pode ser excluída, pois há produtos associados a ela");

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}

	public void put(int id, Categoria categoria) throws Exception {

		try {
			String sqlCategoriaxProdutos = "UPDATE categorias SET nome = ? WHERE id = ?";

			stmt = this.conn.prepareStatement(sqlCategoriaxProdutos);
			
			stmt.setString(1, categoria.getNome());
			stmt.setInt(2, id);


			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}

	public Categoria findById(int id) throws Exception {
		try {
			String sqlCategoria = "SELECT * FROM categorias where id = " + id;
			Categoria categoria = new Categoria();

			stmt = this.conn.prepareStatement(sqlCategoria);
			ResultSet dados = stmt.executeQuery();

			while (dados.next()) {
				categoria.setId(dados.getInt("id"));
				categoria.setNome(dados.getString("nome"));
			}
			
			String sqlCategoriaxProdutos = "SELECT * FROM estoque WHERE categoria_id = ?";

			stmt = this.conn.prepareStatement(sqlCategoriaxProdutos);

				stmt.setInt(1, (int) categoria.getId());
				ResultSet dadosCategoriasxPermissao = stmt.executeQuery();

				while (dadosCategoriasxPermissao.next()) {
					Estoque produto = new Estoque();
					produto.setId(Integer.parseInt(dadosCategoriasxPermissao.getString("id")));
					produto.setNome(dadosCategoriasxPermissao.getString("nome"));
					produto.setMarca(dadosCategoriasxPermissao.getString("marca"));
					produto.setDescricao(dadosCategoriasxPermissao.getString("descricao"));
					produto.setPreco(dadosCategoriasxPermissao.getDouble("preco"));
					produto.setQuantidade(dadosCategoriasxPermissao.getInt("quantidade"));
					produto.setId_fornecedor(dadosCategoriasxPermissao.getInt("fornecedor_id"));
					produto.setIdCategoria(dadosCategoriasxPermissao.getInt("categoria_id"));

					categoria.getIdsProdutos().add(produto);
				}
					
			return categoria;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

}
