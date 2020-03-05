<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><style>
#userlists {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#userlists td, #userlists th {
  border: 1px solid #ddd;
  padding: 8px;
}

#userlists tr:nth-child(even){background-color: #f2f2f2;}

#userlists tr:hover {background-color: #ddd;}

#userlists th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #D3D3D3;
  color: black;
}
</style>
</head>
<body>
<jsp:include page="menu.jsp" /> 
<table id="userlists" width="75%" align="center">
  <tr>
    <th>Id</th>
    <th>User Name</th>
  </tr>
  
  <c:forEach var="user" items="${users}">
  <tr>
    <td>${user.id}</td>
    <td>${user.username}</td>
  </tr>
  </c:forEach>
  </table>
</body>
</html>