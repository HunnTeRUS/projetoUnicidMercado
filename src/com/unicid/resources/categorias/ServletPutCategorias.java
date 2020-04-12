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

@WebServlet("/put-categorias")
public class ServletPutCategorias extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletPutCategorias() {
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

            dao.update(categoria);

            request.setAttribute("mensagem", "Categoria " + request.getParameter("nome") + " alterada com sucesso!");
            RequestDispatcher rd = request.getRequestDispatcher("alterar-categoria.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
