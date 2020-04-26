<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html, charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/colors.css" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.css" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/keyframes.css" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/mainstyle.css" />
		<title>Inserir Categoria</title>
	</head>
	<body>
		<header>
			<div class="sis-menu-container">
				<div class="sis-dropdown-container">
					<a href="${pageContext.request.contextPath}/">
						<button class="sis-dropdown-button">Home</button>
					</a>
				</div>
				<div class="sis-dropdown-container">
					<button class="sis-dropdown-button">Categorias</button>
					<ul class="sis-dropdown-list">
						<li class="sis-dropdown-item"><a href="${pageContext.request.contextPath}/pages/categorias/persist-categoria.jsp">incluir</a></li>
						<li class="sis-dropdown-item"><a href="${pageContext.request.contextPath}/list-categorias">listar</a></li>
					</ul>
				</div>
				<div class="sis-dropdown-container">
					<button class="sis-dropdown-button">Estoques</button>
					<ul class="sis-dropdown-list">
						<li class="sis-dropdown-item"><a href="${pageContext.request.contextPath}/persist-estoque">incluir</a></li>
						<li class="sis-dropdown-item"><a href="${pageContext.request.contextPath}/list-estoque">listar</a></li>
					</ul>
				</div>
				<div class="sis-dropdown-container">
					<button class="sis-dropdown-button">Fornecedores</button>
					<ul class="sis-dropdown-list">
						<li class="sis-dropdown-item"><a href="${pageContext.request.contextPath}/pages/fornecedores/persist-fornecedor.jsp">incluir</a></li>
						<li class="sis-dropdown-item"><a href="${pageContext.request.contextPath}/list-fornecedores">listar</a></li>
					</ul>
				</div>
			</div>
		</header>
		<main>
			<div class="sis-center-content">
				<div class="sis-block-content">
					<h3 class="sis-title">
						<span class="sis-forward-arrow-svg"></span>
						Inserir uma nova categoria
					</h3>
					<div class="sis-form">
						<form action="${pageContext.request.contextPath}/persist-categorias">
							<label for="nome">Nome da categoria</label>
							<input type="text" name="nome" id="nome" required />
							<span class="sis-return-msg">
								<resp:out value="${mensagem == '' ? '' : mensagem }" />
							</span>
							<input type="reset" value="Limpar">
							<input type="submit" value="Cadastrar" />
						</form>
					</div>
				</div>
			</div>
		</main>
		<footer>
			<div class="sis-footer-content">
				<p class="sis-copyright">
					Copyright (c) 2020 Tuncat. All rights reserved. Github Project: 
					<a href="https://github.com/HunnTeRUS/projetoUnicidMercado">
						ProjetoUnicidMercado
					</a>
				</p>
			</div>
		</footer>
	</body>
</html>