<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
<h2>Enter Test Details</h2><br/>
<form action="http://localhost/upload/validation.php" method="post" name="testdetails">
Test Name: <input type="text" name="tname" id="tname"/><br/><br/>
Description:<textarea name="Test Description" cols="20" rows="3"></textarea><br/><br/>

Test Time: <input type="text" name="tt" id="tt"/><br/><br/>

<p>
  <label>
    Negative Marking<input type="radio" name="Negative Marking" value="0" id="NegativeMarking_0" />
    Yes</label>
  <label>
    <input type="radio" name="Negative Marking" value="1" id="NegativeMarking_1" />
    No</label>
  <br />
</p>

Validity of Test:<br/><br/> Days:<input type="text" name="days" id="days"/>  Hours:<input type="text" name="hrs" id="hrs"/>
 Minutes<input type="text" name="min" id="min"/><br/><br/>

<input type= "submit" value="Submit"/>

</form>

</body>
</html>