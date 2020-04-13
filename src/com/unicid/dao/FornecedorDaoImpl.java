package com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unicid.model.Fornecedor;
import com.unicid.util.ConnectionFactory;

public class FornecedorDaoImpl {

	private Connection conn;
	private PreparedStatement stmt;

	public FornecedorDaoImpl() {

		try {
			conn = ConnectionFactory.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void persist(Fornecedor fornecedor) throws Exception {

		try {
			String sql = "INSERT INTO fornecedor (nome, localizacao, tipoFornecimento) VALUES (?, ?, ?)";

			stmt = this.conn.prepareStatement(sql);

			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getLocalizacao());
			stmt.setInt(3, fornecedor.getTipoFornecimento());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}

	
	public List<Fornecedor> list() throws Exception {
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();

		try {
			String sqlFornecedor = "SELECT * FROM fornecedor";

			stmt = this.conn.prepareStatement(sqlFornecedor);
			ResultSet dados = stmt.executeQuery();

			while (dados.next()) {
				Fornecedor fornecedor = new Fornecedor();

				fornecedor.setId(dados.getInt("id"));
				fornecedor.setLocalizacao(dados.getString("localizacao"));
				fornecedor.setNome(dados.getString("nome"));
				fornecedor.setTipoFornecimento(dados.getInt("tipoFornecimento"));

				listaFornecedores.add(fornecedor);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}

		return listaFornecedores;
	}

	
	public void delete(int id) throws Exception {

		try {
			String sqlExcluir = "DELETE FROM fornecedor WHERE id = " + id;

			stmt = this.conn.prepareStatement(sqlExcluir);

			stmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}

	
	public void put(int id, Fornecedor fornecedor) throws Exception {

		try {
			String sqlFornecedorxProdutos = "UPDATE fornecedor SET nome = ?, localizacao = ?, tipoFornecimento = ? WHERE id = ?";

			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getLocalizacao());

			stmt.setInt(3, fornecedor.getTipoFornecimento());
			stmt.setInt(4, id);

			stmt = this.conn.prepareStatement(sqlFornecedorxProdutos);

			stmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
	}

	
	public Fornecedor findById(int id) throws Exception {
		try {
			String sqlFornecedor = "SELECT * FROM fornecedor where id = " + id;
			Fornecedor fornecedor = new Fornecedor();

			stmt = this.conn.prepareStatement(sqlFornecedor);
			ResultSet dados = stmt.executeQuery();

			while (dados.next()) {
				fornecedor.setId(dados.getInt("id"));
				fornecedor.setNome(dados.getString("nome"));
				fornecedor.setLocalizacao(dados.getString("localizacao"));
				fornecedor.setTipoFornecimento(dados.getInt("tipoFornecimento"));
			}

			return fornecedor;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}

		return null;
	}

}
