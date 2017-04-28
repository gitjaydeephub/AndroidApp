<?php
session_start();
?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
</head>

<body>
<?php
$uname=$_POST["name"];
$pass=$_POST["pass"];
$con=mysqli_connect("localhost","root","","roombuddies1");
// Check connection
if (mysqli_connect_errno()) {
echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$result = mysqli_query($con,"SELECT * FROM admin
WHERE uname='$uname' and pass=MD5('$pass')");

if($row = mysqli_fetch_array($result)) {
if($row!=null)
{

$_SESSION['username']=$uname;
echo"Logged in ";
echo "<script> window.location.href='adminp2.php'</script>";
}
else
{
echo"Login Failed";	 
}
}
else
{
$_SESSION['register']='not';
echo "<script> window.location.href='register1.php'</script>"; 
}
?> 

</body>
</html>

