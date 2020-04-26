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
		<title>Inserir Produto</title>
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
				<div class="sis-content-block">
					<h3 class="sis-title">
						<span class="sis-forward-arrow-svg"></span>
						Inserir um novo Produto
					</h3>
					<div class="sis-form">
						<form action="${pageContext.request.contextPath}/persist-estoque-insert">
							<label for="nome">Nome do Produto</label>
							<input type="text" name="nome" id="nome" required />
							<label for="marca">Marca do produto</label>
							<input type="text" name="marca" id="marca" required />
							<label for="descricao">Descrição do Produto</label>
							<input type="text" name="descricao" id="descricao" required />
							<div class="sis-center-content left">
								<label for="preco">Preço do Produto</label>
								<input type="number" name="preco" id="preco" required />
								<label for="quantidade">Qtd</label>
								<input type="number" name="quantidade" id="quantidade" required />
							</div>
							<div class="sis-center-content left">
								<label for="idCategoria">Categoria</label>
								<select name="idCategoria" id="idCategoria">
									<option value="">Selecione</option>
									<c:forEach items="${categorias}" var="categoriasList">
					   					 <option value="${categoriasList.id}">
					   					 	<c:out value="${categoriasList.nome}"/>
					   					 </option>
				    				 </c:forEach>
								</select>
								<label for="idFornecedor">Fornecedor(a)</label>
								<select name="idFornecedor" id="idFornecedor">
									<option value="">Selecione</option>
									<c:forEach items="${fornecedores}" var="fornecedorList">
					   				 	<option value="${fornecedorList.id}">
					   				 		 <c:out value="${fornecedorList.nome}"/>
					   				 	</option>
				    				 </c:forEach>
								</select>
							</div>
							<div class="sis-center-content left">
								<input type="submit" value="Cadastrar" />
								<input type="reset" value="Limpar" />
							</div>
							<span class="sis-return-msg">
								<resp:out value="${mensagem}" />
							</span>
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