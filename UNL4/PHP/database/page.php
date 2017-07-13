<?php if(!defined('ACCESS')) header('Location: .'); 
include "functions.php"; ?>
<!DOCTYPE html>
<html>
<head>
	<title>Bienvenido</title>
</head>
<body>
<table>
	<tr>
	    <th>#</th>
	    <th>Nombre</th>
	    <th>Apellido</th>
	    <th> </th>
	    <th> </th>
  	</tr>
  	<?php
  		echo loadUsers();
  	?>
</table>
<br>
<a href="logout.php">SALIR</a>
</body>
</html>