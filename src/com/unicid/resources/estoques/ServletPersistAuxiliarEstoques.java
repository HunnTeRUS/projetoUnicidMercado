package com.unicid.resources.estoques;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicid.services.CategoriaServicesImpl;
import com.unicid.services.FornecedorServicesImpl;

@WebServlet("/persist-estoque")
public class ServletPersistAuxiliarEstoques extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletPersistAuxiliarEstoques() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			CategoriaServicesImpl categoria = new CategoriaServicesImpl();
			FornecedorServicesImpl fornecedor = new FornecedorServicesImpl();
			ArrayList listaDeProdutos = new ArrayList<>();

			request.setAttribute("categorias",  categoria.list());
			request.setAttribute("fornecedores", fornecedor.list());

			RequestDispatcher rd = request.getRequestDispatcher("/pages/estoques/persist-estoque.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}