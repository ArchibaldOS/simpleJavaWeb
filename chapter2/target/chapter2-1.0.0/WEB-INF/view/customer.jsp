<%--
  Created by IntelliJ IDEA.
  User: Kevin_coco
  Date: 6/4/2017
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户管理</title>
</head>
<body>

<h1>客户列表</h1>

<table>
    <tr>
        <th>客户名称</th>
        <th>联系人</th>
        <th>电话号码</th>
        <th>邮箱地址</th>
        <th>操作</th>
    </tr>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <th>${customer.name}</th>
            <th>${customer.contact}</th>
            <th>${customer.telephone}</th>
            <th>${customer.email}</th>
        </tr>
        <td>
            <a href="${BASE}/customer_edit?id=${customer.id}">编辑</a>
            <a href="${BASE}/customer_delete?id=${customer.id}">删除</a>
        </td>
    </c:forEach>
</table>
</body>

</html>
