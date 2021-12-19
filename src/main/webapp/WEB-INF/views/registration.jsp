<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/tiles/templates/loader.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body class="landing_bg">

    <div class="container">
<div class="container_register">
        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading txt_log_color">Create your account</h2>
            <spring:bind path="username">
                <div class="form-group txt_log_color ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>
            
<%--                <spring:bind path="firstname"> --%>
<%--                 <div class="form-group txt_log_color ${status.error ? 'has-error' : ''}"> --%>
<%--                     <form:input type="text" path="firstname" class="form-control" placeholder="Full Name" --%>
<%--                                 autofocus="true"></form:input> --%>
<%--                     <form:errors path="firstname"></form:errors> --%>
<!--                 </div> -->
<%--             </spring:bind> --%>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Confirm your password"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            <a class="btn btn-lg btn-primary btn-block" href="/e_library/login" >Back to Login</a>
        </form:form>
</div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
