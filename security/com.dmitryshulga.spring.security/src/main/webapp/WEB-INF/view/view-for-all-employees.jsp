<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>
<h3>Information for all Employees</h3>
<br><br>
<!-- с помощью этого тега закрываем от всех его содержимое и открываем только определенным ролям-->
<security:authorize access="hasRole('HR')">
    <input type="button" value="salary" onclick="window.location.href='hr_info'">
    Only for HR staff
</security:authorize>
<br><br>
<security:authorize access="hasRole('MANAGER')">
    <input type="button" value="performance" onclick="window.location.href='manager_info'">
    Only for managers
</security:authorize>
</body>
</html>