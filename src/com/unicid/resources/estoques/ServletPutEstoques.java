package com.unicid.resources.estoques;

import com.unicid.dao.CategoriaDaoImpl;
import com.unicid.dao.EstoqueDaoImpl;
import com.unicid.model.Categoria;
import com.unicid.model.Estoque;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/put-estoque")
public class ServletPutEstoques extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletPutEstoques() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Estoque estoque = new Estoque();
            EstoqueDaoImpl dao = new EstoqueDaoImpl();
            
            int id = Integer.parseInt(request.getParameter("id"));

            estoque.setMarca(request.getParameter("marca"));
            estoque.setNome(request.getParameter("nome"));
            estoque.setDescricao(request.getParameter("descricao"));
            estoque.setPreco(Double.valueOf(request.getParameter("preco")));
            estoque.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));

            dao.update(id, estoque);

            request.setAttribute("mensagem", "Produto " + request.getParameter("nome") + " atualizado com sucesso!");
            RequestDispatcher rd = request.getRequestDispatcher("alterar-produto.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
