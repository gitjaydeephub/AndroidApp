<?php
$con = mysql_connect('localhost','root','','roombuddies1');
$res = mysql_select_db('roombuddies1',$con);
if(!$res)
{
 echo "database connection failed";	
}
//global $project_path;
//$project_path="http://localhost/TEST/uploads/";
?>