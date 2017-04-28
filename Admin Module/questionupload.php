<?php 
session_start(); 
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>upload to database</title>

</head>
<?php
  if($_SESSION['username']!=null)
  {
echo "<a href='logout.php'><button>Logout</button></a>";	 
  }
?>
<?php
ini_set("display_errors",1);
require_once 'excel_reader2.php';
require_once 'db.php';
$category=$_SESSION['cat'];
$temp=$_SESSION["name"];
$data = new Spreadsheet_Excel_Reader("$temp");
$r;
//echo "Total Sheets in this xls file: ".count($data->sheets)."<br /><br />";

$html="<table border='1'>";
for($i=0;$i<count($data->sheets);$i++) // Loop to get all sheets in a file.
{	
	if(count($data->sheets[$i][cells])>0) // checking sheet not empty
	{
		//echo "Sheet $i:<br /><br />Total rows in sheet $i  ".count($data->sheets[$i][cells])."<br />";
		for($j=1;$j<=count($data->sheets[$i][cells]);$j++) // loop used to get each row of the sheet
		{ 
			/*$html.="<tr>";
			for($k=1;$k<=count($data->sheets[$i][cells][$j]);$k++) // This loop is created to get data in a table format.
			{
				$html.="<td>";
				$html.=$data->sheets[$i][cells][$j][$k];
				$html.="</td>";
			}*/
			$data->sheets[$i][cells][$j][1];
			$id  = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][1]);
			$sname = $category;//mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][2]);
			$ques = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][2]);
			$A = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][3]);
			$B = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][4]);
			$C = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][5]);
			$D = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][6]);
			$Answer = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][7]);
			$slevel = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][8]);

			$query = "insert into question(id,sname,Ques,A,B,C,D,Answer,slevel) values('','".$sname."','".$ques."','".$A."','".$B."','".$C."','".$D."','".$Answer."','".$slevel."')";
			
			$r=mysqli_query($connection,$query);
			$html.="</tr>";
		}
	}
	
}
//unlink($temp); 
//session_destroy();
$html.="</table>";
echo $html;
if($r!=0)
{
$_SESSION['upload']='Learning Question Inserted in dababase';
echo "<script> window.location.href='adminp2.php'</script>";
}
else
{
	$_SESSION['upload']='Learning Question Not Inserted in dababase';
echo "<script> window.location.href='browsefile.php'</script>";
}
?>