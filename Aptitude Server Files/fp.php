<?php 
 
       
       $email  = urldecode($_POST['email']);
       $pass   = urldecode($_POST['pass']);
        
       $p;

 include('config1.php');
$q="select * from student where email='$email' and pass=MD5('$pass')";		 
											       $r=mysql_query($q);	

												   if( $res = mysql_fetch_array($r))
		   {
		    $p= $res['pass'];
		     $level=0;	
		  $uname=$res['email'];	
				
			
		   	 
if($res!=null)
print "~true~$level~$uname~";
		   }
		   else
		   print "~false~0~a~";

 ?>