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

import com.unicid.model.Estoque;
import com.unicid.services.CategoriaServicesImpl;
import com.unicid.services.FornecedorServicesImpl;
import com.unicid.services.ProdutoServicesImpl;

@WebServlet("/list-estoque")
public class ServletListEstoques extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletListEstoques() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	ProdutoServicesImpl services = new ProdutoServicesImpl();
    	CategoriaServicesImpl categoria = new CategoriaServicesImpl();
    	FornecedorServicesImpl Fornecedor = new FornecedorServicesImpl();

        List<Estoque> bdListaEstoque;
        ArrayList listaDeProdutos = new ArrayList<>();
        Estoque estoque = new Estoque();

        try {
            if(request.getParameter("id") != null){
                estoque = services.findById(Integer.parseInt(request.getParameter("id")));

                Map estoqueMap = new HashMap();

                estoqueMap.put("id", estoque.getId());
                estoqueMap.put("nome", estoque.getNome());
                estoqueMap.put("descricao", estoque.getDescricao());
                estoqueMap.put("idCategoria", categoria.findById((int) estoque.getIdCategoria()).getNome());
                estoqueMap.put("marca", estoque.getMarca());
                estoqueMap.put("preco", estoque.getPreco());
                estoqueMap.put("quantidade", estoque.getQuantidade());
                estoqueMap.put("idFornecedor", Fornecedor.findById(estoque.getId_fornecedor()).getNome());
                listaDeProdutos.add(estoqueMap);
                
                request.setAttribute("jspEstoque", listaDeProdutos);
                RequestDispatcher rd = request.getRequestDispatcher("/pages/estoques/list-estoque.jsp");
                rd.forward(request, response);
                return;
            }
            else {
                bdListaEstoque = services.list();

                for (int i = 0; i < bdListaEstoque.size(); i++) {
                    Estoque estoqueTemp = new Estoque();
                    estoqueTemp = bdListaEstoque.get(i);

                    Map estoqueMap = new HashMap();

                    estoqueMap.put("id", estoqueTemp.getId());
                    estoqueMap.put("nome", estoqueTemp.getNome());
                    estoqueMap.put("descricao", estoqueTemp.getDescricao());
                    estoqueMap.put("idCategoria", categoria.findById((int) estoqueTemp.getIdCategoria()).getNome());
                    estoqueMap.put("marca", estoqueTemp.getMarca());
                    estoqueMap.put("preco", estoqueTemp.getPreco());
                    estoqueMap.put("quantidade", estoqueTemp.getQuantidade());
                    estoqueMap.put("idFornecedor", Fornecedor.findById(estoqueTemp.getId_fornecedor()).getNome());
                    
                    listaDeProdutos.add(estoqueMap);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("jspEstoque", listaDeProdutos);
        RequestDispatcher rd = request.getRequestDispatcher("/pages/estoques/list-estoque.jsp");
        rd.forward(request, response);
    }
}
