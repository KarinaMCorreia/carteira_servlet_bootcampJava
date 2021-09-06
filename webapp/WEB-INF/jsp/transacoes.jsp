<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Transacoes</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
</head>
<body class="container">

	<div class="p-1 mb-1 mt-1 bg-info text-white border">
		<h2 class="text-center">Cadastrar Transações</h2>
	</div>

	<form action="<c:url value="/transacoes"/>" method="POST">
		<div class="form-group text-dark">

			<label for="ticker">TICKER</label> <input id="ticker"
				class="form-control thead-dark" name="ticker">
		</div>

		<div class="form-goup">
			<label for="data">DATA</label> <input id="data" class="form-control"
				name="data">
		</div>

		<div class="form-goup">
			<label for="preco">PREÇO</label> <input id="preco"
				class="form-control" name="preco">
		</div>

		<div class="form-goup">
			<label for="quantidade">QUANTIDADE</label> <input id="quantidade"
				class="form-control" name="quantidade">
		</div>

		<div class="form-goup">
			<label for="ti<div></div>po">TIPO</label> <input id="tipo"
				class="form-control" name="tipo">
		</div>
		<input type="submit" value="Gravar"
			class="p-1 mb-3 mt-2 btn-outline-dark ">

	</form>

	<div class="p-1 mb-1 bg-info text-white border">
		<h2 class="text-center ">Lista de Transações</h2>
	</div>

	<div class="table-responsive">
		<table class=" table-bordered table table-hover  table-success">
			<thead class="thead-dark">
				<tr>
					<th>TICKER</th>
					<th>DATA</th>
					<th>PRECO</th>
					<th>QUANTIDADE</th>
					<th>TIPO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${transacoes}" var="t">
					<tr>
						<td>${t.ticker}</td>
						<td>${t.data}</td>
						<td>${t.preco}</td>
						<td>${t.quantidade}</td>
						<td>${t.tipo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>