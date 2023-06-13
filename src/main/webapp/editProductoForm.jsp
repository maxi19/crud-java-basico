<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@page import="monolitico.com.domain.Producto"%>
 <%
Producto producto = (Producto) request.getAttribute("producto");

%>

<!DOCTYPE html>
  <html>
  <head>
	  <title>edicion de producto</title>
        <link rel="stylesheet" href="style/style.css">
 		<script src="scripts/jquery/jquery-3.6.4.min.js" ></script>
		<link rel="stylesheet" href="scripts/bootstrap/css/bootstrap.min.css">
        <script src="scripts/bootstrap/js/bootstrap.min.js" ></script>
     
		
		<script src="scripts/bootstrap/js/bootstrap.bundle.min.js" ></script>
		<script src="scripts/bootstrap/js/bootstrap.bundle.min.js.map" ></script>
		<script src="scripts/bootstrap/js/browser-polyfill.min.js.map" ></script>
		
	</head>

  <body>
  <div class="container" >
	    <header>
			<nav class="navbar navbar-dar bg-darkk">
			 <div class="container">
    			<a class="navbar-brand" href="#">Aplicacion demo</a>
  			 			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
  			     <li class="nav-item active">
       				 <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
    			  </li>
  			</ul>
  			</div>
			</nav>
	    </header>
	    
	     <section class="form-crear-producto">
			<form action="<%=request.getContextPath()%>/editarProducto?" method="Post" class="mt-4 mb-3">
			  <input type="hidden" id="id" name="id" value="<%= producto.getId()%>">
			 
			  <div class="form-group mb-3">
			    <label for="formGroupExampleInput">Nombre</label>
			    <input type="text" class="form-control" id="nombre" disabled name = "nombre" placeholder="Nombre del producto" value="<%= producto.getNombre()%>">
			  </div>
			  
			  
			  <div class="form-group mb-3">
			     <label for="formGroupExampleInput">Precio</label>
			   	 <input type="text" class="form-control" id="precio" name = "precio" placeholder="Precio del producto" value="<%= producto.getPrecio()%>">
			  </div>
			  
			   <div class="form-group mb-3 mt-1">
			     <label for="formGroupExampleInput">Stock</label>
			   	 <input type="text" class="form-control" id="stock" name = "stock" placeholder="Stock del producto" value="<%= producto.getStock()%>"  >
			  </div>
			   
			  <button  style="float: right;" class="btn btn-primary" id="btnAgregar" >editar producto</button>		  
			  
			  
			</form>
	    </section>
	  </div>
	
	  
  </body>
  </html>