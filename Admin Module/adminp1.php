<?php
session_start();
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login Form</title>
<style type="text/css">
 h2 {letter-spacing: 10px; font-size: .2in}
</style>
</head>

<body>
<h1>Login</h1>
<form action="login.php" method="post" name="loginForm">
	<fieldset>
    <legend>Login Form</legend>
	Username: <input type="text" name="name" id="unam"/><br/>
    Password: <input type="password" name="pass"/><br/>
    <input type= "submit" value="ogin"/>
    </fieldset>
</form>
<?php
if($_SESSION['notlogin']==1)
{
	//echo "hello"; 
	echo "Please Login<br />";
	
	$_SESSION['notlogin']=0;
	}

?>
<a href="abc.php">Forgot Password?</a> 
<p>&nbsp;</p>

</body>
</html>