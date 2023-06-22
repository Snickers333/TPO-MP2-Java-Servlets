<%@ page import="com.example.servletytpo.Car" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Results</title>
</head>
<body>
<h1>Search Results</h1>
<table>
    <tr>
        <th>Type</th>
        <th>Brand</th>
        <th>Model</th>
        <th>Year</th>
        <th>Fuel Consumption</th>
    </tr>
    <% for (Car car : (List<Car>) request.getAttribute("cars")) { %>
    <tr>
        <td><%= car.getBrand() %></td>
        <td><%= car.getModel() %></td>
        <td><%= car.getType() %></td>
        <td><%= car.getYear() %></td>
        <td><%= car.getFuelConsumption() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>