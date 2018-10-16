<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<title>Aplicacion Test Tecso</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular.min.js"></script>
<script src="/js/angular.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
</head>
<body>
	<div class="container" ng-app="app">
		<h1>Aplicacion Test Tecso</h1>
 
		<div class="row">
			<div ng-controller="postController" class="col-md-3">
				<div>
					<h3>Buscar Alumno Por DNI</h3>
					<form name="customerForm" ng-submit="getAlumno()">
						<label>Numero de Documento</label>
						<input type="text" name="documentoBuscar" class="form-control" ng-model="documentoBuscar" />
						
						<button type="submit" class="btn btn-primary">Buscar</button>
					</form>
					<button ng-click="deleteAlumno()" class="btn btn-primary" ng-if="enableDelete">Eliminar Alumno</button>
					<p>{{getAlumnoResultMessage}}</p>
					<p>{{deleteAlumnoResultMessage}}</p>
				</div>
				<div ng-if="enableInscribirACurso">
					<h3>Inscribir a Curso</h3>
					<form name="customerForm" ng-submit="submitAlumnoToCourse()">
						<label for="singleSelect"> Curso: </label><br>
    					<select data-ng-options="c.nombre for c in cursos" data-ng-model="selectedCourse"></select>
    					
    					<button type="submit" class="btn btn-primary">Inscribir Alumno</button>
    				</form>
    				<p>{{inscripcionResultMessage}}</p>
    			</div>
				<div>
					<h3>Agregar o Editar Alumno</h3>
					<form name="customerForm" ng-submit="submitAlumno()">
						<label for="singleSelect"> Tipo de Documento: </label><br>
    					<select name="singleSelect" id="singleSelect" ng-model="tipoDoc">
      						<option value="">---Seleccione---</option>
      						<option value="DNI">Dni</option>
      						<option value="LIBRETACIVICA">Libreta Civica</option>
    					</select>
    					<label>Numero de Documento</label>
						<input type="text" name="documento"	class="form-control" ng-model="documento" />
						<label>Nombre/s</label>
						<input type="text" name="nombre" class="form-control" ng-model="nombre" />
						<label>Apellido/s</label>
						<input type="text" name="apellido" class="form-control" ng-model="apellido" />
						<label>Fecha de Nacimiento</label>
						<input type="text" name="fechaNac" class="form-control" ng-model="fechaNac" />
						<label>Domicilio</label>
						<input type="text" name="direccion" class="form-control" ng-model="direccion" />
						<label>Legajo</label>
						<input type="text" name="legajo" class="form-control" ng-model="legajo" />
					
						<button type="submit" class="btn btn-primary">Guardar Alumno</button>
					</form>
					<p>{{postResultMessage}}</p>
				</div>
				<div ng-if="enableEstadoAcademico">
					<h3>Estado Academico Del Alumno</h3>
					<label>Numero de Documento</label>
						<input type="text" name="documento"	class="form-control" ng-model="documento" />
						<label>Nombre/s</label>
						<input type="text" name="nombre" class="form-control" ng-model="nombre" />
						<label>Apellido/s</label>
						<input type="text" name="apellido" class="form-control" ng-model="apellido" />
						<label>Fecha de Nacimiento</label>
						<input type="text" name="fechaNac" class="form-control" ng-model="fechaNac" />
						<label>Domicilio</label>
						<input type="text" name="direccion" class="form-control" ng-model="direccion" />
						<label>Legajo</label>
						<input type="text" name="legajo" class="form-control" ng-model="legajo" />
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>