<?php 
 
       
       $qid  = urldecode($_POST['qid']);
      $sname  = urldecode($_POST['sname']);
       $level  = urldecode($_POST['level']);
$count=0;      
   //$qid  = 1;
    //$sname  ="antonomy";
  //$slevel  = 1;
      
       
 include('config1.php');
$q="SELECT * FROM question WHERE sname='$sname' AND slevel='$level' AND id>'$qid' LIMIT 1";

$r=mysql_query($q);    
if( $res = mysql_fetch_array($r))
          {
           $A= $res['A'];
           $B= $res['B'];
           $C= $res['C'];
           $D= $res['D'];
           $id= $res['id'];
            $ANS = strtolower($res['Answer']);
            $Ques = $res['Ques'];
            if($ANS==strtolower($A))
              {
			$count=1;
				  $ANS='1';
			  }
            if($ANS==strtolower($D))
              {
				  $count=1;
				  $ANS='4';
			  }
            if($ANS==strtolower($C))
              {
				  $count=1;
				  $ANS='3';
			  }
            if($ANS==strtolower($B))
              {
				  $count=1;
				  $ANS='2';
			  }
			  if($count==1)
            print"~$Ques~$A~$B~$C~$D~$ANS~$id";                
            else
			{
				$qid++;
			$q="SELECT * FROM question WHERE sname='$sname' AND slevel='$level' AND id>'$qid' LIMIT 1";
			$r=mysql_query($q);    
			if( $res = mysql_fetch_array($r))
          	{
           		$A= $res['A'];
           		$B= $res['B'];
           		$C= $res['C'];
           		$D= $res['D'];
           		$id= $res['id'];
           		 $ANS = strtolower($res['Answer']);
            	$Ques = $res['Ques'];
            if($ANS==strtolower($A))
              {
			$count=1;
				  $ANS='1';
			  }
            if($ANS==strtolower($D))
              {
				  $count=1;
				  $ANS='4';
			  }
            if($ANS==strtolower($C))
              {
				  $count=1;
				  $ANS='3';
			  }
            if($ANS==strtolower($B))
              {
				  $count=1;
				  $ANS='2';
			  }
			  if($count==1)
            print"~$Ques~$A~$B~$C~$D~$ANS~$id";                
			else
			print"~Wrong Question in Database Please Check your Database~a~b~c~d~1~$id";
			}
	else
    {                                              
print "~a~b~c~d~e~0~$qid";
//    print"~No more question availabe~Will~Start~Again~From~0~0";                
    }		
          }     
		}
    else
    {                                              
print "~a~b~c~d~e~0~$qid";
//    print"~No more question availabe~Will~Start~Again~From~0~0";                
    }

 ?>