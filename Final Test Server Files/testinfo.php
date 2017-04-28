<?php
 include('config1.php');
$q="select * from testinfo";		 
      $r=mysql_query($q);	
	   while( $res = mysql_fetch_array($r))
		   {
		    //$tid= $res['tid'];
   		    $tname=$res['tname'];
			$neg=$res['neg'];
			if($neg)
			  $neg=1;
			  else
			  $neg=0;	
			print "~$tname";	
			
		   	 
		   }
		   print "~Dont Click";
 ?>