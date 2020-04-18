<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="${pageContext.request.contextPath}/css/fonts.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="${pageContext.request.contextPath}/pages/categorias/categorias.css" rel="stylesheet" type="text/css"
	media="all" />	

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
	<div id="header">
		<div id="menu" class="container">
			<ul>
				<li class="current_page_item"><a href="#" accesskey="1"
					title="">Homepage</a></li>
				<li><a href="#" accesskey="1" title="">Services</a></li>
				<li><a href="#" accesskey="2" title="">Our Clients</a></li>
				<li><a href="#" accesskey="3" title="">About Us</a></li>
				<li><a href="#" accesskey="4" title="">Careers</a></li>
				<li><a href="#" accesskey="5" title="">Contact Us</a></li>
			</ul>
		</div>
	</div>
	
	<div id="logo" class="container">
		<h1>
			<a href="#" class="icon icon-tasks"><span>Alterar Categorias</span></a>
		</h1>

		<div class="register-container">
            <div class="content">
                <form action="${pageContext.request.contextPath}/put-categorias">
               	
                    <input type="number" class="inputNome" name=id id="id" required placeholder="ID categoria"/>
					<input type="text" class="inputNome" name="nome" id="nome" required placeholder="Novo nome da categoria"/>
                    

                    <button class="button" type="submit">Alterar</button>

					<div>
						<resp:out value="${mensagem}" />
					</div>
                </form>
            </div>
        </div>
	</div>
	
	<div id="page" class="container"></div>
	<div id="contact" class="container">
		<div class="major">
			<h2>Get in touch</h2>
			<span class="byline">Phasellus nec erat sit amet nibh
				pellentesque congue</span>
		</div>
		<ul class="contact">
			<li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
			<li><a href="#" class="icon icon-facebook"><span></span></a></li>
			<li><a href="#" class="icon icon-dribbble"><span>Pinterest</span></a></li>
			<li><a href="#" class="icon icon-tumblr"><span>Google+</span></a></li>
			<li><a href="#" class="icon icon-rss"><span>Pinterest</span></a></li>
		</ul>
	</div>
	<div id="copyright" class="container">
		<p>
			Copyright (c) 2013 Sitename.com. All rights reserved. | Photos by <a
				href="http://fotogrph.com/">Fotogrph</a> | Design by <a
				href="http://www.freecsstemplates.org/" rel="nofollow">FreeCSSTemplates.org</a>.
		</p>
	</div>
</body>
</html>