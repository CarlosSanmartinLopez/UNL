<?php
if(!defined('ACCESS')) header('Location: .');

function login($user = "", $psw = "") {
	$mysqli = new mysqli("localhost", "root", "root", "cuarto_a");

	if($mysqli->connect_errno) {
	    echo "Error: Fallo al conectarse a MySQL \n";
	    /*
	    echo "Errno: " . $mysqli->connect_errno . "\n";
	    echo "Error: " . $mysqli->connect_error . "\n";
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
?>