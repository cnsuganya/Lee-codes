<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<style>
/* Add a black background color to the top navigation */
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color:gray;
  color: white;
}
.navbar-default 
{
background-color:#4CAF50;
color: black;
padding:10px;
font-size: 25px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="topnav">
<sec:authorize ifAnyGranted="admin">
<a href="/welcome">Admin Profile</a>
<a href="/users">Users List</a>
<a href="/messagelist">Messages</a>
<a onclick="document.forms['logoutForm'].submit()">Logout</a>
</sec:authorize>
</div>
<div class="topnav">
<sec:authorize ifAnyGranted="user">
<a href="/welcome">User Profile</a>
<a href="/messagelist">Messages</a>
<a onclick="document.forms['logoutForm'].submit()">Logout</a>
</sec:authorize>
</div>
</body>
</html>