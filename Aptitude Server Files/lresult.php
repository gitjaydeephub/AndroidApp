<?php 
 
       
       $email  = $_GET['em'];
       $sname   =$_GET['cat'];
        
		
       $category=null;
/*$con=mysqli_connect("localhost","root","","roombuddies");
// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}*/

$result=array();
include('config1.php');
 $q="select * from slevel where semail='$email' and sname like '$sname%'";		 
		       $r=mysql_query($q);	
			  if($sname=='q')
				{
				while($res=mysql_fetch_array($r))
			   {
				
				
				$email=$res['semail'];	    	
				$cname=$res['sname'];
				$slevel=$res['slevel'];	
				if($cname=='q1')
				{
				  $category= 'Numbers And Simplification';
				  
				
				}
				else if($cname=='q2')
				{
				$category='Square Root And Cube Root';
	
				}else if($cname=='q3')
				{
				$category='Average';
			
				}else if($cname=='q4')
				{
				$category='Problem on Numbers And Ages';
		
				}else if($cname=='q5')
				$category='Percentage';
	
				else if($cname=='q6')
				$category='Profit And Loss';

				else if($cname=='q7')
				$category='Ratio And Proportion';
				else if($cname=='q8')
				$category='Partnership';
				else if($cname=='q10')
				$category='Time And Work And Distance';
				else if($cname=='q11')
				$category='Problem On Trains,Boats And Streams';
				else if($cname=='q12')
				$category='Simple Interest And Compound Interest';
				else if($cname=='q13')
				$category='Area And Volume';
				else if($cname=='q15')
				$category='Stocks And Shares';
				else if($cname=='q16')
				$category='Permutation And Combination';
				else if($cname=='q17')
				$category='Probability';
				else
				$category="No such category";				
				//echo "~$email~$category~$slevel~<br />";
			//   print "~$email~$category~$slevel~<br />";
			 array_push($result,
			array('cat'=>$category,'level'=>$slevel));
			   }
			    echo json_encode(array("result"=>$result));
			
			}
			else if($sname=='v')
			{
				while( $res = mysql_fetch_array($r))
			   {
				$email=$res['semail'];	    	
				$cname=$res['sname'];
				$slevel=$res['slevel'];	
				
				if($cname=='v1')
				  $category= 'Analogies';
				else if($cname=='v2')
				$category='Selecting Words';
				else if($cname=='v3')
				$category='Antonyms';
				else if($cname=='v4')
				$category='One Word Substitution';
				else if($cname=='v5')
				$category='Synonyms';
				else if($cname=='v6')
				$category='Idioms And Phases';
				else if($cname=='v7')
				$category='Spell Check';
				else if($cname=='v8')
				$category='Ordering Of Sentences';
				else if($cname=='v9')
				$category='Sentence Correction';
						
				//print "~$email~$category~$slevel~<br />";
			   array_push($result,
			array('cat'=>$category,'level'=>$slevel));
			   }
			    echo json_encode(array("result"=>$result));
				}
			else if($sname=='l')
			{
				while( $res = mysql_fetch_array($r))
			   {
				$email=$res['semail'];	    	
				$cname=$res['sname'];
				$slevel=$res['slevel'];	
				if($cname=='l1')
				  $category= 'Number And Letter Series';
				else if($cname=='l2')
				$category='Blood Relation';
				else if($cname=='l3')
				$category='Seating Arrangement';
				else if($cname=='l4')
				$category='Statement Conclusion';
				else if($cname=='l5')
				$category='Course Of Action';
				else if($cname=='l6')
				$category='Data Sufficiency';
				else if($cname=='l7')
				$category='Non Verbal';
				else if($cname=='l8')
				$category='Mathematical Operation';
				else if($cname=='l9')
				$category='Calendar';
				else if($cname=='l10')
				$category='Clock';
				else if($cname=='l11')
				$category='Cause And Effect';
				else if($cname=='l12')
				$category='Vein Diagram';
				else if($cname=='l13')
				$category='Stocks And Shares';
				else if($cname=='l14')
				$category='Direction';
				else if($cname=='l15')
				$category='Syllogism';
				else
				$category="No such category";				
				//print "~$email~$category~$slevel~<br />";
			   array_push($result,
			array('cat'=>$category,'level'=>$slevel));
			   }
			    echo json_encode(array("result"=>$result));//echo"No result found";
				}
		   
 ?>