<?php
if(!defined('ACCESS')) header('Location: .');

function login($user = "", $psw = "") {
	$mysqli = new mysqli("localhost", "root", "root", "cuarto_a");

	if($mysqli->connect_errno) {
	    echo "Error: Fallo al conectarse a MySQL \n";
	    /*
	    echo $mysqli->connect_errno . " - ";
	    echo $mysqli->connect_error . "\n";
	    */
	    exit;
	}

	$sql = "SELECT nombre,apellido FROM usuarios WHERE email = '$user' AND clave='".md5($psw)."' LIMIT 1; ";
	
	if(!$resultado = $mysqli->query($sql)) {
		return null;
	} else {
		while ($user = $resultado->fetch_assoc()) {
		    return $user;
		}
	}
}

function save($name = "", $surname = "", $email = "", $psw = "") {
	$mysqli = new mysqli("localhost", "root", "root", "cuarto_a");

	if($mysqli->connect_errno) {
	    echo "Error: Fallo al conectarse a MySQL \n";
	    /*
	    echo $mysqli->connect_errno . " - ";
	    echo $mysqli->connect_error . "\n";
	    */
	    exit;
	}

	$sql = "INSERT INTO  usuarios VALUES(null, '$name', '$surname', '$email', '".md5($psw)."');";
	
	if ($mysqli->query($sql) === true)
		echo "Guardado con Exito";
	else 
	 	echo "Inconveniente al guardar los Datos";
	
	exit(1);
}
?>