<%--
  Created by IntelliJ IDEA.
  User: hyj98
  Date: 2022-11-22
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data" >
            <p>
                账号: <input type="text" name="account" />
            </p>
            <p>
                照片: <input type="file" name="myPic" />
            </p>
            <p>
                <input type="submit"/>
            </p>
        </form>

</body>
</html>
