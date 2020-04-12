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

@WebServlet("/delete-produto")
public class ServletDeleteEstoques extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletDeleteEstoques() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NumberFormatException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            EstoqueDaoImpl dao = new EstoqueDaoImpl();

            Estoque estoqueExcluida = dao.findById(id);

            dao.delete(id);

            request.setAttribute("mensagem", "Produto excluído: " + estoqueExcluida.getNome());

            RequestDispatcher rd = request.getRequestDispatcher("excluir-produto.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}