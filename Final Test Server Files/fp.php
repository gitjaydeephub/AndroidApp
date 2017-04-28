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
		     $level=$res['level'];	
		  $uname=$res['Uname'];	
			//if($res==$null)
			print "~true~$level~$uname~";
				
			
		   }	 
else
print "~false~$level~$uname~";

 ?>