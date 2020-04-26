<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.unicid.enums.TipoProduto" %>
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
		<title>Listar Produto</title>
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
			<%!
				private boolean difTipos(int id) {
					if(id != TipoProduto.ALIMENTICIO.getCod() &&
							id != TipoProduto.COSMETICOS.getCod() &&
								id != TipoProduto.DIVERSOS.getCod() && 
									id != TipoProduto.LIMPEZA.getCod() && 
										id != TipoProduto.DIVERSOS.getCod())
						return false;
					return true;
				}
			%>
			<div class="sis-center-content">
				<div class="sis-content-block">
					<h3 class="sis-title">
						<span class="sis-forward-arrow-svg"></span>
						Listagem de Produto
					</h3>
					<div class="sis-card-container">
						<c:forEach items="${jspEstoque}" var="estoque">
							<div class="sis-card">
								<div class="sis-card-img"><span class="sis-no-img"></span></div>
								<div class="sis-card-id"><c:out value="${estoque.id}" /></div>
								<div class="sis-card-name"><c:out value="${estoque.nome}" /></div>
								<div class="sis-card-brand"><c:out value="${estoque.marca}" /></div>
								<div class="sis-card-price"><c:out value="${estoque.preco}" /></div>
								<div class="sis-card-quantity"><c:out value="${estoque.quantidade}" /></div>
								<div class="sis-card-description"><c:out value="${estoque.descricao}" /></div>
								<div class="sis-card-provider"><c:out value="${estoque.idFornecedor}" /></div>
								<div class="sis-card-category"><c:out value="${estoque.idCategoria}" /></div>
								<a class="sis-card-button" href="${pageContext.request.contextPath}/list-estoque-byid?id=${estoque.id}">Alterar</a>
								<a class="sis-card-button" href="${pageContext.request.contextPath}/delete-estoque?id=${estoque.id}">Excluir</a>
							</div>
						</c:forEach>
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