<?php 
 
     $tname='antono';  
       
	   
	   
	   
	$con=mysqli_connect("localhost","root","","roombuddies1");
// Check connection
if (mysqli_connect_errno()) {
echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$result = mysqli_query($con,"select * from testinfo where tname='$tname';");
 $r=mysqli_fetch_array($result);
echo $r;
//	$_SESSION['tdetail']='Test already present in Database';
	//echo "<script> w
	
	
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   ?>