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

@WebServlet("/put-fornecedores")
public class ServletPutFornecedores extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletPutFornecedores() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Fornecedor fornecedor = new Fornecedor();
            FornecedorServicesImpl services = new FornecedorServicesImpl ();

            int id = Integer.parseInt(request.getParameter("id"));
            
            fornecedor.setNome(request.getParameter("nome"));
            fornecedor.setLocalizacao(request.getParameter("localizacao"));
            fornecedor.setTipoFornecimento(Integer.parseInt(request.getParameter("tipoFornecimento")));

            services.put(id, fornecedor);

            request.setAttribute("mensagem", "Fornecedor " + request.getParameter("nome") + " alterado com sucesso!");
            RequestDispatcher rd = request.getRequestDispatcher("/pages/fornecedores/auxiliar-fornecedor.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
