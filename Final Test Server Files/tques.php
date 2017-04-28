<?php 
 
       
     $tname  = urldecode($_POST['tname']);
       
    
       
 include('config1.php');
$q="SELECT * FROM `testques` where tname= '$tname'";
//'$tname'";

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