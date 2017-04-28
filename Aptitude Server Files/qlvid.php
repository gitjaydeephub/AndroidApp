<?php
$semail=urldecode($_POST["semail"]);
      
$sname=urldecode($_POST["sname"]);
$level=urldecode($_POST["level"]);
//$qid=urldecode($_POST["qid"]);
$con=mysqli_connect("localhost","root","","roombuddies1") or die("unable to connect to database:".mysqli_error($con));
 //include('config1.php');

// Check connection
 if($level==-1) 
{
	$result = mysqli_query($con,"SELECT * FROM slevel WHERE semail='$semail' AND sname='$sname';");  
$row = mysqli_fetch_array($result);
	if($row==null)
	{
	$tem=0;
	mysqli_query($con,"INSERT INTO `slevel` (`semail`,`sname`,`slevel`) VALUES ('$semail','$sname','0');");

	mysqli_query($con,"INSERT INTO `rlevel` (`semail`,`Sname`,`l0`,`l1`,`l2`,`l3`,`l4`) VALUES ('$semail','$sname','0','0','0','0','0');");
	//echo "~.$semail";
	//echo "~.$sname";
$tem=0;	
echo "~$tem";
	echo "~$tem";
	echo "~$tem";
	echo "~$tem";
	echo "~$tem";
	echo "~$tem";
	}
    else
		{
		$level =$row[slevel];
		echo "~$level";
		$result=mysqli_query($con,"SELECT * FROM rlevel WHERE semail='$semail' AND Sname='$sname';");
			if(!$result)
				{
				echo "No Result found";
				exit;
				}
			else{

				$row = mysqli_fetch_array($result);
				$semail=$row['semail'];
				$sname=$row['Sname'];
				$level0=$row['l0'];
				$level1=$row['l1'];
				$level2=$row['l2'];
				$level3=$row['l3'];
				$level4=$row['l4'];
		//		echo "~.$semail";
			//	echo "~.$sname";
				echo "~$level0";
				echo "~$level1";
				echo "~$level2";
				echo "~$level3";
				echo "~$level4";
				}		

		}
	}
	/*
else if($qid==0)
{
		$result=mysqli_query($con,"SELECT * FROM rlevel WHERE semail='m' AND Sname='q1';");
			if(!$result)
				{
				echo "No Result found";
				exit;
				}
			else{

				$row = mysqli_fetch_array($result);
				echo "<br />semail--->".$row['semail'];
				echo "<br />sname--->".$row['Sname'];
				echo "<br />LEVEL 0 QID--->".$row['level0'];
				echo "<br />LEVEL 2 QID--->".$row['level1'];
				echo "<br />LEVEL 2 QID--->".$row['level2'];
				echo "<br />LEVEL 3 QID--->".$row['level3'];
				echo "<br />LEVEL 4 QID--->".$row['level4'];
				}		



}
	*/
mysqli_close($con);

?>
