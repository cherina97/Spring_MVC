<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <title>Info</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="card" style="width: 18rem;">
    <c:choose>
        <c:when test="${participant.userPhotoId == null}">
            <img src="https://vectorified.com/images/default-image-icon-7.jpg"
                 width="50px">
        </c:when>
        <c:otherwise>
            <img class="card-img-top" src="/Conference/user-photo/download/${photoId}"
                 width="50px" alt="Card image cap">
        </c:otherwise>
    </c:choose>

    <div class="card-body">
        <h5 class="card-title">Participant info</h5>
        <p class="card-text">Some information about participant of conference... </p>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">${name}</li>
        <li class="list-group-item">${email}</li>
        <li class="list-group-item">${level}</li>
        <li class="list-group-item">${primarySkill}</li>
    </ul>
    <div class="card-body">
<%--        <a href="update?id=${id}" class="card-link">Edit</a>--%>
        <a href="${pageContext.request.contextPath}/" class="card-link">Back to Home</a>
    </div>
</div>
</body>
</html>

