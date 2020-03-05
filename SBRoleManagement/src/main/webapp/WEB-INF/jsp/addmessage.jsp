<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp" /> 
<div class="container">
 <div class="row">
  <div class="col-md-6 col-md-offset-3 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Add Message</div>
    <div class="panel-body">
     <form:form method="post" modelAttribute="message" action="/addmessage">
      <form:hidden path="messageId" />
      <fieldset class="form-group">
       <form:label path="messagedesc">Description</form:label>
       <form:input path="messagedesc" type="text" class="form-control"
        required="required" />
       <form:errors path="messagedesc" cssClass="text-warning" />
      </fieldset>

      <button type="submit" class="btn btn-success">Save</button>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</div>
</body>
</html>