<?php if(!defined('ACCESS')) header('Location: .'); ?>

<!DOCTYPE html>
<html>
<head>
	<title>Bienvenido</title>
</head>
<body>
Bienvenido <?php echo $_SESSION['name']?>
<br>
HORA: <?php echo date('d/M/y H:i:s'); ?>
<br><br>

<?php
if(isset($_COOKIE['lastVisit']))
	echo 'Ultima Visita fue el : '.$_COOKIE['lastVisit'];
else
	echo 'Esta es tu primera visita';
?>
<br>
<a href="logout.php">SALIR</a>
</body>
</html>