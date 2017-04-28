<?php
session_start();
$uname=$_POST["admin"];
$pass=$_POST["pass"];
// Check connection
include('config1.php');
$result = mysql_query("INSERT INTO admin (uname ,pass) VALUES ('$uname',MD5('$pass'));");

if($result!=null)
{
	echo $result;
//echo"Signup successFully ";
$_SESSION['upload']='Admin added Successfully';
echo "<script> window.location.href='adminp2.php'</script>";
}
else
{
$_SESSION['upload']='Admin Not added';
echo "<script> window.location.href='adminp2.php'</script>";
	
	
	
	}




?>