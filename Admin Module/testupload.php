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

$target_dir = "C:/xampp/htdocs/upload";
$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
$uploadOk = 1;
$excel = pathinfo($target_file,PATHINFO_EXTENSION);
// Check if image file is a actual image or fake image
if(isset($_POST["submit"])) {
	
	//echo "Excel--><br />".$excel;
    if($excel=='xls'||$excel=='xlsx'||$excel=='xlsm'||$excel=='xlt'||$excel=='xlam'||$excel=='xla') {
        $_SESSION['ucheck2']= 'File is an Excel';
        $uploadOk = 1;
    } else {
        $_SESSION['ucheck2'] ="File is not an Excel sheet.";
        $uploadOk = 0;
    echo "<script> window.location.href='browsefiletest.php'</script>";
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
if($excel != 'xls'&&$uploadOk!=0) {
    $_SESSION['ucheck7']= "Sorry, only xls files are allowed.";
    $uploadOk = 0;
}
// Check if $uploadOk is set to 0 by an error
if ($uploadOk == 0) {
    $_SESSION['ucheck6']= "Sorry, your file was not uploaded.";
	echo "<script> window.location.href='browsefiletest.php'</script>";
// if everything is ok, try to upload file
} else {
    if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
        echo "The file ". basename( $_FILES["fileToUpload"]["name"]). " has been uploaded.";
		$excel=$_FILES["fileToUpload"]["name"];
		$_SESSION['name'] = $target_file;
					echo "<script> window.location.href='uploadtest.php'</script>";
		
		
		
    } else {
       $_SESSION['ucheck5']= "Sorry, there was an error uploading your file.";
    echo "<script> window.location.href='browsefiletest.php'</script>";
	}
}
?> 