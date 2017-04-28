<?php
  $email  = urldecode($_POST['email']);
  $cat=urldecode($_POST['tname']);
 include('config1.php');
$q="Insert into tr (semail,tname,percentile) values ('$email','$cat','0')";			 
      $r=mysql_query($q);
	  //$res = mysql_fetch_array($r);	
	   if($r!=NULL)
		   {
		    
			print "~true~$email~$cat~";	
			
		   	 
		   }
		   else
		  {
			
			  print "~false~";
			  
			  } 
		   //print "~Bakkar";
 ?>