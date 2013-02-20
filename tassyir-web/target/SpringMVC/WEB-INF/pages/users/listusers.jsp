<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> <spring:message code="webapplication.name" /> </title>
</head>
<body> 
<div id="container">
<h1><spring:message code="webapplication.userlist" /></h1>
<table>
<thead>
<tr>
	<td class="table-entete"><b><spring:message code="num" /></b></td>
  	<td class="table-entete"><b><spring:message code="login.username" /></b></td>
  	<td class="table-entete"><b><spring:message code="user.editElement" /></b></td> 	
  	<td class="table-entete"><b><spring:message code="user.DetailsElement" /></b></td> 	
  	<td class="table-entete"><b><spring:message code="user.enable-disable" /></b></td>
  	<td class="table-entete"><b><spring:message code="user.removeElement" /></b></td> 	
  	 	
  </tr>
  </thead>
  <tbody>
  <%--
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
  --%>
  <tr>
  	<td><a href="createUser.do"><spring:message code="login.newelement" /></a></td>
  </tr>
  </tbody>
</table>
</div>
</body>
</html>