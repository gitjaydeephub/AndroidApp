<?php
  $email  = urldecode($_POST['email']);
  $cat=urldecode($_POST['tname']);
 include('config1.php');
$q="select * from tr where semail='$email' AND tname='$cat';";		 
      $r=mysql_query($q);
	  $res = mysql_fetch_array($r);	
$q2="select * from testinfo where tname='$cat'";
$r2=mysql_query($q2);
	  $res2=mysql_fetch_array($r2);
	   if($res!=NULL)
		   {
		    //$tid= $res['tid'];
   		    $tname=$res['tname'];
			
			//$neg=$res['neg'];
			//if($neg)
			  //$neg=1;
			  //else
			  //$neg=0;	
			print "~true~$time";	
			
		   	 
		   }
		   else
		  {
			// $q="Insert into tr (semail,tname,percentile) values ('$email','$cat','0')";		 
      //$r=mysql_query($q);	
 		//	if($r)
			  
			  $time1=$res2['tim'];
			  $time=$time1*60;
			  print "~false~$time~";
			  
			  } 
		   //print "~Bakkar";
 ?>