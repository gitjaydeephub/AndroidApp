<?php
session_start();
?>

<!DOCTYPE html>
<html>
<body>

<?php
  if($_SESSION['username']!=null)
  {
echo "<a href='logout.php'><button>Logout</button></a><br />";	 
	echo "<form action='testupload.php' method='post' enctype='multipart/form-data'>
    <br />Select Excel to upload:
    <input type='file' name='fileToUpload' id='fileToUpload'>
     <br /><br />
    <input type='submit' value='Upload Test file' name='submit'>
</form>";
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
if($_SESSION['upload']!=null)
{
	echo $_SESSION['upload']."<br />";
	
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