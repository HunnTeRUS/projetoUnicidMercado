package com.unicid.resources.fornecedores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicid.model.Fornecedor;
import com.unicid.services.FornecedorServicesImpl;

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

            FornecedorServicesImpl services = new FornecedorServicesImpl ();

            Fornecedor fornecedorExcluido = services.findById(id);

            services.delete(id);

            request.setAttribute("mensagem", "Fornecedor excluído: " + fornecedorExcluido.getNome());

            RequestDispatcher rd = request.getRequestDispatcher("delete-fornecedor.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
