<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<%@ include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card{
    box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
    margin-bottom: 20px;
    height: 100%;
}
.card-body {
    padding: 2rem 1rem;
}
</style>
</head>
<body>
<%@include file="../component/navbar.jsp" %>
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
    
    <!-- SINGLE ROW CONTAINING ALL 4 CARDS -->
    <div class="row">
        <!-- Doctor Card -->
        <div class="col-md-3">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="fas fa-user-md fa-3x mb-3"></i>
                    <p class="fs-4 text-center">
                        Doctor <br><strong>5</strong>
                    </p>
                </div> 
            </div>
        </div>

        <!-- User Card -->
        <div class="col-md-3">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="fas fa-user-circle fa-3x mb-3"></i>
                    <p class="fs-4 text-center">
                        User <br><strong>43</strong>
                    </p>
                </div> 
            </div>
        </div>

        <!-- Appointment Card -->
        <div class="col-md-3">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="fas fa-calendar-check fa-3x mb-3"></i>
                    <p class="fs-4 text-center">
                        Total Appointment <br><strong>453</strong>
                    </p>
                </div> 
            </div>
        </div>
        
        <!-- Specialist Card -->
        <div class="col-md-3">
            <div class="card paint-card" data-bs-toggle="modal" data-bs-target="#exampleModal">
                <div class="card-body text-center text-success">
                    <i class="fas fa-stethoscope fa-3x mb-3"></i>
                    <p class="fs-4 text-center">
                        Specialist <br><strong>34</strong>
                    </p>
                </div> 
            </div>
        </div>  
    </div>
    <!-- END OF SINGLE ROW -->
</div>
</body>
</html>