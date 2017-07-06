<?php
if(isset($_POST['name']) && isset($_POST['surname']) &&
   isset($_POST['email']) && isset($_POST['pswd'])):

	define("ACCESS", true);

	include_once 'conection.php';
	
	save($_POST['name'], $_POST['surname'], $_POST['email'], $_POST['pswd']);
endif;
?>

<!DOCTYPE html>
<html>
<head>
	<title>Guardar Datos</title>
</head>
<body>
	<form action="saveData.php" method="POST">
		<label for="name">Nombre:</label><br>
		<input type="text" id="name" name="name"><br>
		
		<label for="surname">Apellido:</label><br>
		<input type="text" id="surname" name="surname"><br><br>
		
		<label for="email">Email:</label><br>
		<input type="text" id="email" name="email"><br><br>

		<label for="pswd">Contraseña:</label><br>
		<input type="password" id="pswd" name="pswd"><br><br>
		
		<input type="submit" value="Guardar">
	</form>
</body>
</html>