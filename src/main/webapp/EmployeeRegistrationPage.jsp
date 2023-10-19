<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link href="https://fonts.googleapis.com/css?family=Assistant:400,700"
	rel="stylesheet">
<link rel="stylesheet" href="./style.css">

</head>
<body>
	<!-- partial:index.partial.html -->
	<section class='login' id='login'>
		<div class='head'>
			<h1 class='company'>Employee's Registration Page</h1>

		</div>
		<h3>
			<p class='msg'>Sign Up</p>
		</h3>
		<div class='form'>
			<form method="post" action="EmployeeRegistrationServlet">
				<input type="text" name="email" placeholder='Email' class='text'
					id='username' required><br> <input type="password"
					name="password" placeholder='Password' class='password' required><br>
				<input type="text" name="fullname" placeholder='Full Name'
					class='text' id='username' required><br><br> <input
					type="text" name="gender" placeholder='Gender' class='text'
					required><br><br> <input type="text" name="age"
					placeholder='Age' class='text' required><br><br>
				<button type="submit" value="Login" class='btn-login' id='do-login'>Submit</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="reset" value="Reset" class='btn-login' id='do-login'>Reset</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="EmployeeLoginPage.jsp"><button type="button" value="Go to Login Page" class='btn-login' id='do-login'>Go to Login Page</button></a>
				<!--a href="#" class='btn-login' id='do-login'>Login</a-->
				<!--a href="#" class='forgot'>Forgot?</a-->
			</form>
		</div>
	</section>
	<footer>
		<p>
			Made with <span class='heart'>&hearts;</span> by Babita Gurung
		</p>

	</footer>
	<!-- partial -->


</body>
</html>