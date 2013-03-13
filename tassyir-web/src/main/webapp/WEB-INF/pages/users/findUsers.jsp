<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">


<body>
<div class="container">

    <h2>Find Users</h2>

    <spring:url value="/users.html" var="formUrl"/>
    <form:form modelAttribute="user" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-user-form">
        <fieldset>
            <div class="control-group" id="lastName">
                <label class="control-label">Last name </label>
                <form:input path="lastName" size="30" maxlength="80"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
            <div class="form-actions">
                <button type="submit">Find User</button>
            </div>
        </fieldset>
    </form:form>

    <br/>
    <a href='<spring:url value="/users/new" htmlEscape="true"/>'>Add User</a>


</div>
</body>

</html>
