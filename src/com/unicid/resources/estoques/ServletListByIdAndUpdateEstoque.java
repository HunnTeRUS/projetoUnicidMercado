package com.unicid.resources.estoques;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicid.model.Categoria;
import com.unicid.model.Estoque;
import com.unicid.model.Fornecedor;
import com.unicid.services.CategoriaServicesImpl;
import com.unicid.services.FornecedorServicesImpl;
import com.unicid.services.ProdutoServicesImpl;

@WebServlet("/list-estoque-byid")
public class ServletListByIdAndUpdateEstoque extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletListByIdAndUpdateEstoque() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ProdutoServicesImpl services = new ProdutoServicesImpl();
    	CategoriaServicesImpl categoria = new CategoriaServicesImpl();
		FornecedorServicesImpl fornecedor = new FornecedorServicesImpl();
		ArrayList listaDeProdutos = new ArrayList<>();

        Estoque estoque = new Estoque();

        try {
        	if(request.getParameter("id") != null){
                estoque = services.findById(Integer.parseInt(request.getParameter("id")));

                Map estoqueMap = new HashMap();

                estoqueMap.put("id", estoque.getId());
                estoqueMap.put("nome", estoque.getNome());
                estoqueMap.put("descricao", estoque.getDescricao());
                estoqueMap.put("marca", estoque.getMarca());
                estoqueMap.put("preco", estoque.getPreco());
                estoqueMap.put("quantidade", estoque.getQuantidade());
                listaDeProdutos.add(estoqueMap);
                
                request.setAttribute("jspEstoque", listaDeProdutos);
                request.setAttribute("categorias", categoria.list());
                request.setAttribute("fornecedores", fornecedor.list());

                RequestDispatcher rd = request.getRequestDispatcher("/pages/estoques/put-estoque.jsp");
                rd.forward(request, response);
                return;
            }
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
