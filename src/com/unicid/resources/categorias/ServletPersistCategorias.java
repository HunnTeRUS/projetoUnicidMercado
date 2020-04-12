package com.unicid.resources.categorias;

import com.unicid.dao.CategoriaDaoImpl;
import com.unicid.model.Categoria;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/persist-categorias")
public class ServletPersistCategorias extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletPersistCategorias() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Categoria categoria = new Categoria();
            CategoriaDaoImpl dao = new CategoriaDaoImpl();

            categoria.setNome(request.getParameter("nome"));

            dao.salvar(categoria);

            request.setAttribute("mensagem", "Categoria " + request.getParameter("nome") + " cadastrado com sucesso!");
            RequestDispatcher rd = request.getRequestDispatcher("incluir-categoria.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}