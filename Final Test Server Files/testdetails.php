<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<style>
.error {color: #FF0000;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
<?php 
$tname =""; 
$Description =""; 
$neg ="";
$tnameError ="";
$DescriptionError ="";
$negError ="";
$successMessage =""; // On submittingform below function will execute.
if ($_SERVER["REQUEST_METHOD"] == "POST")  { // Checking null values in message.
	if (empty($_POST["tname"])){
	$tnameError = "Test name is required";
	}
	else
 	{
	$tname = test_input($_POST["tname"]); // check name only contains letters and whitespace
	if (!preg_match("/^[a-zA-Z ]*$/",$tname))
		{
			$tnameError = "Only letters and white space allowed";
		}
	} // Checking null values inthe message.
	if (empty($_POST["Description"]))
	{
		$DescriptionError = "Description is required";
	}	
	else
 	{
		$Description = test_input($_POST["Description"]);
	} // Checking null values inmessage.
	 // Checking null values inmessage.
	if (empty($_POST["neg"]))
	{
		$negError = "option is required";
	}
	else
 	{
		$neg = test_input($_POST["neg"]);
	} // Checking null values inthe message.
   }

function test_input($data){
//	echo 'hello';
$data = trim($data);
$data =stripslashes($data);
$data =htmlspecialchars($data);
return $data;
}
?>
 <h2>Enter Test Details</h2><br/>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>"> 
Test Name: <input type="text" name="tname" id="tname"/>
<span class="error">* <?php echo $tnameError;?></span><br/><br/>
Description:<textarea name="Description" cols="20" rows="3"></textarea>
<span class="error">* <?php echo $DescriptionError;?></span><br/><br/>
<p>
   Negative Marking:
   <input type="radio" name="neg" <?php if (isset($neg) && $neg==1) echo "checked";?>  value=1>Yes
   <input type="radio" name="neg" <?php if (isset($neg) && $neg==0) echo "checked";?>  value=0>No
   <span class="error">* <?php echo $negErr;?></span>
  <br />
</p>

<input type= "submit" value="submit"/>

</form>

</body>
</html>