<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html lang="en">
 
<jsp:include page="../fragments/headTag.jsp"/>




<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <h2>Users</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>
            <th style="width: 200px;">Login</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${selections}">
            <tr>
                <td>
                    <spring:url value="users/{userId}.html" var="userUrl">
                        <spring:param name="userId" value="${user.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(userUrl)}"><c:out value="${user.firstName} ${user.lastName}"/></a>
                </td>
                <td><c:out value="${user.login}"/></td>
            </tr>
        </c:forEach>
    </table>
    <jsp:include page="../fragments/footer.jsp"/>

</div>
</body>






<body>




<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <h2>Users</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>
            <th style="width: 200px;">Login</th>
            <th>Password</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${selections}">
            <tr>
                <td>
                    <spring:url value="users/{userId}.html" var="userUrl">
                        <spring:param name="userId" value="${user.id}"/>
                    </spring:url>
                    <a href="${userUrl}"><c:out value="${user.firstName} ${user.lastName}"/></a>
                    
                     <%-- <a href="${fn:escapeXml(userUrl)}"><c:out value="${user.firstName} ${user.lastName}"/></a> --%>
                </td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.password}"/></td>
                 <td><c:out value="${user.connected}"/></td> 
                  <td><c:out value="${user.locked}"/></td>
                   <td><c:out value="${user.isAdmin}"/></td>
              <%--   <td>
                    <c:forEach var="pet" items="${owner.pets}">
                        <c:out value="${pet.name}"/>
                    </c:forEach>
                </td> --%>
            </tr>
        </c:forEach>
    </table>
    <jsp:include page="../fragments/footer.jsp"/>

</div>
</body>

</html>