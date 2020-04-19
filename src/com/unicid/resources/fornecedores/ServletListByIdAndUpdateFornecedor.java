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

import com.unicid.model.Categoria;
import com.unicid.model.Fornecedor;
import com.unicid.services.FornecedorServicesImpl;

@WebServlet("/list-fornecedor-byid")
public class ServletListByIdAndUpdateFornecedor extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletListByIdAndUpdateFornecedor() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	FornecedorServicesImpl  services = new FornecedorServicesImpl ();
        ArrayList listaDeFornecedores = new ArrayList<>();
        Fornecedor fornecedor = new Fornecedor();

        try {
        	if(request.getParameter("id") != null){
                fornecedor = services.findById(Integer.parseInt(request.getParameter("id")));

                Map fornecedorMap = new HashMap();

                fornecedorMap.put("id", fornecedor.getId());
                fornecedorMap.put("nome", fornecedor.getNome());
                fornecedorMap.put("tipoFornecimento", fornecedor.getTipoFornecimento());
                fornecedorMap.put("localizacao", fornecedor.getLocalizacao());

                listaDeFornecedores.add(fornecedorMap);
                
                request.setAttribute("jspFornecedor", listaDeFornecedores);
                RequestDispatcher rd = request.getRequestDispatcher("/pages/fornecedores/put-fornecedor.jsp");
                rd.forward(request, response);
                return;
            }
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
