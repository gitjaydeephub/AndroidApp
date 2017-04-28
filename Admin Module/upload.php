<?php 
session_start(); 
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>File uploaded</title>

</head>
</html>
<?php
  if($_SESSION['username']!=null)
  {
echo "<a href='logout.php'><button>Logout</button></a>";	 
  }
?>
<?php
$_SESSION['ucheck1']=null;
$_SESSION['ucheck2']=null;
$_SESSION['ucheck3']=null;
$_SESSION['ucheck4']=null;
$_SESSION['ucheck5']=null;
$_SESSION['ucheck6']=null;
$_SESSION['ucheck7']=null;
//$_SESSION['upload']=null;
$target_dir = "C:/xampp/htdocs/upload";
$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
$uploadOk = 1;
$category;
$excel = pathinfo($target_file,PATHINFO_EXTENSION);
if($_POST['antonomy']!=null)
{
$cname=$_POST['antonomy'];
	if($cname=='Numbers And Simplification')
				{
				  $category= 'q1';
				  		
				}
				else if($cname=='Square Root And Cube Root')
				{
				$category='q2';
	
				}else if($cname=='Average')
				{
				$category='q3';
			
				}else if($cname=='Problem on Numbers And Ages')
				{
				$category='q4';
		
				}else if($cname=='Percentage')
				$category='q5';
	
				else if($cname=='Profit And Loss')
				$category='q6';

				else if($cname=='Ratio And Proportion')
				$category='q7';
				else if($cname=='Partnership')
				$category='q8';
				else if($cname=='Time And Work And Distance')
				$category='q10';
				else if($cname=='Problem On Trains,Boats And Streams')
				$category='q11';
				else if($cname=='Simple Interest And Compound Interest')
				$category='q12';
				else if($cname=='Area And Volume')
				$category='q13';
				else if($cname=='Stocks And Shares')
				$category='q15';
				else if($cname=='Permutation And Combination')
				$category='q16';
				else if($cname=='Probability')
				$category='q17';
				else
				$category="No such category";
		}
else if($_POST['verbal']!=null)
{
	$cname=$_POST['verbal'];
				if($cname=='Analogies')
				  $category= 'v1';
				else if($cname=='Selecting Words')
				$category='v2';
				else if($cname=='Antonyms')
				$category='v3';
				else if($cname=='One Word Substitution')
				$category='v4';
				else if($cname=='Synonyms')
				$category='v5';
				else if($cname=='Idioms And Phases')
				$category='v6';
				else if($cname=='Spell Check')
				$category='v7';
				else if($cname=='Ordering Of Sentences')
				$category='v8';
				else if($cname=='Sentence Correction')
				$category='v9';
				else
				$category="No such category";
		}
else if($_POST['reasioning']!=null)
{
	$cname=$_POST['reasioning'];
				if($cname=='Number And Letter Series')
				  $category= 'l1';
				else if($cname=='Blood Relation')
				$category='l2';
				else if($cname=='Seating Arrangement')
				$category='l3';
				else if($cname=='Statement Conclusion')
				$category='l4';
				else if($cname=='Course Of Action')
				$category='l5';
				else if($cname=='Data Sufficiency')
				$category='l6';
				else if($cname=='Non Verbal')
				$category='l7';
				else if($cname=='Mathematical Operation')
				$category='l8';
				else if($cname=='Calendar')
				$category='l9';
				else if($cname=='Clock')
				$category='l10';
				else if($cname=='Cause And Effect')
				$category='l11';
				else if($cname=='Vein Diagram')
				$category='l12';
				else if($cname=='Stocks And Shares')
				$category='l13';
				else if($cname=='Direction')
				$category='l14';
				else if($cname=='Syllogism')
				$category='l15';
				else
				$category="No such category";				
				
	}

// Check if image file is a actual image or fake image
if(isset($_POST["submit"])) {
	
	//echo "Excel--><br />".$excel;
    if($excel=='xls'||$excel=='xlsx'||$excel=='xlsm'||$excel=='xlt'||$excel=='xlam'||$excel=='xla') {
        $_SESSION['ucheck1']= 'File is an Excel';
        $uploadOk = 1;
    } else {
        $_SESSION['ucheck2'] ="File is not an Excel sheet.";
        $uploadOk = 0;
    echo "<script> window.location.href='browsefile.php'</script>";
	}
}
// Check if file already exists
if (file_exists($target_file)&&$uploadOk!=0) {
    $_SESSION['ucheck3']= "Sorry, file already exists.";
    $uploadOk = 0;
}
// Check file size
if ($_FILES["fileToUpload"]["size"] > 500000) {
    $_SESSION['ucheck4']= "Sorry, your file is too large.";
    $uploadOk = 0;
}
// Allow certain file formats
//$ext = pathinfo($filename, PATHINFO_EXTENSION);
if($excel !='xls' && $uploadOk!=0) {
    $_SESSION['ucheck7']= "Sorry, only xls files are allowed.";
    $uploadOk = 0;
}
// Check if $uploadOk is set to 0 by an error
if ($uploadOk == 0) {
    $_SESSION['ucheck6']= "Sorry, your file was not uploaded.";
	echo "<script> window.location.href='browsefile.php'</script>";
// if everything is ok, try to upload file
} else {
    if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
        echo "The file ". basename( $_FILES["fileToUpload"]["name"]). " has been uploaded.";
		$excel=$_FILES["fileToUpload"]["name"];
		$_SESSION['name'] = $target_file;
		$_SESSION['cat']=$category;
					echo "<script> window.location.href='questionupload.php'</script>";
		
		
		
    } else {
       $_SESSION['ucheck5']= "Sorry, there was an error uploading your file.";
    echo "<script> window.location.href='browsefile.php'</script>";
	}
}
?> 