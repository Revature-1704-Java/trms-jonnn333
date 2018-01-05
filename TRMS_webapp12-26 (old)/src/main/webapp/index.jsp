<html>
<head>
	<title>Single Page Application (SPA)</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	 <link rel="stylesheet" href="trmsCSS_thing.css">
</head>

<body>
<h2>Hello World! Attempting to build SPA</h2>
<h3>Well, sticking to static HTML first...</h3>

 <div class="container">
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>
	
    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

	<br>
	<br> 
	
    <button type="submit">Login</button>
    
    <button type="button" class="cancelbtn">Cancel</button>
  </div>

	<br>
  <div class="container" style="background-color:#f1f1f1">
    <input type="checkbox"> Remember me
    <br>
    <span class="psw"><a href="#">Forgot password?</a></span>
   </div>

	<div class="actionButtons">
		<form action="">
         	<input type="button" value="Help" onclick="window.location.href='Students.html';"/>
         	<input type="button" value="Terms of Service" onclick="window.location.href='Courses.html';"/>
         	<input type="button" value="moola" onclick="window.location.href='Payment.html';"/>
    	</form> 	
	</div>
	
</body>

</html>
