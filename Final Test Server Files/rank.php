<?php 
 
       
       $email  =urldecode($_POST['email']);
       $tname  = urldecode($_POST['tname']);
        $count=1;$flag=0;
 include('config1.php');
 //$q="SELECT * FROM tresult WHERE ";
 
 
 
 

$q="SELECT * FROM tr WHERE tname='$tname' ORDER BY percentile DESC";
     $r=mysql_query($q);	
    while( $res = mysql_fetch_array($r))
		   {
		    $semail= $res['semail'];
		     $percentile=$res['percentile'];	
		  $rank=$count;
		  $count++;
			if($email==$res['semail'])	  	
		   	{
			$flag=1;
				print "~true~$percentile~$rank~";		
				//echo"~$tname~34";			
				} 

		   }
		  // print "~true~$email~$tname~";
//print "~true~0~1~";
//echo"~$tname~34";		  
 ?>