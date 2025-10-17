<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Doctor</title>
</head>
<body>
    <h2>Add New Doctor</h2>
    <% String msg = (String)session.getAttribute("sucMsg"); 
       if(msg != null) { %>
        <p style="color: green"><%=msg%></p>
        <% session.removeAttribute("sucMsg"); }
       msg = (String)session.getAttribute("errorMsg");
       if(msg != null) { %>
        <p style="color: red"><%=msg%></p>
        <% session.removeAttribute("errorMsg"); }
    %>
    <form action="<%=request.getContextPath()%>/addDoctor" method="post">
        <label>Full Name:</label>
        <input type="text" name="fullName" required><br>
        <label>Date of Birth:</label>
        <input type="date" name="dob" required><br>
        <label>Qualification:</label>
        <input type="text" name="qualification" required><br>
        <label>Specialist:</label>
        <input type="text" name="specialist" required><br>
        <label>Email:</label>
        <input type="email" name="email" required><br>
        <label>Mobile No.:</label>
        <input type="text" name="mobno" required><br>
        <label>Password:</label>
        <input type="password" name="password" required><br>
        <input type="submit" value="Add Doctor">
    </form>
</body>
</html>
