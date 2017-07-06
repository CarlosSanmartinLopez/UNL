<?php 
session_start();
session_destroy();

setcookie("remember", date('d/M/y H:i:s'), time()-25200);

header('Location: .');
 ?>