<%@page import="com.entity.Appointment"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Doctor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Appointment Details</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
    box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
.status-pending {
    color: #856404;
    background-color: #fff3cd;
    padding: 5px 10px;
    border-radius: 4px;
    font-weight: bold;
}
.status-completed {
    color: #155724;
    background-color: #d4edda;
    padding: 5px 10px;
    border-radius: 4px;
    font-weight: bold;
}
.status-cancelled {
    color: #721c24;
    background-color: #f8d7da;
    padding: 5px 10px;
    border-radius: 4px;
    font-weight: bold;
}
</style>
</head>
<body>
    <%@include file="navbar.jsp"%>
    
    <div class="container-fluid p-3">
        <div class="row">
            <div class="col-md-12">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="text-center fs-3">Patient Appointment Details</p>
                        <p class="text-center text-muted">All patients who booked appointments through user login</p>
                        
                        <%-- Success and Error Messages --%>
                        <c:if test="${not empty errorMsg}">
                            <p class="fs-3 text-center text-danger">${errorMsg}</p>
                            <c:remove var="errorMsg" scope="session" />
                        </c:if>
                        <c:if test="${not empty succMsg}">
                            <div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
                            <c:remove var="succMsg" scope="session" />
                        </c:if>

                        <table class="table table-striped table-hover">
                            <thead class="table-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Patient Name</th>
                                    <th scope="col">Gender</th>
                                    <th scope="col">Age</th>
                                    <th scope="col">Appointment Date</th>
                                    <th scope="col">Doctor</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Mobile No</th>
                                    <th scope="col">Diseases</th>
                                    <th scope="col">Address</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
                                DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
                                List<Appointment> list = dao.getAllAppointment();
                                
                                if(list != null && !list.isEmpty()) {
                                    int srNo = 1;
                                    for (Appointment ap: list) {
                                        Doctor d = dao2.getDoctorById(ap.getDoctorId());
                                        String statusClass = "";
                                        if("Completed".equals(ap.getStatus())) {
                                            statusClass = "status-completed";
                                        } else if("Cancelled".equals(ap.getStatus())) {
                                            statusClass = "status-cancelled";
                                        } else {
                                            statusClass = "status-pending";
                                        }
                                %>
                                <tr>
                                    <td><%=srNo++%></td>
                                    <td><strong><%=ap.getFullName()%></strong></td>
                                    <td><%=ap.getGender()%></td>
                                    <td><%=ap.getAge()%></td>
                                    <td><%=ap.getAppointDate()%></td>
                                    <!-- CORRECTED: Using getSpecialist() instead of getSpecialization() -->
                                    <td>
                                        <% if(d != null) { %>
                                            Dr. <%=d.getFullName()%> (<%=d.getSpecialist()%>)
                                        <% } else { %>
                                            <span class="text-danger">N/A</span>
                                        <% } %>
                                    </td>
                                    <td><%=ap.getEmail()%></td>
                                    <td><%=ap.getPhNo()%></td>
                                    <td><%=ap.getDiseases()%></td>
                                    <td><%=ap.getAddress()%></td>
                                    <td>
                                        <span class="<%=statusClass%>">
                                            <%=ap.getStatus()%>
                                        </span>
                                    </td>
                                    <td>
                                        <div class="btn-group" role="group">
                                            <% if("Pending".equals(ap.getStatus())) { %>
                                                <a href="<%=request.getContextPath()%>/updateAppointmentStatus?id=<%=ap.getId()%>&status=Completed" 
                                                    class="btn btn-sm btn-success" 
                                                    title="Mark as Completed"
                                                    onclick="return confirm('Mark this appointment as completed?')">
                                                    <i class="fas fa-check"></i>
                                                </a>

                                                <a href="<%=request.getContextPath()%>/updateAppointmentStatus?id=<%=ap.getId()%>&status=Cancelled" 
                                                    class="btn btn-sm btn-danger" 
                                                    title="Cancel Appointment"
                                                    onclick="return confirm('Cancel this appointment?')">
                                                    <i class="fas fa-times"></i>
                                                </a>
                                            <% } else if("Completed".equals(ap.getStatus())) { %>
                                                <span class="badge bg-success">Completed</span>
                                            <% } else { %>
                                                <span class="badge bg-danger">Cancelled</span>
                                            <% } %>
                                        </div>
                                    </td>
                                </tr>
                                <%
                                    }
                                } else {
                                %>
                                <tr>
                                    <td colspan="12" class="text-center text-danger py-4">
                                        <i class="fas fa-exclamation-circle fa-2x mb-3"></i><br>
                                        No patient appointments found.<br>
                                        <small class="text-muted">When users book appointments, they will appear here.</small>
                                    </td>
                                </tr>
                                <%
                                }
                                %>
                            </tbody>
                        </table>
                        
                        <%-- Summary Card --%>
                        <%
                        if(list != null && !list.isEmpty()) {
                            int total = list.size();
                            long pending = list.stream().filter(ap -> "Pending".equals(ap.getStatus())).count();
                            long completed = list.stream().filter(ap -> "Completed".equals(ap.getStatus())).count();
                            long cancelled = list.stream().filter(ap -> "Cancelled".equals(ap.getStatus())).count();
                        %>
                        <div class="row mt-4">
                            <div class="col-md-3">
                                <div class="card bg-primary text-white">
                                    <div class="card-body text-center">
                                        <h4><%=total%></h4>
                                        <p>Total Appointments</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card bg-warning text-white">
                                    <div class="card-body text-center">
                                        <h4><%=pending%></h4>
                                        <p>Pending</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card bg-success text-white">
                                    <div class="card-body text-center">
                                        <h4><%=completed%></h4>
                                        <p>Completed</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card bg-danger text-white">
                                    <div class="card-body text-center">
                                        <h4><%=cancelled%></h4>
                                        <p>Cancelled</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%
                        }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>