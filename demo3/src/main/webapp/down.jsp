<%--
  Created by IntelliJ IDEA.
  User: hyj98
  Date: 2022-11-22
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

      <h1>
        预览和提供下载: ${file_path}
      </h1>
      <%--
          域名 - ip: img_server - 127.0.0.1
      --%>
      <img src="http://img_server:80/${file_path}" />

        <button onclick="location.href='${pageContext.request.contextPath}/down2?file=${file_path}'">
            下载
        </button>

</body>
</html>
