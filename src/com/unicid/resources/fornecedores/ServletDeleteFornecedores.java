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

            services.delete(id);

            request.setAttribute("mensagem", "Fornecedor excluído com sucesso!");

            RequestDispatcher rd = request.getRequestDispatcher("/pages/fornecedores/auxiliar-fornecedor.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
        	request.setAttribute("mensagem", "Esse fornecedor não pode ser excluido, pois há produtos associados a ele!");
            RequestDispatcher rd = request.getRequestDispatcher("/pages/fornecedores/auxiliar-fornecedor.jsp");
            rd.forward(request, response);
            }
    }
}
