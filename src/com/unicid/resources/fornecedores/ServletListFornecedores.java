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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/list-fornecedores")
public class ServletListFornecedores extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletListFornecedores() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FornecedorDaoImpl dao = new FornecedorDaoImpl();
        List<Fornecedor> bdListaFornecedores;
        ArrayList listaDeFornecedores = new ArrayList<>();
        Fornecedor fornecedor = new Fornecedor();

        try {
            if(!request.getParameter("id").isEmpty() && request.getParameter("id") != null){
                fornecedor = dao.findById(Integer.parseInt(request.getParameter("id")));

                request.setAttribute("jspFornecedor", fornecedor);
                RequestDispatcher rd = request.getRequestDispatcher("listar-fornecedores.jsp");
                rd.forward(request, response);
                return;
            }
            else {
                bdListaFornecedores = dao.listar();

                for (int i = 0; i < bdListaFornecedores.size(); i++) {
                    Fornecedor fornecedorTemp = new Fornecedor();
                    fornecedorTemp = bdListaFornecedores.get(i);

                    Map fornecedorMap = new HashMap();

                    fornecedorMap.put("id", fornecedorTemp.getId());
                    fornecedorMap.put("nome", fornecedorTemp.getNome());
                    fornecedorMap.put("tipoFornecimento", fornecedorTemp.getTipoFornecimento());
                    fornecedorMap.put("localizacao", fornecedorTemp.getLocalizacao());

                    listaDeFornecedores.add(fornecedorMap);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("jspFornecedores", listaDeFornecedores);
        RequestDispatcher rd = request.getRequestDispatcher("listar-fornecedores.jsp");
        rd.forward(request, response);
    }
}
