<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Dear employee, please enter your details</h2>
<br>
<br>
<!--form:form форма spring mvc, которая является контейнером для других форм -->
<!-- action = что будет открываться, когда будут нажимать на кнопку сабмит,
 modelAttribute = с каким аттрибутом модели (ранее поместили с метода askEmployeeDetails()) будем работать в этой форме
 каким методом уйдет этот запрос -->
<form:form action="showDetails" modelAttribute="employee" method="post">
    Name <form:input path="name"/><!-- при открытии страницы сработает геттер с employee, а при закрытии сеттер -->
    <form:errors path="name"/><!--обеспечивается контроль на ошибки, прописанные в классе Employee-->
    <br><br>
    Surname <form:input path="surname"/>
    <form:errors path="surname"/>
    <br><br>
    Salary <form:input path="salary"/>
    <form:errors path="salary"/>
    <br><br>
    Department <form:select path="department">
    <!--можно захардкодить элементы в список-->
    <%--    <form:option value="Information Technology" label="IT"/>--%>
    <%--    <form:option value="Human Resources" label="HR"/>--%>
    <%--    <form:option value="Sales" label="Sales"/>--%>
    <!-- а можно вытянуть с map, который уже существует в объекте employee-->
    <form:options items="${employee.departments}"/>
</form:select>
    <br><br>
    Which car do you want?
    <!-- можно захардкодить создание каждого радиобатона -->
    <%--    BMW <form:radiobutton path="carBrand" value="BMW"/>--%>
    <%--    MB <form:radiobutton path="carBrand" value="Mercedes-Benz"/>--%>
    <%--    AUDI <form:radiobutton path="carBrand" value="Audi"/>--%>
    <!--а можно вытянуть с mal, который уже существует в объекте employee-->
    <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
    <br><br>
    Foreign language?
    <!-- та же ситуация с чекбоксами-->
    <%--    EN <form:checkbox path="languages" value="English"/>--%>
    <%--    DE <form:checkbox path="languages" value="Deutsch"/>--%>
    <%--    FR <form:checkbox path="languages" value="French"/>--%>
    <form:checkboxes path="languages" items="${employee.languageList}"/>
    <br><br>
    Phone number <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br><br>
    Email: <form:input path="email"/>
    <form:errors path="email"/>
    <br><br>
    <!--кнопка, которая перенаправит на action-->
    <input type="submit" name="OK">
</form:form>
</body>
</html>