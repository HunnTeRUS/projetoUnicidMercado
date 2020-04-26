<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
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
		<title>Home</title>
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
			<!-- Apresentação -->
			<div class="sis-center-content">
				<img class="sis-logo-img" src="./assets/images/tuncat-logo.png" />
			</div>
			<div class="sis-center-content">
				<div class="sis-content-block">
					<h3 class="sis-title">Bem Vindo ao Supermercados Tuncat</h3>
					<h5 class="sis-subtitle">Um pouco sobre nosso site</h5>
					<p class="sis-text-block">
						Nossos serviços visam a organização e gerenciamento de dados.
						Aqui, você encontra todas as ferramentas necessárias para controlar
						todas as informações com mais precisão. Você pode incluir, alterar, 
						excluir e listar todas as informações que desejar.
					</p>
				</div>
				<div class="sis-content-block">
					<img class="sis-regular-img" src="./assets/images/market.gif" />
				</div>
			</div>
			<!-- Serviços -->
			<div class="sis-center-content">
				<div class="sis-block-content">
					<h3 class="sis-title">Nossos Serviços</h3>
					<h5 class="sis-subtitle">Veja alguns de nossos serviços</h5>
					<div class="sis-center-content">
						<div class="sis-column">
							<span class="sis-providers-svg"></span>
							<h3 class="sis-title">Fornecedores</h3>
							<p class="sis-description">
								Para reposição de novos produtos, fornecedores são sempre necessários.
								 Temos funcionalidades para listagem, inserção, exclusão e alterações
								 dos mesmos.
							</p>
						</div>
						<div class="sis-column">
							<span class="sis-category-svg"></span>
							<h3 class="sis-title">Categorias</h3>
							<p class="sis-description">
								Para organização de nossos produtos, temos nossas categorias e 
								também suas funcões, assim como os fornecedores.
							</p>
						</div>
						<div class="sis-column">
							<span class="sis-products-svg"></span>
							<h3 class="sis-title">Produtos</h3>
							<p class="sis-description">
								E a parte principal de nossos serviços, os produtos! Onde você 
								encontra suas respectivas categorias, fornecedores e suas funcionalidades.
							</p>
						</div>
						<div class="sis-column">
							<span class="sis-docs-svg"></span>
							<h3 class="sis-title">Documentações</h3>
							<p class="sis-description">
								Nosso sistema é documentado, listando todas os serviços e como utilizar!
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- Funcionalidades -->
			<div class="sis-center-content">
				<div class="sis-block-content">
					<h3 class="sis-title">Acesse nossas funcionalidades</h3>
					<p class="sis-subtitle">
						Usufrua de nossas funcionalidades listadas acima 
					</p>
					<div class="sis-center-content">
						<div class="sis-column">
							<img class="sis-moderate-img" src="./assets/images/providers.png" />
							<p class="sis-description">
								Acesse a listagem dos fornecedores atuais, exclusão, alteração
								e inserção. Cada um com seu tipo de fornecimento!
							</p>
							<a class="sis-acess-button" href="">Veja Mais</a>
						</div>
						<div class="sis-column">
							<img class="sis-moderate-img" src="./assets/images/category.png" />
							<p class="sis-description">
								Listagem de categorias e dentro delas, seus produtos. Liste
								insira, exclua ou altere categorias como quiser.
							</p>
							<a class="sis-acess-button" href="">Veja Mais</a>
						</div>
						<div class="sis-column">
							<img class="sis-moderate-img" src="./assets/images/products.png" />
							<p class="sis-description">
								Todos os seus produtos, cada um com a sua respectiva categoria e
								fornecedor. Teste também suas funcionalidades!
							</p>
							<a class="sis-acess-button" href="">Veja Mais</a>
						</div>
						<div class="sis-column">
							<img class="sis-moderate-img" src="./assets/images/docs.png" />
							<p class="sis-description">
								Acesse a nossa documentação, se preferir. Nela estão listadas
								todas as funcionalidades e recursos.
							</p>
							<a class="sis-acess-button" href="">Veja Mais</a>
						</div>
					</div>
				</div>
			</div>
			<!-- Portifólios -->
			<div class="sis-center-content">
				<div class="sis-block-content">
					<h3 class="sis-title">Sobre Nós</h3>
					<p class="sis-subtitle">
						Esse projeto foi feito para conclusão de nota semestral na 
						<a href="https://www.unicid.edu.br/">UNICID</a>
						<img class="sis-moderate-img" src="./assets/images/unicid-logo.png" />
					</p>
					<div class="sis-center-content">
						<div class="sis-column">
							<a href="https://github.com/HunnTeRUS">
								<span class="sis-github-black-svg"></span>
							</a>
							<h3 class="sis-title">Otavio Celestino</h3>
							<p class="sis-description">Github user: HunnTeRUS</p>
							<a class="sis-acess-button" href="https://github.com/HunnTeRUS" target="_blank">Acessar</a>
						</div>
						<div class="sis-column diff">
							<a href="https://github.com/N4MeL3SsCrow">
								<span class="sis-github-white-svg"></span>
							</a>
							<h3 class="sis-title">Yuri Câmara</h3>
							<p class="sis-description">Github user: N4MeL3SsCrow</p>
							<a class="sis-acess-button" href="https://github.com/N4MeL3SsCrow" target="_blank">Acessar</a>
						</div>
						<div class="sis-column">
							<a href="https://github.com/LordRadamanthys">
								<span class="sis-github-black-svg"></span>
							</a>
							<h3 class="sis-title">Mateus Lima</h3>
							<p class="sis-description">Github user: LordRadamanthys</p>
							<a class="sis-acess-button" href="https://github.com/LordRadamanthys" target="_blank">Acessar</a>
						</div>
						<div class="sis-column diff">
							<a href="https://github.com/zombiePumpkin">
								<span class="sis-github-white-svg"></span>
							</a>
							<h3 class="sis-title">José Augusto</h3>
							<p class="sis-description">Github user: zombiePumpkin</p>
							<a class="sis-acess-button" href="https://github.com/zombiePumpkin" target="_blank">Acessar</a>
						</div>
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