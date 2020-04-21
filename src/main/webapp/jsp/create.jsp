<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<body>
<jsp:include page="header.jsp"></jsp:include>

<%--<jsp:useBean id="participant" scope="request" type="javax.xml.stream.util.StreamReaderDelegate"/>--%>

<div class="container">
    <form action="${pageContext.request.contextPath}/create" method="POST">

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${participant.name}">
        </div>
        <div class="form-group">
            <label for="email">E-mail:</label>
            <input type="email" class="form-control" id="email" name="email" value="${participant.email}">
        </div>
        <div class="form-group">
            <label for="level">Level:</label>
            <select class="form-control" id="level" name="level" value="${participant.level}">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </div>
        <div class="form-group">
            <label for="primarySkill">Primary skill:</label>
            <input type="text" class="form-control" id="primarySkill" name="primarySkill"
                   value="${participant.primarySkill}">
        </div>
        <button type="submit" class="btn btn-default">Create</button>
    </form>

</div>




</body>
<head>
    <title>Conference</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
</html>

