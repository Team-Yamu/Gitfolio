<%@ page import="com.gitfolio.oauth.Registration" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 20. 12. 20.
  Time: 오전 7:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Registration> registration = (List<Registration>) (request.getAttribute("registrations"));
    for (Registration item: registration)
    {
%>
        <div class="container">
            <a class="btn btn-block btn-social btn-<%=item.getRegistrationId()%>" href="<%=item.getUri()%>">
                <span class="fa fa-<%=item.getRegistrationId()%>"> Sign in with <%=item.getClientName()%></span>
            </a>
        </div>
<%
    }
%>

</body>
</html>
