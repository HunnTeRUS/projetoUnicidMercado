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
		<form action="${pageContext.request.contextPath}/persist-categorias">
			<div class="center">
				<input placeholder="Nome da Categoria" style="width: 50%;"
					type="text" name="nome" id="nome" required />
			</div>
			<br />
			<div class="center">
				<resp:out value="${mensagem == '' ? '' : mensagem }" />
			</div>
			<br />

			<div class="center">
				<input class="button" type="submit" value="Cadastrar" />
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
