<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>All Employees</h2>
<br>
<table><!--создаем таблицу, в которой будут заголовки -->
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="emp" items="${allEmps}"> <!--с помощью джава фор ича перебираем всех работников из модели (лист allEmps)-->
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/><!--на каждой иттерации цикла в параметр заносится айди текущего элемента листа allEmps-->
        </c:url>
        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/><!--на каждой иттерации цикла в параметр заносится айди текущего элемента листа allEmps-->
        </c:url>
        <!-- когда будет клик на делит или апдейт вызвится request по url value и поместится в модель значение их параметра-->
        <tr><!--выводим каждый аттрибуты каждого жлемента листа-->
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td><input type="button" value="Update" onclick="window.location.href='${updateButton}'"><!--кнопка апдейт перенаправляет на ссылку updateButton-->
                <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"></td><!--кнопка делит перенаправляет на deleteButton-->
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add" onclick="window.location.href = 'addNewEmployee'">
</body>
</html>