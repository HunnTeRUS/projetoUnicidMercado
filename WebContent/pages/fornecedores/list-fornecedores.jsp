<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.unicid.enums.TipoProduto"%>
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
		<title>Listar Fornecedor</title>
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
			<%!private String difTipos(int id) {
				if (id == TipoProduto.ALIMENTICIO.getCod())
					return TipoProduto.ALIMENTICIO.getNome();

				else if (id == TipoProduto.COSMETICOS.getCod())
					return TipoProduto.COSMETICOS.getNome();

				else if (id == TipoProduto.DIVERSOS.getCod())
					return TipoProduto.DIVERSOS.getNome();

				else if (id == TipoProduto.LIMPEZA.getCod())
					return TipoProduto.LIMPEZA.getNome();

				else
					return TipoProduto.PET.getNome();

			}%>
			<div class="sis-center-content">
				<div class="sis-content-block">
					<h3 class="sis-title">
						<span class="sis-forward-arrow-svg"></span>
						Listagem de Fornecedores
					</h3>
					<table>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Localizacao</th>
							<th>Tipo de Fornecimento</th>
						</tr>
						<c:forEach items="${jspFornecedores}" var="fornecedor">
							<tr>
								<td class="sis-tabledata-id"><c:out value="${fornecedor.id}" /></td>
								<td class="sis-tabledata-name"><c:out value="${fornecedor.nome}" /></td>
								<td class="sis-tabledata-description"><c:out value="${fornecedor.localizacao}" /></td>
								<c:if test="${fornecedor.tipoFornecimento == 1}">
									<td class="sis-tabledata-name">Alimenticio</td>
								</c:if>
								<c:if test="${fornecedor.tipoFornecimento == 2}">
									<td class="sis-tabledata-name">Limpeza</td>
								</c:if>
								<c:if test="${fornecedor.tipoFornecimento == 3}">
									<td class="sis-tabledata-name">Cosmeticos</td>
								</c:if>
								<c:if test="${fornecedor.tipoFornecimento == 4}">
									<td class="sis-tabledata-name">Pet</td>
								</c:if>
								<c:if test="${fornecedor.tipoFornecimento == 5}">
									<td class="sis-tabledata-name">Diversos</td>
								</c:if>
								<td class="sis-tabledata-button"><a href="${pageContext.request.contextPath}/list-fornecedor-byid?id=${fornecedor.id}">Alterar</a></td>
								<td class="sis-tabledata-button"><a href="${pageContext.request.contextPath}/delete-fornecedor?id=${fornecedor.id}">Excluir</a></td>
							</tr>
						</c:forEach>
					</table>
					<span class="sis-return-msg">
						<resp:out value="${mensagem}" />
					</span>
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