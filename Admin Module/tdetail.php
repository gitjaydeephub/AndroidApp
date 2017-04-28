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
$tname=$_POST["tname"];
$des=$_POST["Test_Description"];
$neg= $_POST["Negative_Marking"];
$time=$_POST['time'];
//echo "<br/>".$tname;
//echo "<br />".$neg;
if($tname==null || $des==null || $neg==null || $time==null)
{
	$_SESSION['tdetail']="Please fill All the Detail";
echo "<script> window.location.href='testdetails.php'</script>";
	
	
	}
	else
	{
$_SESSION['tname']=$tname;
$_SESSION['des']=$des;
$_SESSION['neg']=$neg;
$_SESSION['time']=$time;
$con=mysqli_connect("localhost","root","","roombuddies1");
// Check connection
if (mysqli_connect_errno()) {
echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$result = mysqli_query($con,"select * from testinfo where tname='$tname';");
$r=mysqli_fetch_array($result);
if( $r!=null)
{
	$_SESSION['tdetail']='Test already present in Database';
	echo "<script> window.location.href='testdetails.php'</script>";
	
	
	}
	else
{
	echo "<script> window.location.href='browsefiletest.php'</script>";

	}
	}
?> 

</body>
</html>

