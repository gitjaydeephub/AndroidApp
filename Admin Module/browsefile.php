<?php
session_start();
?>

<!DOCTYPE html>
<html>
<body>
<?php
  if($_SESSION['username']!=null)
  {
$cat=$_POST['category'];
//echo $cat;
if($cat!=null)
{
echo "
<form action='upload.php' method='post' enctype='multipart/form-data'>
    <br />";
	if($cat=='Antonomy')
{
	    echo"<label> Category <label/>
     <select name='antonomy' value='antonomy'>
<option>Numbers And Simplification</option>
<option>Square Root And Cube Root</option>
<option>Average</option>
<option>Problem on Numbers And Ages</option>
<option>Profit And Loss</option>
<option>Ratio And Proportion</option>
<option>Partnership</option>
<option>Time And Work And Distance</option>
<option>Problem On Trains,Boats And Streams</option>
<option>Simple Interest And Compound Interest</option>
<option>Area And Volume</option>
<option>Stocks And Shares</option>
<option>Permutation And Combination</option>
<option>Probability</option>

<select />";
}
else if($cat=='Verbal')
{
	echo"
	<label> Category <label/>
     <select name='verbal' value='verbal'>
	<option>Analogies</option>
	<option>Selecting Words</option>
	<option>Antonyms</option>
	<option>One Word Substitution</option>
	<option>Synonyms</option>
	<option>Idioms And Phases</option>
	<option>Spell Check</option>
	<option>Ordering Of Sentences</option>
	<option>Sentence Correction</option>
	<select />";
	}
else if($cat=='Reasioning')
{
	echo"
	<label> Category <label/>
     <select name='reasioning' value='reasioning'>
	<option>Number And Letter Series</option>
	<option>Blood Relation</option>
	<option>Seating Arrangement</option>
	<option>Statement Conclusion</option>
	<option>Course Of Action</option>
	<option>Data Sufficiency</option>
	<option>Non Verbal</option>
	<option>Mathematical Operation</option>
	<option>Calendar</option>
	<option>Clock</option>
	<option>Cause And Effect</option>
	<option>Vein Diagram</option>
	<option>Direction</option>
	<option>Syllogism</option>
	<select />
	
	";
	}
	echo"
<br /><br />
   <label>Select Excel to upload:<label />
    <input type='file' name='fileToUpload' id='fileToUpload'>
     <br />
    
    <br />
    <input type='submit' value='Upload Question file' name='submit'>
</form>";
}
else
{
	echo  "
<form action='browsefile.php' method='post'>	
	<select name='category' value='Select'>
<option>Antonomy</option>
<option>Verbal</option>
<option>Reasioning</option>
<select />
<p>
	        <input type='submit' value='Search Sub_Category'>
	<p />
	";
	
	
	}
if($_SESSION['upload']!=null)
{
	echo $_SESSION['upload'];
	
	}
	if($_SESSION['ucheck1']!=null)
{
	echo $_SESSION['ucheck1']."<br />";
	
	}
if($_SESSION['ucheck2']!=null)
{
	echo $_SESSION['ucheck2']."<br />";
	
	}
if($_SESSION['ucheck7']!=null)
{
	echo $_SESSION['ucheck7']."<br />";
	
	}
if($_SESSION['ucheck3']!=null)
{
	echo $_SESSION['ucheck3']."<br />";
	
	}
if($_SESSION['ucheck4']!=null)
{
	echo $_SESSION['ucheck4']."<br />";
	
	}
if($_SESSION['ucheck5']!=null)
{
	echo $_SESSION['ucheck5']."<br />";
	
	}
if($_SESSION['ucheck6']!=null)
{
	echo $_SESSION['ucheck6']."<br />";
	
	}

$_SESSION['ucheck1']=null;
$_SESSION['ucheck2']=null;
$_SESSION['ucheck3']=null;
$_SESSION['ucheck4']=null;
$_SESSION['ucheck5']=null;
$_SESSION['ucheck6']=null;
$_SESSION['ucheck7']=null;
$_SESSION['upload']=null;
}
else
{
	$_SESSION['notlogin']=1;
 echo "<script> window.location.href='adminp1.php'</script>";}
?>
</body>
</html> 