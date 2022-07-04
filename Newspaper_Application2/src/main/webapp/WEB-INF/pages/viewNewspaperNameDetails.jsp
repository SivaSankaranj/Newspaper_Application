<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${ErrorMessage}</h1>
<h1>the required newspaper details as followed below</h1>
<hr>

<div>
<c:forEach items="${ListofNewspaper}" var="newspaperObj">
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
