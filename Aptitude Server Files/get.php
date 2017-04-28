<?php 

include('config1.php');
$q="SELECT * FROM student";
$r=mysql_query($q);
$result = array();	
while( $row = mysql_fetch_array($r))
		   {
				array_push($result,
				array('uname'=>$row['Uname'],
				'password'=>$row['pass'],
                                'level'=>$row['level'],
                                'email'=>$row['email'],
				));
		   }	
		   echo json_encode(array("result"=>$result));
 ?>
