<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.List"%>
        <%@page import="monolitico.com.domain.Producto"%>
  <%
     List<Producto> productos = (List<Producto>) request.getAttribute("productos");
  %>
<!DOCTYPE html>
<html>
<head>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
		<!-- JavaScript Bundle with Popper -->
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	 <script src="scripts/jquery/jquery-3.6.4.min.js" ></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>


$(function() {
    $(document).on('click', 'input[type="button"]', function(event) {
       var id = this.id;

		$.ajax({
			url : '/eliminarProducto',
			data : {
				idproducto : id
			},
			success : function() {
				location.reload();
			},
            error : function(){
				console.log("no envio");
            }
		});
    
    });
});



</script>
</head>
	<div class="container">
      
	  <div class="col mt-4">
		<a href="<%= request.getContextPath() %>/nuevoProducto" class="btn btn-primary"> Agregar  </a>
	  </div>
	  
	  <table class="table mt-2">
		<thead class="thead-primary">
		<tr>
		<th scope="col">Id</th>
		<th scope="col">Nombre</th>
		<th scope="col">Precio</th>
		<th scope="col">Stock</th>
		<th scope="col">Operaciones</th>
		</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < productos.size(); i++) { %>
			<tr class ="table-light">
			<th scope="row"><%=productos.get(i).getId() %></th>
			<td><%=productos.get(i).getNombre()%></td>
			<td><%=productos.get(i).getPrecio() %></td>
			<td><%=productos.get(i).getStock() %></td>
			<td>
			
				<a href ="<%=request.getContextPath()%>/editarProductoForm?idProducto=<%=productos.get(i).getId()%>" class="btn btn-primary" >Editar</a>
				<input type="button" class="btn btn-danger" id="<%=productos.get(i).getId()%>"  value ="Eliminar">
			</td>
			</tr>
		<%}%>
		</tbody>
	 </table>
	</div>
<body>







</body>
</html>