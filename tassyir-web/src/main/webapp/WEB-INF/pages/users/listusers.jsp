<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> <spring:message code="webapplication.name" /> </title>
<link rel="stylesheet" href="<c:url value="/stylesheets/calendar.css"/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>"
	type="text/css" />
</head>
<body> 
<div id="container">
<h1>ListusersPage</h1>
<table>
<thead>
<tr>
	<td class="table-entete"><b>N°</b></td>
  	<td class="table-entete"><b><fmt:message key="login.username" /></b></td> 	
  	<td class="table-entete"><b><fmt:message key="EditElement" /></b></td>
	<td  class="table-entete"><b><fmt:message key="DetailsElement" /></b></td>
	<td class="table-entete"><b><fmt:message key="Enable" />/<fmt:message key="Disable" /></b></td>
	<td  class="table-entete"><b><fmt:message key="RemoveElement" /></b></td>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listusers}" var="user" varStatus="listeuserIndex">
  <tr>
	<c:if test="${user.username =='root'}">	
		<sec:authorize ifAnyGranted="ROLE_ROOT">
		 			<td><b>${listeuserIndex.index+1}</b></td>
					<td><b>${user.username}</b></td>
					<td><a href="editUser.do?id=${user.id}"><fmt:message key="EditElement" /></a></td>
					<td><a href="detailsUser.do?id=${user.id}"><fmt:message key="DetailsElement" /></a></td>
					<td></td>
					<td></td>
				
		</sec:authorize>	
	</c:if>
	<c:if test="${user.username !='root'}">
		<td><b>${listeuserIndex.index+1}</b></td>
		<td><b>${user.username}</b></td>
		<td><a href="editUser.do?id=${user.id}"><fmt:message key="EditElement" /></a></td>
		<td><a href="detailsUser.do?id=${user.id}"><fmt:message key="DetailsElement" /></a></td>
		<c:if test="${user.enabled}">
			<td><a href="activateUser.do?id=${user.id}"><fmt:message key="Disable" /></a></td>
		</c:if> 
		<c:if test="${!user.enabled}">
			<td><a href="activateUser.do?id=${user.id}"><fmt:message key="Enable" /></a></td>
		</c:if>
		<td><a href="removeUser.do?id=${user.id}"><fmt:message key="RemoveElement" /></a></td>	
	</c:if>
  </tr>
  </c:forEach>
  
  <tr>
  	<td><a href="createUser.do"><fmt:message key="NewElement" /></a></td>
  </tr>
  </tbody>
</table>
</div>
<div id="footer">
<a href="../">Home</a> |
<a href="mailto:benaissa.benarbia@nextep.net">contact</a> |</a> | &copy; 2010 Nextep
| Design by <a href="http://www.nextep.net"> www.nextep.net</a><br /></div>
</body>
</html>