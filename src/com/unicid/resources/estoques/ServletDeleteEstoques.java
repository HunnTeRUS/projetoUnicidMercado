package com.unicid.resources.estoques;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicid.model.Estoque;
import com.unicid.services.ProdutoServicesImpl;

@WebServlet("/delete-estoque")
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

            ProdutoServicesImpl services = new ProdutoServicesImpl();

            Estoque estoqueExcluida = services.findById(id);

            services.delete(id);

            request.setAttribute("mensagem", "Produto excluído: " + estoqueExcluida.getNome());

            RequestDispatcher rd = request.getRequestDispatcher("delete-estoque.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}