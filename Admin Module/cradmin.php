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
	  echo "
<form id='form1' name='form1' method='post' action='signup.php'>
  <p>
    <label for='admin'>Username</label>
    <input type='text' name='admin' id='admin' />
  </p>
  <p>
    <label for='pass'>Password</label>
    <input type='password' name='pass' id='pass' />
   
  </p>
<input type='submit' name='Submit' id='Submit'>
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