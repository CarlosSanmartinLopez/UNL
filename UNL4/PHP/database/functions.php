<?php

function loadUsers() {
	$mysqli = new mysqli("localhost", "root", "root", "cuarto_a");

	if($mysqli->connect_errno) {
	    echo "Error: Fallo al conectarse a MySQL \n";
	    /*
	    echo $mysqli->connect_errno . " - ";
	    echo $mysqli->connect_error . "\n";
	    */
	    exit;
	}

	$sql = "SELECT id,nombre,apellido,email FROM usuarios ";
	
	if(!$resultado = $mysqli->query($sql)) {
		$users = "";
	} else {
		$users = "";
		$c = 0;
		while ($user = $resultado->fetch_assoc()) {
			$users .= "<tr>";
		    $users .= "<td>".++$c."</td>";
		    $users .= "<td>".$user['nombre']."</td>";
		    $users .= "<td>".$user['apellido']."</td>";
		    $users .= "<td>".$user['email']."</td>";
		    $users .= "<td><a href='update.php?id=".$user['id']."'>Actualizar</a></td>";
		    $users .= "<td><a href='#'>Eliminar</a></td>";
		    $users .= "</tr>";
		}
		return $users;
	}
}

function getData($id = 0) {
	$mysqli = new mysqli("localhost", "root", "root", "cuarto_a");

	$sql = "SELECT id,nombre,apellido,email FROM usuarios WHERE id=$id LIMIT 1";
	
	if(!$resultado = $mysqli->query($sql)) {
		return null;
	} else {
		while ($user = $resultado->fetch_assoc()) {
			return $user;
		}
	}
}

function update($id = 0, $name = "", $surname = "", $email = "") {
	$mysqli = new mysqli("localhost", "root", "root", "cuarto_a");

	$sql = "UPDATE usuarios SET nombre = '$name', apellido = '$surname', email='$email' WHERE id=$id ;";
	
	if ($mysqli->query($sql) === true)
		echo "Actualizado con exito";
	else 
	 	echo "Inconveniente al actualizar los Datos";

}
function updatePSW($id = 0, $paswOld = "", $paswNew = "") {
	$mysqli = new mysqli("localhost", "root", "root", "cuarto_a");

	$sql = "UPDATE usuarios SET clave = '".md5($paswNew)."' WHERE (id=$id  AND clave='".md5($paswOld)."');";
	
	if ($mysqli->query($sql) === true)
		echo "Contraseña Actualizada con exito";
	else 
	 	echo "Inconveniente al actualizar la Contraseña";

}
?>