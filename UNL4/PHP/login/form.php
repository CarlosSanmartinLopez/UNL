<?php if(!defined('ACCESS')) header('Location: .'); ?>

<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<form action="/php/login/" method="POST">
		<label for="user">Usuario:</label><br>
		<input type="text" id="user" name="user"><br>
		
		<label for="pswd">Contraseña:</label><br>
		<input type="password" id="pswd" name="pswd"><br><br>
		
		<label for="remember"></label>
		<input type="checkbox" name="remember">

		<input type="submit" value="Ingresar">
	</form>
</body>
</html>