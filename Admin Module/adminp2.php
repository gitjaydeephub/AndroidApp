<?php
session_start();
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
<?php
  if($_SESSION['username']!=null)
  {
	echo "<a href='logout.php'><button>Logout</button></a><br /><br />";	 
  	echo "<a href='browsefile.php'><button>Upload_Learning_Questions</button></a><br/><br/>";
    echo "<a href='testdetails.php'><button>Upload_Testing_Questions</button></a><br/><br/>";
	echo "<a href='cradmin.php'><button>Create Admin</button></a><br/><br/>";
	if($_SESSION['upload']!=null)
	{
		echo $_SESSION['upload'];
	$_SESSION['upload']=null;	
		}
  }
else
{
	$_SESSION['notlogin']=1;
 echo "<script> window.location.href='adminp1.php'</script>";
	
	}
	?>
</body>
</html>