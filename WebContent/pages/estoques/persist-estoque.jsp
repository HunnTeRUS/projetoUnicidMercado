<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Inserir</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontLibs/jquery-3.5.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontLibs/popper-2.3.3.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/frontLibs/bootstrap-4.4.1/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fonts.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/reset.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/mainstyle.css" />
</head>
<body>
	<div class="sis-header col-md-12">
		<div class="sis-menu-bar col-md-12">
			<div class="sis-menu-container col-md-3 col-sm-12">
				<label class="sis-menu-label">Home</label>
			</div>
			<div class="sis-menu-container col-md-3 col-sm-12">
			<label class="sis-menu-label">Categorias</label>
			<ul class="sis-menu-list" style="display: none;">
				<li><a href="${pageContext.request.contextPath}/list-categorias" class="sis-list-item">listar</a></li>
				<li><a href="${pageContext.request.contextPath}/pages/categorias/persist-categoria.jsp" class="sis-list-item">inserir</a></li>
			</ul>
		</div>
		<div class="sis-menu-container col-md-3 col-sm-12">
			<label class="sis-menu-label">Estoques</label>
			<ul class="sis-menu-list" style="display: none;">
				<li><a href="${pageContext.request.contextPath}/list-estoque" class="sis-list-item">listar</a></
				<li><a href="${pageContext.request.contextPath}/persist-estoque" class="sis-list-item">inserir</a></li>
			</ul>
		</div>
		<div class="sis-menu-container col-md-3 col-sm-12">
			<label class="sis-menu-label">Fornecedores</label>
			<ul class="sis-menu-list" style="display: none;">
				<li><a href="${pageContext.request.contextPath}/list-fornecedores" class="sis-list-item">listar</a></li>
				<li><a href="${pageContext.request.contextPath}/pages/fornecedores/persist-fornecedor.jsp" class="sis-list-item">inserir</a></li>
			</ul>
		</div>
		</div>
	</div>
	<div class="sis-container-content col-md-12">
		<h3 class="sis-title col-md-12">Inserir Produto</h3>
	</div>
	<div class="sis-container-content col-md-12">
		<form action="${pageContext.request.contextPath}/persist-estoque-insert">
			<label for="nome">Nome</label>
			<input type="text" name="nome" id="nome" class="inputCategorias"
				   placeholder="Nome do Produto" required/>

			<label for="marca">Marca</label>
			<input type="text" name="marca" id="marca" class="inputCategorias"
				   placeholder="Marca do Produto" required/>

			<label for="descricao">Descricao</label>
			<input type="text" name="descricao" id="descricao" class="inputCategorias"
				   placeholder="Descriçâo do Produto" required/>

			<label for="preco">Preço</label>
			<input type="number" name="preco" id="preco" class="inputCategorias"
				   placeholder="Preço" required/>

			<label for="quantidade">Quantidade</label>
			<input type="number" name="quantidade" id="quantidade" class="inputCategorias"
				   placeholder="Quantidade desse Produto" required/>
			
			<br/>

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

			<input type="submit" value="Cadastrar" />

			<div>
				<resp:out value="${mensagem}" />
			</div>
		</form>
	</div>
</body>
</html>