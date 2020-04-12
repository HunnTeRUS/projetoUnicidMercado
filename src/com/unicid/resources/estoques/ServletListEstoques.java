package com.unicid.resources.estoques;

import com.unicid.dao.EstoqueDaoImpl;
import com.unicid.model.Estoque;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/list-produtos")
public class ServletListEstoques extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletListEstoques() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EstoqueDaoImpl dao = new EstoqueDaoImpl();
        List<Estoque> bdListaEstoque;
        ArrayList listaDeProdutos = new ArrayList<>();
        Estoque estoque = new Estoque();

        try {
            if(!request.getParameter("id").isEmpty() && request.getParameter("id") != null){
                estoque = dao.findById(Integer.parseInt(request.getParameter("id")));

                request.setAttribute("jspEstoque", estoque);
                RequestDispatcher rd = request.getRequestDispatcher("listar-produtos.jsp");
                rd.forward(request, response);
                return;
            }
            else {
                bdListaEstoque = dao.listar();

                for (int i = 0; i < bdListaEstoque.size(); i++) {
                    Estoque estoqueTemp = new Estoque();
                    estoqueTemp = bdListaEstoque.get(i);

                    Map estoqueMap = new HashMap();

                    estoqueMap.put("id", estoqueTemp.getId());
                    estoqueMap.put("nome", estoqueTemp.getNome());
                    estoqueMap.put("descricao", estoqueTemp.getDescricao());
                    estoqueMap.put("idCategoria", estoqueTemp.getIdCategoria());
                    estoqueMap.put("marca", estoqueTemp.getMarca());
                    estoqueMap.put("preco", estoqueTemp.getPreco());

                    listaDeProdutos.add(estoqueMap);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("jspProdutos", listaDeProdutos);
        RequestDispatcher rd = request.getRequestDispatcher("listar-produtos.jsp");
        rd.forward(request, response);
    }
}
