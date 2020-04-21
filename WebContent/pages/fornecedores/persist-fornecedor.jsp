<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/default.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/fonts.css"
	rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
</head>

<body>
	<div id="header">
		<div id="menu" class="container">
			<ul>
				<li class="current_page_item"><a href="#" accesskey="1"
					title="">Homepage</a></li>
				<li><a href="#" accesskey="2" title="">Categorias</a></li>
				<li><a href="#" accesskey="3" title="">Fornecedores</a></li>
				<li><a href="#" accesskey="4" title="">Produtos</a></li>
			</ul>
		</div>
	</div>
	<div id="logo" class="container">
		<h1>
			<a href="#" class="icon icon-plus-sign"><span>Inserir
					Nova Categoria</span></a>
		</h1>
	</div>
	<div id="page" class="container">
				<form action="${pageContext.request.contextPath}/persist-fornecedores">
				<label for="nome">Nome</label>
				<input class="inputCategorias" placeholder="Nome do(a) Fornecedor(a)" type="text" name="nome" id="nome" required />
				
				<label for="nome">Localização da Empresa</label>
				<input class="inputCategorias" placeholder="Localização" type="text" name="localizacao" id="localizacao" required />
				
				<label for="nome">Tipo de Fornecimento</label>
				<!-- <input class="inputCategorias" placeholder="Tipo Fornecimento" type="text" name="tipoFornecimento" id="tipoFornecimento" required /> -->
				<select name="tipoFornecimento">
		   			 <option value="1">Alimenticio</option>
		    		 <option value="2">Limpeza</option>
		    		 <option value="3">Cosmeticos</option>
		    		 <option value="4">Pet</option>
		    		 <option value="5">Diversos</option>
				</select>
				<br/>
				<input type="submit" value="Cadastrar" />
				<div>
					<resp:out value="${mensagem}" />
				</div>
		    </form>
	</div>


	<div id="copyright" class="container">
		<p>
			Copyright (c) 2020 Tuncat. All rights reserved. Github Project: <a
				href="https://github.com/HunnTeRUS/projetoUnicidMercado">ProjetoUnicidMercado</a>.
		</p>
	</div>
</body>

</html>
