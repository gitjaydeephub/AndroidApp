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
ini_set("display_errors",1);
require_once 'excel_reader2.php';
require_once 'db.php';

$temp=$_SESSION["name"];
$data = new Spreadsheet_Excel_Reader("$temp");
$r;
//echo "Total Sheets in this xls file: ".count($data->sheets)."<br /><br />";


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
			$id = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][1]);
			$tname = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][2]);
			$ques = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][3]);
			$A = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][4]);
			$B = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][5]);
			$C = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][6]);
			$D = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][7]);
			$Answer = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][8]);
			$marks = mysqli_real_escape_string($connection,$data->sheets[$i][cells][$j][9]);

			$query = "insert into test (qid,tname,Ques,A,B,C,D,Answer,marks) values ('','".$tname."','".$ques."','".$A."','".$B."','".$C."','".$D."','".$Answer."','".$marks."')";
			
			$r=mysqli_query($connection,$query);
			$html.="</tr>";
		}
	}
	
}
//unlink($temp); 
session_destroy();
if($r!=0)
echo "<br />Data Inserted in dababase";
else
echo "<br />Data not inserted in database ";
?>