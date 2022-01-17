<!DOCTYPE html>
<html>
<body>
<h2>Dear employee, please enter your details</h2>
<br>
<br>
<form action="${pageContext.request.contextPath}/employee/showDetails" method="get">
    <input type="text" name="employeeName" placeholder="Write your name">
    <input type="submit">
</form>
</body>
</html>