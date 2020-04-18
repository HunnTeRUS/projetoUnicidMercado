package com.unicid.resources.categorias;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicid.model.Categoria;
import com.unicid.services.CategoriaServicesImpl;

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

    	CategoriaServicesImpl  services = new CategoriaServicesImpl ();
        ArrayList listaDeCategorias = new ArrayList<>();

        try {
            if(request.getParameter("id") != null){
                Categoria categoria = new Categoria();
                categoria = services.findById(Integer.parseInt(request.getParameter("id")));

                Map categoriaMap = new HashMap();

                categoriaMap.put("id", categoria.getId());
                categoriaMap.put("nome", categoria.getNome());
                categoriaMap.put("listProdutos", categoria.getIdsCategorias());
                
                listaDeCategorias.add(categoriaMap);
                
                request.setAttribute("jspCategorias", listaDeCategorias);
                RequestDispatcher rd = request.getRequestDispatcher("/pages/categorias/list-categorias.jsp");
                rd.forward(request, response);
                return;
            }
            else {
                List<Categoria> bdListaCategoria= new ArrayList<>();
                bdListaCategoria = services.list();

                for (int i = 0; i < bdListaCategoria.size(); i++) {
                    Categoria categoriaTemp = new Categoria();
                    categoriaTemp = bdListaCategoria.get(i);

                    Map categoriaMap = new HashMap();

                    categoriaMap.put("id", categoriaTemp.getId());
                    categoriaMap.put("nome", categoriaTemp.getNome());
                    categoriaMap.put("listProdutos", categoriaTemp.getIdsCategorias());

                    listaDeCategorias.add(categoriaMap);
                }

                request.setAttribute("jspCategorias", listaDeCategorias);
                RequestDispatcher rd = request.getRequestDispatcher("/pages/categorias/list-categorias.jsp");
                rd.forward(request, response);
            }
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
