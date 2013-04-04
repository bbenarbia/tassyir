<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
		
<form:form method="post" action="save.html"
        modelAttribute="uploadForm" enctype="multipart/form-data">
 
 <div class="CSS_Table_Example" style="width: 600px; height: 150px;">
    <table style="width: 600px; height: 150px; " >
     	<tr >
            <td style="width: 350px;">Files list</td>
        </tr>
        
        <tr>
            <td style="width: 350px;"><input name="files[0]" type="file" /></td>
        </tr>
        <tr>
            <td style="width: 350px;"><input name="files[1]" type="file" /></td>
        </tr>
        <tr>
            <td style="width: 350px;"><input name="files[2]" type="file" /></td>
        </tr>
        <tr>
            <td style="width: 350px;"><input name="files[3]" type="file" /></td>
        </tr>
        <tr>
            <td style="width: 350px;"><input name="files[4]" type="file" /></td>
        </tr>
        <tr>
           <td><input type="submit" value="Upload" /></td>
        </tr>
    </table>
    </div>
</form:form>
</body>
</html>