<?php 
 
       
      $level  = urldecode($_POST['level']);
	  //if($level==-1)
	  //$level=0;
       $sname  = urldecode($_POST['sname']);
              $semail  = urldecode($_POST['semail']);
	$qid=urldecode($_POST['qid']);
	$levelup='l'.$level;
  
$con=mysqli_connect("localhost","root","","roombuddies1") or die("unable to connect to database:".mysqli_error($con));

// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
else
{
	$result = mysqli_query($con,"UPDATE `slevel` SET slevel='$level' WHERE semail='$semail' AND sname='$sname'; ");    
	if(!$result)
	{
	echo "No Result found";
	exit;
	}
	$result = mysqli_query($con,"UPDATE `rlevel` SET $levelup='$qid' WHERE semail='$semail' AND Sname='$sname'; ");    
	if(!$result)
	{
	echo "No Result found";
	exit;
	}
}





?>