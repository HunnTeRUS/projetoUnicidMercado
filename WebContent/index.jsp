<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-BR">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Tuncat</title>
	<script type="text/javascript" src="./frontLibs/jquery-3.5.0.min.js"></script>
	<script type="text/javascript" src="./frontLibs/popper-2.3.3.js"></script>
	<link type="text/css" rel="stylesheet" href="./frontLibs/bootstrap-4.4.1/css/bootstrap.min.css" />
	<link type="text/css" rel="stylesheet" href="./css/fonts.css" />
	<link type="text/css" rel="stylesheet" href="./css/reset.css" />
	<link type="text/css" rel="stylesheet" href="./css/mainstyle.css" />
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
	<h3 class="sis-market-name">Supermercados Tuncat</h3>
</div>
<div class="sis-container-content col-md-8">
	<h3 class="sis-title col-md-12">Bem vindo ao nosso site</h3>
	<p class="sis-subtitle col-md-12">Uma breve introdução</p>
	<p class="sis-paragraph col-md-6 col-sm-12">
		Nossos serviços visam a organização e gerenciamento de dados.
		Aqui, você encontra todas as ferramentas necessárias para controlar
		todas as informações com mais precisão. Você pode incluir, alterar,
		excluir e listar todas as informações que desejar.
	</p>
	<p class="sis-paragraph col-md-6 col-sm-12">
		Todas as informações inseridas no sistema ficam armazenadas
		em um banco	de dados, sendo assim, que pode ser acessada através de qualquer
		navegador. 
	</p>
</div>

<div class="sis-container-content col-md-12">
	<h3 class="sis-title col-md-12">Nossas Funcionalidades</h3>
	<p class="sis-subtitle col-md-12"> A nosso sistema traz as seguintes ferramentas</p>
	<div class="sis-content-collumn col-md-4 col-sm-12">
		<h3 class="sis-title col-md-12">Categorias</h3>
		<img class="sis-center-img col-md-12" src="./images/check.png" title="insere categorias" />
		<p class="sis-description">
			A nossa ferramenta permite que você gere as suas categorias de produtos.
		</p>
	</div>
	<div class="sis-content-collumn col-md-4 col-sm-12">
		<h3 class="sis-title col-md-12">Estoques</h3>
		<img class="sis-center-img col-md-12" src="./images/check.png" title="insere produtos" />
		<p class="sis-description">
			A nossa ferramenta permite que você cadastre novos produtos no seu negócio.
		</p>
	</div>
	<div class="sis-content-collumn col-md-4 col-sm-12">
		<h3 class="sis-title col-md-12">Fornecedores</h3>
		<img class="sis-center-img col-md-12" src="./images/check.png" title="insere fornecedores" />
		<p class="sis-description">
			A nossa ferramenta permite que você cadastre novos fornecedores de produtos.
		</p>
	</div>
</div>
</body>
</html>