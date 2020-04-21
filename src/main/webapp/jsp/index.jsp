<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <title>Conference</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header navbar-brand">Home page</div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/Conference/">All participants</a></li>
            <li><a href="/Conference/addNew">New Participant</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <c:choose>
        <c:when test="${mode == 'VIEW'}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>E-mail</th>
                    <th>Level</th>
                    <th>Primary skill</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="participant" items="${participants}">
                    <tr>
                        <td>${participant.id}</td>
                        <td>${participant.name}</td>
                        <td>${participant.email}</td>
                        <td>${participant.level}</td>
                        <td>${participant.primarySkill}</td>
                        <td><a href="update?id=${participant.id}">edit</a></td>
                        <td><a href="delete?id=${participant.id}">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:when test="${mode == 'EDIT' || mode == 'CREATE'}">
            <form action="${mode == 'EDIT' ? "/Conference/save": "/Conference/create"}" method="POST">

                <c:choose>
                    <c:when test="${mode == 'EDIT'}">
                        <input type="hidden" value="${participant.id}" class="form-control" id="id" name="id">
                    </c:when>
                </c:choose>

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
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </c:when>
    </c:choose>
</div>
</body>

</html>