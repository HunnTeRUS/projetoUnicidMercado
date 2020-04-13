package com.unicid.resources.fornecedores;

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

import com.unicid.model.Fornecedor;
import com.unicid.services.FornecedorServicesImpl;

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

    	FornecedorServicesImpl  services = new FornecedorServicesImpl ();
        List<Fornecedor> bdListaFornecedores;
        ArrayList listaDeFornecedores = new ArrayList<>();
        Fornecedor fornecedor = new Fornecedor();

        try {
            if(!request.getParameter("id").isEmpty() && request.getParameter("id") != null){
                fornecedor = services.findById(Integer.parseInt(request.getParameter("id")));

                request.setAttribute("jspFornecedor", fornecedor);
                RequestDispatcher rd = request.getRequestDispatcher("list-fornecedores.jsp");
                rd.forward(request, response);
                return;
            }
            else {
                bdListaFornecedores = services.list();

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
        RequestDispatcher rd = request.getRequestDispatcher("list-fornecedores.jsp");
        rd.forward(request, response);
    }
}
