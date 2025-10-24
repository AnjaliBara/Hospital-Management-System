<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<%@ include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card{
    box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
}
</style>
</head>
<body>
     <%@include file="navbar.jsp" %>
     <c:if test="${empty adminObj }">
     <c:redirect url="../admin_login.jsp"></c:redirect>
     </c:if>
     <div class="container p-5">
             <p class="text-center fs-3">Admin Dashboard</p>
             <c:if test="${not empty errorMsg}">
                  <p class="fs-3 text-center text-danger">${errorMsg}</p> 
                  <c:remove var="errorMsg" scope="session" />
             </c:if>
             <c:if test="${not empty succMsg}">
                   <div class="fs-3 text-center text-success" role="alert">${succMsg}</div> 
                   <c:remove var="succMsg" scope="session"/>
             </c:if>
    <div class="row">
        <div class="col-md-4">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="fas fa-user-md fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Doctor <br>5
                    </p>
                </div> 
            </div>
        </div>
        <div class="col-md-4">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="fas fa-user-circle fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        User <br>43
                    </p>
                </div> 
            </div>
        </div>
        <div class="col-md-4">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="fas fa-calendar-check fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Total Appointment <br>453
                    </p>
                </div> 
            </div>
        </div>

        <div class="col-md-4 mt-2">
            <div class="card paint-card" data-bs-toggle="modal" data-bs-target="#exampleModal">
                <div class="card-body text-center text-success">
                    <i class="fas fa-calendar-check fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Specialist <br>34
                    </p>
                </div> 
            </div>
        </div>  
    </div>
</div>
</body>
</html>
