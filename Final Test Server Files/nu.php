<?php 
 
       
       $email  = urldecode($_POST['email']);
       $pass   = urldecode($_POST['pass']);
       $uname= urldecode($_POST['uname']);
       $cnumber   = urldecode($_POST['no']);
        
       $p;
 include('config1.php');
if($email!=null&&$pass!=null&&$uname!=null)
 {
$q="INSERT INTO `student` (`email`, `pass`,`cnumber`, `Uname`) VALUES ('$email',MD5('$pass'),'$cnumber', '$uname')";

$r=mysql_query($q);	
 }

if($r!=null)
 print"login successful";
 ?>