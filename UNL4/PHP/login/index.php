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
			if($_POST['user'] == 'admin' && $_POST['pswd'] == '123') {
				$_SESSION['name'] = 'Carlos';

				if(isset($_POST['remember'])) {
					setcookie("remember", true, time()+60*60*7);
					setcookie("name", $_SESSION['name'], time()+60*60*7);
				}

				setcookie("lastVisit", date('d/M/y H:i:s'), time()+60*60*7);

				include 'page.php';
				exit(1);
			}
		}
		include 'form.php';		
	}
?>