<?php
session_start();

define("ACCESS", true);

	if(isset($_SESSION['name']) || isset($_COOKIE['remember'])) {
		if(isset($_COOKIE['remember'])) {
			$_SESSION['name'] = $_COOKIE['name'];
		}

		include 'page.php';
	} else {
		if(isset($_POST['user']) && isset($_POST['user'])) {
			include_once 'conection.php';
			
			$user = login($_POST['user'], $_POST['pswd']);
			if($user != null) {
				$_SESSION['name'] = $user['nombre']." ".$user['apellido'];

				if(isset($_POST['remember'])) {
					setcookie("remember", true, time()+60*60*7);
					setcookie("name", $_SESSION['name'], time()+60*60*7);
				}

				setcookie("lastVisit", date('d/M/y H:i:s'), time()+60*60*7);

				include 'page.php';
				exit(1);
			} else
				$erroLogin = "<p style='color: red;'>Usuario o la clave son incorrectos</p>";
		}
		include 'form.php';		
	}
?>