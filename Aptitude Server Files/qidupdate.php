<?php 
 
       
       $qid  = urldecode($_POST['qid']);
       $uname  = urldecode($_POST['uname']);
        
       $p;
 include('config1.php');
$q="UPDATE  student SET qid = $qid WHERE Uname = '$uname'";

$r=mysql_query($q);	


 print"falsbjhbne";
 ?>