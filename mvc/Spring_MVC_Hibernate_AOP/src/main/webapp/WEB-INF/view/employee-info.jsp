<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Employee info</h2>
<br>
<!-- вытягиваем из модели аттрибут employee -->
<form:form action="saveEmployee" modelAttribute="employee">
    <form:hidden path="id"/><!-- спрятанная форма, если в модели эмплои созданный дэфолтным конструктором, то id=0, а значит объект создается ,
    а когда айди засеттился значением, то он будем меняться благодаря методу hibernate saveOrUpdate() -->
    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Department <form:input path="department"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>