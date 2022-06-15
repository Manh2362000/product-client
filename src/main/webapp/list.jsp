<%@ page import="java.util.List" %>
<%@ page import="com.example.productclient.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: manh2
  Date: 6/15/2022
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%
    List<Product> liste = (List<Product>)request.getAttribute("l");
%>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<body>

<div class="w3-container">
    <h2>Sản phẩm</h2>
    <a href="/create"><p><button class="w3-button w3-block w3-teal">Thêm mới</button></p></a>
    <table class="w3-table-all">
        <thead>
        <tr class="w3-red">
            <th>Tên</th>
            <th>Luong</th>
        </tr>
        </thead>
        <%
            for (int i = 0; i < liste.size(); i++) {
                Product obj = liste.get(i);
        %>

        <tr>
            <td><%=obj.getName()%></td>
            <td><%=obj.getPrice()%></td>
            <td><%=obj.getQuantity()%></td>
            <td><a href="/detail?id=<%=obj.getId()%>">Chi tiết</a></td>
            <td><a href="/edit?id=<%=obj.getId()%>">Sửa</a></td>
            <td><a href="/delete?id=<%=obj.getId()%>" class="btndelete">Xóa</a></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>