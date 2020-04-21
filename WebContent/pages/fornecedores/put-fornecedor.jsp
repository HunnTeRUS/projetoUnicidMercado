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
			<a href="#" class="icon icon-pencil"><span>Atualizar Fornecedor</span></a>
		</h1>
	</div>
	<div id="page" class="container">

		<div class="sis-container-content col-md-12">
			<form action="${pageContext.request.contextPath}/put-fornecedores">
				<c:forEach items="${jspFornecedor}" var="fornecedores">
					<input type="hidden" name="id" id="id" required
						value="${fornecedores.id}" />

					<label>Nome</label>
					<input type="text" name="nome" id="nome"
						value="${fornecedores.nome}" required></input>

					<label>Localização</label>
					<input type="text" name="localizacao" id="localizacao"
						value="${fornecedores.nome}" required></input>

					<label>Tipo Fornecimento</label>
					<select name="tipoFornecimento">
						<option value="1">Alimenticio</option>
						<option value="2">Limpeza</option>
						<option value="3">Cosmeticos</option>
						<option value="4">Pet</option>
						<option value="5">Diversos</option>
					</select>
					<br/>
					
					<input class="button" type="submit" value="Alterar" />
				</c:forEach>
			</form>
		</div>

			<a class="button" href="${pageContext.request.contextPath}/list-fornecedores">Voltar</a>
	</div>


	<div id="copyright" class="container">
		<p>
			Copyright (c) 2020 Tuncat. All rights reserved. Github Project: <a
				href="https://github.com/HunnTeRUS/projetoUnicidMercado">ProjetoUnicidMercado</a>.
		</p>
	</div>
</body>

</html>
