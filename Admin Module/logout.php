<?php
session_start();
?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>LogOut</title>
</head>

<body>
<?php

session_destroy();
echo "<script> window.location.href='adminp1.php'</script>";	
	
?>


</body>
</html>