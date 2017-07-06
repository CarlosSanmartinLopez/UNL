<?php if(!defined('ACCESS')) header('Location: .'); ?>

<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<?php if(isset($erroLogin)) echo $erroLogin;?>
	<form action="index.php" method="POST">
		<label for="user">Usuario:</label><br>
		<input type="text" id="user" name="user"><br>
		
		<label for="pswd">Contraseña:</label><br>
		<input type="password" id="pswd" name="pswd"><br><br>
		
		<label for="remember">Recordarme</label>
		<input type="checkbox" id="remember" name="remember">

		<input type="submit" value="Ingresar">
	</form>
</body>
</html>