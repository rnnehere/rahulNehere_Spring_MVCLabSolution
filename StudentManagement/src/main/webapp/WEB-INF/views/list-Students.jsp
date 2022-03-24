<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
 
<title>Student Fest</title>
</head>
<body>
	<div class="container">
	
		<h3>Students Fest</h3>
		<hr>
		 
		<a href="/StudentManagement/student/showFormForAdd" class="btn btn-primary btn-sm mb-3">Add Student</a>
		
		<table class="table table-border table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					 <td><c:out value="${student.id}"></c:out></td>
					 <td><c:out value="${student.name}"></c:out></td>
					 <td><c:out value="${student.department}"></c:out></td>
					 <td><c:out value="${student.country}"></c:out></td>
					 <td>
					 	<a href="/StudentManagement/student/showFormForUpdate?studentId=${student.id}" class="btn btn-info btn-sm">
					 		Update
					 	</a>	
					 </td>
					 <td>
					 	<a href="/StudentManagement/student/delete?studentId=${student.id}" class="btn btn-danger btn-sm" 
					 	onclick="if (!(confirm('are you sure you want to delete this student?'))) return false">
					 		Delete
					 	</a>	
					 </td>
				</tr>
			</c:forEach>
				
			
			</tbody>
		</table>
		
	</div>
</body>
</html>