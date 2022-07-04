<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Newspaper Details</title>
</head>
<body>
<h1>Newspaper Details Readed successfully,,,,,,,,,,,</h1>
<hr>
<div>

<c:forEach items="${ListOfNewspaper}" var="newspaperObj">
<tr>
<td>${newspaperObj.newspaperName}<td><br>

<td>${newspaperObj.price}<td><br>

<td>${newspaperObj.language}<td><br>

<td>${newspaperObj.noofPages}<td>
<hr>
</tr>
</c:forEach>


</div>
</body>
</html>