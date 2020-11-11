<%--
  Created by IntelliJ IDEA.
  User: waffi
  Date: 10.11.2020
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Models.Watch" %>
<%@ page import="DAO.interfaces.WatchDAO" %>
<%@ page import="DAO.implementation.WatchDAOImplementation" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h5><a href="addWatchFrom.jsp">Add</a></h5>
    <h5><a href="deleteWatchForm.jsp">Delete</a></h5>
    <h5><a href="WatchListALL.jsp">Show</a></h5>
    <a style="float: right" class="active" href="../../Main.jsp">Back</a>
</div>
<table class="content-table">
    <thead>
    <!--//id, nameWatch, typeWatch, price, count, manufacturer,country;-->
    <tr>
        <th>ID</th>
        <th>nameWatch</th>
        <th>typeWatch</th>
        <th>price</th>
        <th>count</th>
        <th>manufacturer</th>
        <th>country</th>
    </tr>
    </thead>
    <tbody>
    <% WatchDAO manufacturerDAO = new WatchDAOImplementation();
        List<Watch> watches = manufacturerDAO.selectWatch("mechanical");
        for (Watch watch: watches) { %>
    <tr>
        <td><%=watch.getId()%></td>
        <td><%=watch.getNameWatch()%></td>
        <td><%=watch.getTypeWatch()%></td>
        <td><%=watch.getPrice()%></td>
        <td><%=watch.getCount()%></td>
        <td><%=watch.getManufacturer()%></td>
        <td><%=watch.getCountry()%></td>

    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
