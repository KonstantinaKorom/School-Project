

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "t" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Trainer</h1>
        <p>
                ${message}
            </p>
        <table border="1">
            <thead>
            <tr>
                <th>Trainer id</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Subject</th>
                <th>Edit/Update</th>
                <th>Delete</th>
            </tr>  
            </thead>
            <t:forEach items="${listOfTrainers}" var="trainer">
                <tr>
                    <td>${trainer.id}</td>
                <td>${trainer.tfirstname}</td>
                <td>${trainer.tlastname}</td>
                <td>${trainer.tsubject}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/trainer/update/${trainer.id}">Edit/Update</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/trainer/delete?id=${trainer.id}">Delete</a>
                </td>
            </t:forEach>
                </tr>
                <a href="${pageContext.request.contextPath}/trainer/create">Create new Trainer</a>
        </table>
    </body>
</html>
