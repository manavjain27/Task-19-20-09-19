<%@page isELIgnored="false" %>
<%@page import="com.wp.entities.Emp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<br>
<h1>Update Employee</h1>
<hr>

<fr:form action="update" modelAttribute="info">
<pre style="font-size:"16px";>
Emp No          :   <fr:input path="eno"/> <fr:errors path="eno">Only Digits Allowed</fr:errors><br><br><br>
Emp Name        :   <fr:input path="ename"/> <fr:errors path="ename"/><br><br><br>
Emp  Sal        :   <fr:input path="sal" /> <fr:errors path="sal">Only Digits Allowed</fr:errors><br><br><br>
   <input type="submit" value="Update"/><br><br><br>
</pre>
</fr:form>

<hr>
	<a href="index.jsp">Home</a>
	</center>

</body>
</html>