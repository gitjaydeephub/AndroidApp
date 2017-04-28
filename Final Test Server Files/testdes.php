<?php
$tname=urldecode($_POST['testid']);
 include('config1.php');
$q="select * from testinfo where tname='$tname'";		 
      $r=mysql_query($q);	
	   while( $res = mysql_fetch_array($r))
		   {
		    $des= $res['tdes'];
   		    //$tid=$res['tid'];	
			print "~$des~";	
			
		   	 
		   }
 ?>