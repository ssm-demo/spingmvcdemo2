<%--
  Created by IntelliJ IDEA.
  User: berealzy
  Date: 2019/8/14
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>input page for sth to say to somebody</title>
</head>
<body>

<form if="form" action="./getSth">
    role: <input name="role" id="role" value=""/><br/>
    sth: <input name="sth" id="sth" value=""/>
    <br/>
    <input type="submit" value="say"/>
</form>
</body>
</html>
