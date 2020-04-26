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
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Photo</th>
            <th>Name</th>
            <th>E-mail</th>
            <th>Level</th>
            <th>Primary skill</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        <%--        <jsp:useBean id="participants" scope="request" type="java.util.List"/>--%>
        <c:forEach var="participant" items="${participants}">
            <tr>
                <td>${participant.id}</td>

                <td>
                    <c:choose>
                        <c:when test="${participant.userPhotoId == null}">
                            <img src="https://vectorified.com/images/default-image-icon-7.jpg"
                                 width="50px">
                        </c:when>
                        <c:otherwise>
                            <img src="/Conference/user-photo/download/${participant.userPhotoId}"
                                 width="50px">
                        </c:otherwise>
                    </c:choose>
                </td>
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
</div>

<%--<script src="${pageContext.request.contextPath}/js/userPhoto.js"></script>--%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

</body>
</html>
