package com.unicid.resources.fornecedores;

import com.unicid.dao.CategoriaDaoImpl;
import com.unicid.dao.FornecedorDaoImpl;
import com.unicid.model.Categoria;
import com.unicid.model.Fornecedor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-fornecedor")
public class ServletDeleteFornecedores extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletDeleteFornecedores() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NumberFormatException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            FornecedorDaoImpl dao = new FornecedorDaoImpl();

            Fornecedor fornecedorExcluido = dao.findById(id);

            dao.delete(id);

            request.setAttribute("mensagem", "Fornecedor excluído: " + fornecedorExcluido.getNome());

            RequestDispatcher rd = request.getRequestDispatcher("excluir-fornecedor.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
