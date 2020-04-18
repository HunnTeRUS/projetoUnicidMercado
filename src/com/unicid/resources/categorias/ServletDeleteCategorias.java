package com.unicid.resources.categorias;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicid.model.Categoria;
import com.unicid.services.CategoriaServicesImpl;

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

            CategoriaServicesImpl  services = new CategoriaServicesImpl ();

            services.delete(id);

            request.setAttribute("mensagem", "Categoria excluída com sucesso!");

            RequestDispatcher rd = request.getRequestDispatcher("/pages/categorias/delete-categoria.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
