<?php 
 
       
       $email  = urldecode($_POST['Email']);
      
 include('config1.php');
 $q="SELECT * FROM tr Where semail='$email'";
     $r=mysql_query($q);	
    while( $res = mysql_fetch_array($r))
		   {
		    $semail= $res['tname'];
print"~$semail";
		  
		
		   }
		   print "~Dont Click";
		  // print "~$email";
//print		"~hii!~kdfd~jjf;";

  ?>
