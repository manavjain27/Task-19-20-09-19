<%@taglib uri="http://www.springframework.org/tags/form"  prefix="fr"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Add Employee</h1>
<hr>
<fr:form action="save" modelAttribute="info">
<pre>
Emp No  :<fr:input path ="eno"/> <fr:errors path="eno">Only Digits Allowed</fr:errors><br><br><br>
Emp Name :<fr:input path ="ename"/> <fr:errors path="ename"/><br><br><br>
Emp  Sal :<fr:input path ="sal"/> <fr:errors path="sal">Only Digits Allowed</fr:errors><br><br><br>
<input type="submit" value="Save"/><br><br><br>
</pre>

</fr:form>
<hr>

  <a href="index.jsp">Home</a>
  </center>
</body>
</html>