<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Login Form</title>
  <link href="https://fonts.googleapis.com/css?family=Assistant:400,700" rel="stylesheet"><link rel="stylesheet" href="./style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<section class='login' id='login'>
  <div class='head'>
    <h1 class='company'>Admin Login Page</h1>
  </div>
  <h3><p class='msg'>Sign In</p></h3>
  <div class='form'>
    <form method="post" action="AdminLoginServlet">
  <input type="email" name = "email" placeholder='Email' class='text' id='username' required><br>
  <input type="password" name = "password" placeholder='Password' class='password' required><br>
  <button type="submit" value="Login" class='btn-login' id='do-login'>Submit</button>
  <button type="reset" value="Reset" class='btn-login' id='do-login'>Reset</button>
  <a href="EmployeeLoginPage.jsp"><button type="button" value="Login as Employee" class='btn-login' id='do-login'>Login as Employee</button></a>
  <!--a href="#" class='btn-login' id='do-login'>Login</a-->
  <!--a href="#" class='forgot'>Forgot?</a-->
    </form>
  </div><br><br><br>
</section>
<footer>
  <p>Made with <span class='heart'>&hearts;</span> by Babita Gurung</p>
  
</footer>
<!-- partial -->


</body>
</html>