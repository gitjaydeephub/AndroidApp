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
	if($_SESSION['tdetail']!=null)
	{	echo $_SESSION['tdetail']."<br />";
		$_SESSION["tdetail"]=null;
	}if($_SESSION['tname1']!=null)
		{echo $_SESSION['tname1']."<br />";
		$_SESSION['tname1']=null;
		}
	echo "<a href='logout.php'><button>Logout</button></a><br />";	
	echo "<h2>Enter Test Details</h2><br/>
<form action='tdetail.php' method='post' name='testdetails'>
Test Name:    <input type='text' name='tname' id='tname'/><br/><br/>
Description:    <textarea name='Test_Description' cols='20' rows='3'></textarea><br/><br/>
  <label>
    Negative Marking<input type='radio' name='Negative_Marking' value='1' id='NegativeMarking_0' />
    Yes</label>
  <label>
    <input type='radio' name='Negative_Marking' value='0' id='NegativeMarking_1' />
    No</label>
  <br />
<br />
Time(in min):    <input type='number' name='time' id='time'/><br/><br/>

<input type= 'submit' value='Submit'/>

</form>";

}
else
{
	$_SESSION['notlogin']=1;
 echo "<script> window.location.href='adminp1.php'</script>";
	}
?>
</body>
</html>