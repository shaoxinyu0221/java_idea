<%@ page import="com.demo.service.BrandService" %>
<%@ page import="com.demo.entity.Brand" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<Brand> brandList = BrandService.getBrandList();
        request.setAttribute("brandList",brandList);
    %>

    <table>
        <tr>
            <th>下标</th><th>编号</th><th>名称</th><th>价格</th>
        </tr>
        <c:forEach var="brand" items="${brandList}" varStatus="vs" >
            <c:choose>
                <c:when test="${vs.index % 2 == 0}">
                    <tr style="background-color: red">
                        <td>${vs.index}</td>
                        <td>${brand.id}</td>
                        <td>${brand.name}</td>
                        <td>${brand.price}</td>
                    </tr>
                </c:when>
                <c:when test="${vs.index % 2 != 0}">
                    <tr style="background-color: yellow">
                        <td>${vs.index}</td>
                        <td>${brand.id}</td>
                        <td>${brand.name}</td>
                        <td>${brand.price}</td>
                    </tr>
                </c:when>
            </c:choose>

        </c:forEach>

    </table>
</body>
</html>
