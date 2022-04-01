<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>

<h2>ALL EMPLOYEES</h2>
<br><br>

<table>

    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operation</th>
    </tr>

    <c:forEach var="tmp" items="${allEmpls}">

        <c:url var="updateButton" value="updateInfo">
            <c:param name="empId" value="${tmp.id}"></c:param>
        </c:url>

        <c:url var="deleteButton" value="deleteInfo">
            <c:param name="empId" value="${tmp.id}"></c:param>
        </c:url>

        <tr>
            <td>${tmp.name} </td>
            <td>${tmp.surname}</td>
            <td>${tmp.department} </td>
            <td>${tmp.salary}</td>
            <td><input type ="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>
                <input type ="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>

    </c:forEach>


</table>

<br><br>
<input type="button" value="ADD"
       onclick="window.location.href = 'addNewEmployee'"/>

</body>
</html>
