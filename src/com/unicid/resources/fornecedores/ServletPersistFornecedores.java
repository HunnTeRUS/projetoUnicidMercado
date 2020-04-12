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

@WebServlet("/persist-fornecedores")
public class ServletPersistFornecedores extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletPersistFornecedores() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Fornecedor fornecedor = new Fornecedor();
            FornecedorDaoImpl dao = new FornecedorDaoImpl();

            fornecedor.setNome(request.getParameter("nome"));
            fornecedor.setTipoFornecimento(Integer.parseInt(request.getParameter("tipoFornecimento")));
            fornecedor.setLocalizacao(request.getParameter("localizacao"));

            dao.salvar(fornecedor);

            request.setAttribute("mensagem", "Fornecedor " + request.getParameter("nome") + " cadastrado com sucesso!");
            RequestDispatcher rd = request.getRequestDispatcher("incluir-fornecedor.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}