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
			<a href="#" class="icon icon-pencil"><span>Atualizar Produto</span></a>
		</h1>
	</div>
	<div id="page" class="container">

		<form action="${pageContext.request.contextPath}/put-estoque">
			<c:forEach items="${jspEstoque}" var="estoque">
				<input type="hidden" name="id" id="id" required
					value="${estoque.id}" />
					
				<label for="nome">Nome</label>
				<input type="text" name="nome" id="nome"
					value="${estoque.nome}" required></input>
				
				<label for="marca">Marca</label>
				<input type="text" name="marca" id="marca"
					value="${estoque.marca}" required></input>
					
				<label for="descricao">Descricao</label>
				<input type="text" name="descricao" id="descricao"
					value="${estoque.descricao}" required></input>
					
				<label for="preco">Preço</label>
				<input type="number" name="preco" id="preco"
					value="${estoque.preco}" required></input>
					
				<label for="quantidade">Quantidade</label>
				<input type="number" name="quantidade" id="quantidade"
					value="${estoque.quantidade}" required></input>
					
				<label>Categoria</label>
				
				<select name="idCategoria">
					<c:forEach items="${categorias}" var="categoriasList">
	   					 <option value="${categoriasList.id}">
	   					 	<c:out value="${categoriasList.nome}"/>
	   					 </option>
    				 </c:forEach>
				</select>

			<br/>
			
			<label>Fornecedor(a)</label>
				<select name="idFornecedor">
					<c:forEach items="${fornecedores}" var="fornecedorList">
	   				 	<option value="${fornecedorList.id}">
	   				 		 <c:out value="${fornecedorList.nome}"/>
	   				 	</option>
    				 </c:forEach>
				</select>

			<br/>
			</c:forEach>
				<br/>
        		<input type="submit" value="Alterar" />
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
