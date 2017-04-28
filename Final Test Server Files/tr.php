<?php 
 
       
       $semail  = urldecode($_POST['email']);
       $tname   = urldecode($_POST['tname']);
       $ra = urldecode($_POST['right']);
       $w   = urldecode($_POST['wrong']);
        
    
 include('config1.php');
 $q="select * from testinfo where tname='$tname'";
 $r=mysql_query($q);
 $row=mysql_fetch_array($r);
 $neg=$row['neg'];
 if($neg==0)
 $percentile=$ra;
 else
 $percentile=$ra-($w/3);

$q="UPDATE `tr` SET percentile='$percentile' WHERE semail='$semail' AND tname='$tname';";
//$q="insert into tr (semail,tname,percentile) values ($semail,$tname,$percentile);";
$r=mysql_query($q);	
if($r!=null)
print "~test uploaded~$semail";
else
print "~error~$semail";
 ?>