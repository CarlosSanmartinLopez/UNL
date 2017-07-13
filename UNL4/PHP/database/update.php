<?php
	include "functions.php";
	$id= 0;
	$name = "";
	$surName = "";
	$email = "";
	if(isset($_GET['id'])) {
		$id = $_GET['id'];
		$user = getData($_GET['id']);
		$name = $user['nombre'];
		$surName = $user['apellido'];
		$email = $user['email'];
	} else
	if(isset($_POST['id'])) {
		$id = $_POST['id'];

		update($id, $_POST['name'], $_POST['surname'], $_POST['email'] , $_POST['id']);
		//updatePSW();
		$user = getData($_POST['id']);
		$name = $user['nombre'];
		$surName = $user['apellido'];
		$email = $user['email'];
	}
?>

<!DOCTYPE html>
<html>
<head>
	<title>Actualizar Datos</title>
</head>
<body>
	<form action="update.php" method="POST">
		<input type="text" name="id" style="display: none;" value="<?php echo $id; ?>">
		<label id="name">Nombre: </label>
		<input type="text" name="name" value="<?php echo $name; ?>"><br>
		<label id="surname">Apellido</label>
		<input type="text" name="surname" value="<?php echo $surName; ?>"><br>
		<label id="email">Email</label>
		<input type="email" name="email" value="<?php echo $email; ?>"><br>
		<h1>Si deseas cambiar la contraseña debes ingresar la clave actual</h1>
		<label id="">Contraseña Actual</label>
		<input type="password" name=""><br>
		<label id="">Contraseña Nueva</label>
		<input type="password" name=""><br>
		<label id="">Repetir la contraseña nueva</label>
		<input type="password" name=""><br><br><br>
		<input type="submit" value="Actualizar">
	</form>
</body>
</html>