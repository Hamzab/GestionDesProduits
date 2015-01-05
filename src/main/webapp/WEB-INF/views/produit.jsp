<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produit page</title>
<style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Ajouter un produit
</h1>

<c:url var="addAction" value="/produit/add" ></c:url>
 
<form:form action="${addAction}" commandName="produit">
<table class="tg">
    <c:if test="${!empty produit.name}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="name">
                <spring:message text="Nom"/>
            </form:label>
        </td>
        <td>
            <form:input path="name" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="price">
                <spring:message text="Prix"/>
            </form:label>
        </td>
        <td>
            <form:input path="price" />
        </td>
    </tr>
        <tr>
        <td>
            <form:label path="quantity">
                <spring:message text="Quantité"/>
            </form:label>
        </td>
        <td>
            <form:input path="quantity" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty produit.name}">
                <input type="submit"
                    value="<spring:message text="Modifier Produit"/>" />
            </c:if>
            <c:if test="${empty produit.name}">
                <input type="submit"
                    value="<spring:message text="Ajouter Produit"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Liste de produits</h3>
<c:if test="${!empty lesProduits}">
    <table class="tg">
    <tr>
        <th width="80">Produit ID</th>
        <th width="120">Nom</th>
        <th width="120">Prix</th>
         <th width="120">Quantité</th>
        <th width="60">Modifier</th>
        <th width="60">Supprimer</th>
    </tr>
    <c:forEach items="${lesProduits}" var="produit">
        <tr>
            <td>${produit.id}</td>
            <td>${produit.name}</td>
            <td>${produit.price}</td>
            <td>${produit.quantity}</td>
            <td><a href="<c:url value='/edit/${produit.id}' />" >Modifier</a></td>
            <td><a href="<c:url value='/remove/${produit.id}' />" >Supprimer</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>