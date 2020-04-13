package com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unicid.model.Categoria;
import com.unicid.model.Estoque;
import com.unicid.util.ConnectionFactory;

public class CategoriaDaoImpl {
	private Connection conn;
	private PreparedStatement stmt;

	public CategoriaDaoImpl() {

		try {
			conn = ConnectionFactory.getConnection();

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
		List<Categoria> listaCategorias = new ArrayList<Categoria>();

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

			String sqlCategoriaxProdutos = "SELECT * FROM estoque WHERE categoria_id = ?";

			stmt = this.conn.prepareStatement(sqlCategoriaxProdutos);

			for (int i = 0; i < listaCategorias.size(); i++) {
				stmt = this.conn.prepareStatement(sqlCategoriaxProdutos);

				stmt.setInt(1, (int) listaCategorias.get(i).getId());
				ResultSet dadosCategoriasxPermissao = stmt.executeQuery();

				while (dadosCategoriasxPermissao.next()) {
					Estoque estoque = new Estoque();
					estoque.setId(dados.getInt("id"));
					estoque.setDescricao(dados.getString("descricao"));
					estoque.setIdCategoria(dados.getInt("categoria_id"));
					estoque.setMarca(dados.getString("marca"));
					estoque.setNome(dados.getString("nome"));
					estoque.setPreco(dados.getDouble("preco"));

					listaCategorias.get(i).getIdsCategorias().add(estoque);
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

			if(!dadosCategoriasxPermissao.wasNull())
				throw new Exception("Essa categoria não pode ser excluída, pois há produtos associados a ela");
			
			else {
				String sqlExcluir = "DELETE FROM categorias WHERE id = " + id;
				
				stmt = this.conn.prepareStatement(sqlExcluir);
				
				stmt.executeQuery();
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}
	
	public void put(int id, Categoria categoria) throws Exception {

		try {
			String sqlCategoriaxProdutos = "UPDATE categorias SET nome = ? WHERE id = ?";

			stmt.setString(1, categoria.getNome());
			stmt.setInt(2, (int) id);
			
			stmt = this.conn.prepareStatement(sqlCategoriaxProdutos);

			stmt.executeQuery();
			
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
			
			return categoria;
		}catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return null;
	}
	
}
