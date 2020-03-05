<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
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
<div class="container">
 <div>
  <a type="button" class="btn btn-primary btn-md" href="/addmessage">Add Message</a>
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>List of Messages</h3>
  </div>
  <div class="panel-body">
   <table id="userlists" class="table table-striped">
    <tbody>
     <c:forEach items="${message}" var="message">
      <tr>
       <td width="70%">${message.messagedesc}</td>
       <td><a type="button" class="btn btn-success"
        href="/updatemessage?id=${message.messageId}">Update</a>
       <a type="button" class="btn btn-warning"
        href="/deletemessage?id=${message.messageId}">Delete</a></td>
      </tr>
     </c:forEach>
    </tbody>
   </table>
  </div>
  </div>
 </div>
</body>
</html>