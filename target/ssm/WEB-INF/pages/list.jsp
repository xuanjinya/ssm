<%--
   Author: Yaking
   Date: 2019-07-19 0:28
   Describe: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>查询所有账户信息</h3>
<c:forEach items="${list}" var="account">
    ${account.name}
</c:forEach>

</body>
</html>
