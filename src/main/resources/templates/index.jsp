
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ page isELIgnored="false"%> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table table-hover">
  <thead>
    <tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>  
  </thead>
  <tbody>
  <c:forEach var="mp" items="${user}" >  
    <tr class="table-default">
      
   <td><c:out value="${mp.name}"/></td>  
      </tr>
      </c:forEach> 
   </tbody>
</table> 
</body>
</html>