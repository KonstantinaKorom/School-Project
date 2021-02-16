<%-- 
    Document   : trainerForm
    Created on : Feb 16, 2021, 5:23:35 AM
    Author     : Koko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "t" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainer Form</title>
    </head>
    <body>
        <h1>Create new Trainer</h1>
    <t:if test="${trainer == null}">
        <t:url value="/trainer/create" var="link" ></t:url>
    </t:if>
    <t:if test="${trainer != null}">
        <t:url value="/trainer/update" var="link"></t:url>
    </t:if>

    <form:form action="${link}" method="POST" modelAttribute ="trainer">
        <form:hidden path="id"></form:hidden>
        <br>
        <label for="tfirstname">Firstname:</label>
        <form:input id="tfirstname" path="tfirstname"/>
        <form:errors path="tfirstname"/>
        <br>
        <label for="tlastname">Lastname:</label>
        <form:input id="tlastname" path="tlastname"/>
        <form:errors path="tlastname"/>
        <br>
        <label for="tsubject">Subject:</label>
        <form:select id="tsubject" path="tsubject" multiple="multiple">
            <t:forEach items="${listOfSubjects}" var="subject">
                <form:option value="${subject}">${subject}</form:option>
            </t:forEach>
        </form:select>   
        <br>
        <input type="submit" value="Submit"/>
    </form:form>

</body>
</html>
