<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h3>登录界面</h3>

<form action="${pageContext.request.contextPath}/login.action"
      method="post">
    <%--name属性对应User对象中的属性名--%>
    用户名：<input type="text" name="name"><br>
    密码：<input type="password" name="password"><br>

    <input type="submit" value="登录">
    <input type="reset" value="重置">

</form>
<%--显示验证错误信息--%>
<s:actionerror/>
</body>
</html>
