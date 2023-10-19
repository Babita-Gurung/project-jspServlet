<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>Email</th>
						<th>Password</th>
						<th>Full Name</th>
						<th>Gender</th>
						<th>Age</th>
						<th>Operations</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${all}" var="oneObject">
						<tr>
							<td><c:out value="${oneObject.email}" /></td>
							<td><c:out value="${oneObject.password}" /></td>
							<td><c:out value="${oneObject.fullName}" /></td>
							<td><c:out value="${oneObject.gender}" /></td>
							<td><c:out value="${oneObject.age}" /></td>
							<c:choose>
								<c:when test="${oneObject.email eq adminEmail}">
									<td></td>
								</c:when>
								<c:otherwise>
									<td><a href="DeleteServlet?email=${oneObject.email}">
											<button type="button" class="btn btn-danger">Delete</button>
									</a></td>
									<td><a href="PreEditServlet?email=${oneObject.email}"><button
												type="button" class="btn btn-primary">Edit
											</button></a></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<a href="EmployeeLoginPage.jsp"><button type="button"
			value="Go to Employee Login Page" class='btn-login' id='do-login'>Go
			to Employee Login Page</button></a>

</body>
</html>