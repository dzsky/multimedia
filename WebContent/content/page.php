<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<div class="picture"> 
		<?php 
			echo $_REQUEST['page'];
			$dbc = mysqli_connect('localhost', 'root', '123456', 'multimedia')or die("error01");
        	$query = "SELECT * from resource";
        	$data = mysqli_query($dbc, $query)or die ("查询失败");
			$row = mysqli_fetch_array($data);
			mysqli_close($dbc);
			echo $row['resource_id'];
	
	?>     
	      <a class="example-image-link" href="http://lokeshdhakar.com/projects/lightbox2/images/image-5.jpg" data-lightbox="example-set" data-title="The next image in the set is preloaded as you're viewing."><img class="example-image" src="http://lokeshdhakar.com/projects/lightbox2/images/thumb-5.jpg" alt="" /></a>
	</div><!--picture--> 
	<div class="picture">     
	      <a class="example-image-link" href="http://lokeshdhakar.com/projects/lightbox2/images/image-6.jpg" data-lightbox="example-set" data-title="Click anywhere outside the image or the X to the right to close."><img class="example-image" src="http://lokeshdhakar.com/projects/lightbox2/images/thumb-6.jpg" alt="" /></a>
		</div><!--picture--> 


	
	
</body>
</html>