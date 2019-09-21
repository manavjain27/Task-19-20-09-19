<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<html>
<body>
	<h3>Employees LIST</h3>
	<hr>
	<table border="2">
		<tr>
			<th>Employee No</th>
			<th>Employee Name</th>
			<th>Employee Salary</th>
		</tr>



		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.getEno()}</td>
				<td>${emp.getEname()}</td>
				<td>${emp.getSal()}</td>
				<td><a href="deleteEmp?eno=${emp.eno}">[X]</a>
				<td><a href="showFetchedForm?eno=${emp.eno}">[Change]</a>
			</tr>
		</c:forEach>
	</table>

	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>