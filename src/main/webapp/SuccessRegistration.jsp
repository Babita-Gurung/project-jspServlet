<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">
  <title>Success Registration Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    body {
      text-align: center;
      padding: 40px 0;
      background: #EBF0F5;
      font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
    }
    h1 {
      color: #88B04B;
      font-weight: 900;
      font-size: 40px;
      margin-bottom: 10px;
    }
    .checkmark-container {
      display: flex;
      align-items: center;
      justify-content: center;
      margin-bottom: 20px;
    }
    .checkmark-container i {
      color: #9ABC66;
      font-size: 100px;
    }
    .card {
       background: white;
        padding: 60px;
        border-radius: 4px;
        box-shadow: 0 2px 3px #C8D0D8;
        display: inline-block;
        margin: 0 auto;
    }
    .container {
      margin-top: 20px;
    }
  </style>
</head>
<body>
  <h1>Congratulations, ${fullName}, you are successfully registered.</h1>
  <div class="card">
    <div class="checkmark-container">
      <div style="border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;">
        <i class="checkmark">✓</i>
      </div>
    </div>
  </div><br><br>
  <p>    <a href="EmployeeLoginPage.jsp">Click here to login now.</a> </p>
</body>
</html>

