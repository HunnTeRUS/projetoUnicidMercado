package com.unicid.resources.fornecedores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicid.enums.TipoProduto;
import com.unicid.model.Fornecedor;
import com.unicid.services.FornecedorServicesImpl;

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
            FornecedorServicesImpl services = new FornecedorServicesImpl ();

            fornecedor.setNome(request.getParameter("nome"));
            
            if(difTipos(Integer.parseInt(request.getParameter("tipoFornecimento"))))
            	fornecedor.setTipoFornecimento(Integer.parseInt(request.getParameter("tipoFornecimento")));
            else throw new Exception("Tipo de fornecimento invalido");
            
            fornecedor.setLocalizacao(request.getParameter("localizacao"));

            services.persist(fornecedor);

            request.setAttribute("mensagem", "Fornecedor " + request.getParameter("nome") + " cadastrado com sucesso!");
            RequestDispatcher rd = request.getRequestDispatcher("/pages/fornecedores/persist-fornecedor.jsp");
            rd.forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private boolean difTipos(int id) {
    	if(id != TipoProduto.ALIMENTICIO.getCod() &&
    			id != TipoProduto.COSMETICOS.getCod() &&
    				id != TipoProduto.DIVERSOS.getCod() && 
    					id != TipoProduto.LIMPEZA.getCod() &&
    						id != TipoProduto.PET.getCod() &&
    							id != TipoProduto.DIVERSOS.getCod())
    		return false;
    	return true;
    }
}