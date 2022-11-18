<%--
  Created by IntelliJ IDEA.
  User: hyj98
  Date: 2022-11-18
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/user3" method="post">
        <p>
            账号:<input type="text" name="username" value="${username}" />
        </p>
        <p>
            密码:<input type="password" name="password" value="${password}" />
        </p>
        <p>
            <input type="submit" value="登录"/>
        </p>
    </form>

</body>
</html>
