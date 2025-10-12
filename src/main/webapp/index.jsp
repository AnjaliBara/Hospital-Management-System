<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital Management</title>
<%@ include file="component/allcss.jsp" %>

<style>

.carousel-item:after {
  content: "";
  display: block;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0,0,0,0.1);
}


.carousel-caption {
  top: 70%;
}
.carousel {
  margin-top: 60px; 
}


.carousel-item img {
  width: 100%;
  height: auto; 
  max-height: 90vh; 
  object-fit: contain; 
  background-color: #f8f9fa; 
}
@media (max-width: 992px) {
  .carousel-item img {
    height: 70vh;
  }
}

@media (max-width: 768px) {
  .carousel-item img {
    height: 60vh;
  }
}

@media (max-width: 576px) {
  .carousel-item img {
    height: 50vh;
  }
}

/* Card shadow style */
.paint-card {
  box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
  border-radius: 10px;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

/* Hover effect for cards */
.paint-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 0 15px rgba(0,0,0,0.4);
}


</style>

</head>
<body>
<%@ include file="component/navbar.jsp" %>


<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>

  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="img/img1.jpeg" class="d-block w-100" alt="Slide 1">
    </div>
    <div class="carousel-item">
      <img src="img/img2.jpeg" class="d-block w-100" alt="Slide 2">
    </div>
    <div class="carousel-item">
      <img src="img/img3.gif" class="d-block w-100" alt="Slide 3">
    </div>
  </div>

  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<!-- Key Features Section -->
<div class="container p-5">
  <p class="text-center fs-2 fw-bold mb-4">Key Features of our Hospital</p>

  <div class="row g-4">
  
    <div class="col-md-6 col-lg-6">
      <div class="card paint-card p-3">
        <div class="card-body">
          <p class="fs-5 fw-bold">100% Safety</p>
         
        </div>
      </div>
    </div>
    
    <div class="col-md-6 col-lg-6">
      <div class="card paint-card p-3">
        <div class="card-body">
          <p class="fs-5 fw-bold">Clean Environment</p>
          
        </div>
      </div>
    </div>

    <div class="col-md-6 col-lg-6">
      <div class="card paint-card p-3">
        <div class="card-body">
          <p class="fs-5 fw-bold">Friendly Doctors</p>
         
        </div>
      </div>
    </div>

    <div class="col-md-6 col-lg-6">
      <div class="card paint-card p-3">
        <div class="card-body">
          <p class="fs-5 fw-bold">Medical Research</p>
      
        </div>
      </div>
    </div>

  </div>
</div>

<hr>
<div class="container p-2">
  <p class="text-center fs-2">Our Team</p>
  <div class="row">
    <div class="col-md-3">
      <div class="card paint-card">
         <div class="card-body text -center">
         <img src="img/doc1.jpeg " width="250px"  height="300px">     
         <p class="fw -bold fs-5">Dr.Samuel Paul</p>
         <p class="fs-7">(CEO & Chairman)</p>
         </div>
       </div>
     </div>
<div class="col-md-3">
      <div class="card paint-card">
         <div class="card-body text-center">
         <img src="img/doc2.jpeg " width="250px"  height="300px">     
         <p class="fw -bold fs-5">Dr.Rajeev Sharma    </p>
         <p class="fs-7">(Chief Doctor) </p>
         </div>
       </div>
     </div> 
 <div class="col-md-3">
      <div class="card paint-card">
         <div class="card-body text-center">
         <img src="img/doc3.jpeg" width="250px"  height="300px">     
         <p class="fw -bold fs-5">Dr.Siya Arora    </p>
         <p class="fs-7">(Chief Doctor) </p>
         </div>
       </div>
     </div> 
 <div class="col-md-3">
      <div class="card paint-card">
         <div class="card-body text-center">
         <img src="img/doc4.jpeg" width="250px"  height="300px">     
         <p class="fw -bold fs-5">Dr.Nikita Mathur     </p>
         <p class="fs-7">(Chief Doctor) </p>
         </div>
       </div>
     </div> 
  </div>
</div>
     
  <%@include file="component/footer.jsp" %>
  


</body>
</html>
