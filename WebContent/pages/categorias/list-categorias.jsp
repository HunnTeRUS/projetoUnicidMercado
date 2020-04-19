<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Listar</title>
	<script type="text/javascript" src="../../frontLibs/jquery-3.5.0.min.js"></script>
	<script type="text/javascript" src="../../frontLibs/popper-2.3.3.js"></script>
	<link type="text/css" rel="stylesheet" href="../../frontLibs/bootstrap-4.4.1/css/bootstrap.min.css" />
	<link type="text/css" rel="stylesheet" href="../../css/fonts.css" />
	<link type="text/css" rel="stylesheet" href="../../css/reset.css" />
	<link type="text/css" rel="stylesheet" href="../../css/mainstyle.css" />
</head>
<body>
<div class="sis-header col-md-12">
	<div class="sis-menu-bar col-md-12" >
		<div class="sis-menu-container col-md-3 col-sm-12">
			<label class="sis-menu-label">Home</label>
		</div>
		<div class="sis-menu-container col-md-3 col-sm-12">
			<label class="sis-menu-label">Categorias</label>
			<ul class="sis-menu-list" style="display: none;">
				<li><a href="#" class="sis-list-item">listar</a></li>
				<li><a href="#" class="sis-list-item">atualizar</a></li>
				<li><a href="#" class="sis-list-item">excluir</a></li>
				<li><a href="#" class="sis-list-item">inserir</a></li>
			</ul>
		</div>
		<div class="sis-menu-container col-md-3 col-sm-12">
			<label class="sis-menu-label">Estoques</label>
			<ul class="sis-menu-list" style="display: none;">
				<li><a href="#" class="sis-list-item">listar</a></li>
				<li><a href="#" class="sis-list-item">atualizar</a></li>
				<li><a href="#" class="sis-list-item">excluir</a></li>
				<li><a href="#" class="sis-list-item">inserir</a></li>
			</ul>
		</div>
		<div class="sis-menu-container col-md-3 col-sm-12">
			<label class="sis-menu-label">Fornecedores</label>
			<ul class="sis-menu-list" style="display: none;">
				<li><a href="#" class="sis-list-item">listar</a></li>
				<li><a href="#" class="sis-list-item">atualizar</a></li>
				<li><a href="#" class="sis-list-item">excluir</a></li>
				<li><a href="#" class="sis-list-item">inserir</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="sis-container-content col-md-12">
	<h3 class="sis-title col-md-12">Listagem de Produtos</h3>
</div>
<div class="sis-container-content col-md-12">
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Produtos</th>
		</tr>
		<c:forEach items="${jspCategorias}" var="categorias">
			<tr>
				<td><c:out value="${categorias.id}" /></td>
				<td><c:out value="${categorias.nome}" /></td>
				<c:forEach items="${categorias.listProdutos}" var="produtos">
					<td><c:out value="${produtos.nome}" /></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>