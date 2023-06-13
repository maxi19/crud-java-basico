personaAguardar
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 

<!DOCTYPE html>
  <html>
  <head>
	  <title>Ingreso de nueva persona</title>
        <link rel="stylesheet" href="style/style.css">
 		<script src="scripts/jquery/jquery-3.6.4.min.js" ></script>
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
			<form action="<%= request.getContextPath() %>/guardarPersona" method="Get" class="mt-4 mb-3">
			  
			  <div class="form-group mb-3">
			    <label for="formGroupExampleInput">Nombre</label>
			    <input type="text" class="form-control" id="nombre" name = "nombre" placeholder="Nombre de la persona">
			  </div>
			  
			  <div class="form-group mb-3">
			     <label for="formGroupExampleInput">Apellido</label>
			   	 <input type="text" class="form-control" id="apellido" name = "apellido" placeholder="Apellido de la persona">
			  </div>
			   
			  <button  style="float: right;" class="btn btn-primary" id="btnAgregar" >Agregar producto</button>		  

			</form>
	    </section>
	  </div>
	
	  
  </body>
  </html>