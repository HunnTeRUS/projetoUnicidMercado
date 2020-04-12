package com.unicid.resources.categorias;

import com.unicid.dao.CategoriaDao;
import com.unicid.dao.CategoriaDaoImpl;
import com.unicid.model.Categoria;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/list-categorias")
public class ServletListCategorias extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletListCategorias() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoriaDaoImpl dao = new CategoriaDaoImpl();
        List<Categoria> bdListaCategoria;
        ArrayList listaDeCategorias = new ArrayList<>();
        Categoria categoria = new Categoria();

        try {
            if(!request.getParameter("id").isEmpty() && request.getParameter("id") != null){
                categoria = dao.findById(Integer.parseInt(request.getParameter("id")));

                request.setAttribute("jspCategorias", categoria);
                RequestDispatcher rd = request.getRequestDispatcher("listar-categorias.jsp");
                rd.forward(request, response);
                return;
            }
            else {
                bdListaCategoria = dao.listar();

                for (int i = 0; i < bdListaCategoria.size(); i++) {
                    Categoria categoriaTemp = new Categoria();
                    categoriaTemp = bdListaCategoria.get(i);

                    Map categoriaMap = new HashMap();

                    categoriaMap.put("id", categoriaTemp.getId());
                    categoriaMap.put("nome", categoriaTemp.getNome());
                    categoriaMap.put("listProdutos", categoriaTemp.getIdsCategorias());

                    listaDeCategorias.add(categoriaMap);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("jspCategorias", listaDeCategorias);
        RequestDispatcher rd = request.getRequestDispatcher("listar-categorias.jsp");
        rd.forward(request, response);
    }
}
