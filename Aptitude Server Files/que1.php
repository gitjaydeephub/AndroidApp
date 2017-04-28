<?php 
 
       
     //  $id  = urldecode($_POST['email']);
       
    
       
 include('config1.php');
$q="SELECT * FROM `question`";

$r=mysql_query($q);	
while( $res = mysql_fetch_array($r))
		   {
		    $A= $res['A'];
		    $B= $res['B'];
		    $C= $res['C'];
		    $D= $res['D'];
		     $ANS = strtolower($res['Answer']);
			 $Ques = $res['Ques'];
			 if($ANS==strtolower($A))
			   $ANS='1';
			if($ANS==strtolower($D))
			   $ANS='4';
			if($ANS==strtolower($C))
			   $ANS='3';
			if($ANS==strtolower($B))
			   $ANS='2';
			
			print"~$Ques~$A~$B~$C~$D~$ANS";	
				
			
		   }	 
											       


 ?>