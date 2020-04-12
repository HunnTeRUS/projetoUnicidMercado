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

@WebServlet("/delete-categorias")
public class ServletDeleteCategorias extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletDeleteCategorias() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NumberFormatException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            CategoriaDaoImpl dao = new CategoriaDaoImpl();

            Categoria categoriaExcluida = dao.findById(id);

            dao.delete(id);

            request.setAttribute("mensagem", "Categoria excluída: " + categoriaExcluida.getNome());

            RequestDispatcher rd = request.getRequestDispatcher("excluir-categoria.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
