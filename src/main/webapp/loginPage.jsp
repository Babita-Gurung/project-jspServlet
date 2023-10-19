<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  <link href="https://fonts.googleapis.com/css?family=Assistant:400,700" rel="stylesheet"><link rel="stylesheet" href="./style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<section class='login' id='login'>
  <div class='head'>
  <h1 class='company'>Employee's Record</h1>
  </div>
  <p class='msg'>Welcome back</p>
  <div class='form'>
    <form method="post" action="LoginServlet">
  <input type="text" name = "uname" placeholder='Username' class='text' id='username' required><br>
  <input type="password" name = "pword" placeholder='••••••••••••••' class='password'><br>
  <input type="submit" value="Login" class='btn-login' id='do-login'>
  <!--a href="#" class='btn-login' id='do-login'>Login</a-->
  <!--a href="#" class='forgot'>Forgot?</a-->
    </form>
  </div>
</section>
<footer>
  <p>Made with <span class='heart'>&hearts;</span> by Bickey Manandhar</p>
  
</footer>
<!-- partial -->


</body>
</html>