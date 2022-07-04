<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Spring Mvc</title>
</head>
<body>
<h1>welcome to NewsPaper Application</h1>
<hr>
<form action="save.do">
<pre>
Name=       :<input type="text" name="newspaperName">

PRICE=      :<input type="text" name="price">

LANGUAGE=   :<input type="text" name="language">

NoOFPAGES=  :<input type="text" name="noofPages">

<input type="submit" value="save">
</pre>
</form>

<form action="searchNewspaper.do">
<label>searchNewspaperName</label>:
<input type="text" name="searchNewspaper">
<input type="submit" value="searchNewspaper">
</form>

<form action="searchLanguage.do">
<label>searchLanguageName:</label>:
<input type="text" name="searchLanguage">
<input type="submit" value="searchLanguage">
</form>
<br> 

<a href="getAllNewspaper.do">viewAllNewspaper</a><br>

 
<form action="deleteNewspaper.do">
<label>deleteNewspaperName:</label>:
<input type="text" name="newspaperName">
<input type="submit" value="deleteNewspaper">
</form>
<br> 

<form action="update.do">
<label>updateNewspaper:</label>:
<input type="text" name="newspaperName">
<input type="text" name="price">
<input type="text" name="language">
<input type="text" name="noofPages">
<input type="submit" value="save">
</form>
<br> 


</body>
</html>