<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<html>
	<head>
	<base href="${pageContext.request.contextPath}/user/">
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="Residency theme">
		<meta name="keywords" content="Residency,sale,buy,rent,pg,house,villa,apartment">
		<meta name="author" content="Fortune Creations">
		<meta name="viewport" content="width=device-width">
		
		<title>All Properties</title>
		
		<link rel="stylesheet" href="css/font-awesome.min.css">		
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>	
		<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />	
		
		<script src="js/jquery-2.1.4.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/slider.js"></script>
		<script src="js/custom.js"></script>	
		<script src="js/svg-inlinesvg.js"></script>	
	</head>
	<body>
<header>
			<%
		
		if(session.getAttribute("type")==null){
			%>
			<%@include file="header.jsp" %>
			<%} 
		else if(session.getAttribute("type")!= null && session.getAttribute("type").equals("resident")){%>
			<%@include file="header1.jsp" %>
			<%}
		else if(session.getAttribute("type")!=null && session.getAttribute("type").equals("admin")){
			response.sendRedirect("../admin/index.jsp");
		}
			%>
<%
String error=(String)request.getAttribute("error");
if(error != null){
out.print("<p style='background-color:green; font-size:24px; color:white'><b>"+error +"</b></p>");
} %>
		</header>
		<section>
		
		
		
			<div class="property-listing multiple-recent-properties">
		<div class="container" align="center">
		<form action="<%=request.getContextPath()%>/allProperties?flag=fetch_properties1" method="post">
			<div>
				<button class="btn btn-primary ">Bedroom</button>&nbsp;&nbsp;
				<select class="btn btn-default" name="bed">
					<option disabled="disabled"><strong>Sort By No. Of Bedroom</strong></option>
					<option value="1" onclick="abc()">1</option><option value="2">2</option>
					<option value="3">3</option><option value="4">4</option>
					<option value="5">5</option><option value="6">6</option>
				</select>
		&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="btn btn-primary">Bathroom</button>&nbsp;&nbsp;
				<select class="btn btn-default" name="bath">
					<option disabled="disabled"><strong>Sort By No. Of Bathroom</strong></option>
					<option value="1" onclick="abc()">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
				</select>
		&nbsp;&nbsp;&nbsp;&nbsp;
				<a><button class="btn btn-primary" >Submit</button></a>
			</div>
		</form>
		</div>
				<div class="container">
					
					<div class="row property-list-area">
						<c:forEach items="${sessionScope.fetch_properties }" var="i" varStatus="j">
						<div class="property-list-list" data-target="Residential">
							<div class="col-xs-12 col-sm-4 col-md-4 property-list-list-image">
								<a href="<%=request.getContextPath() %>/addApartmentServlet?flag=list&apartment_id=${i.apartmentId}">
									<img src="<%=request.getContextPath()%>/img/${i.apartmentPhotos[0].encryptedName}" alt="recent-properties-1" class="img-responsive">

								</a>
							</div>
							<div class="col-xs-12 col-sm-8 col-md-8 property-list-list-info">
								<div class="col-xs-12 col-sm-6 col-md-6">
									<a href="<%=request.getContextPath() %>/addApartmentServlet?flag=list&apartment_id=${i.apartmentId}">
										<h6>${i.address }</h6>
									</a>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6">
									<label class="property-list-list-label">Available for Rent</label>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6">	
									<span class="recent-properties-address">${i.city } / ${i.state } - ${i.zipCode }</span>
									<p class="recent-properties-price">${i.price } Per Month</p>
									<p>${i.aminities }</p>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6 property-list-list-facility">
									<ul>
										<li class="left">Beds</li>
										<li class="right"><span>${i.noOfBedroom }</span> </li>
									</ul>
									<ul>
										<li class="left">Bathrooms</li>
										<li class="right"><span>${i.noOfBathroom }</span> </li>
									</ul>
									<ul>
										<a href="<%=request.getContextPath() %>/appointmentServlet?flag=search&apartment_id=${i.apartmentId}">
											<button class="btn btn-primary" type="submit" >Schedule an Appointment</button>
										</a>
										<br>
										<br>
										<a href="<%=request.getContextPath() %>/appointmentServlet?flag=fetchAddress&apartment_id=${i.apartmentId}">
											<button class="btn btn-primary" type="submit" >Request for Rental</button>
										</a>
										<br>
										<br>
									</ul>
								</div>
							</div>							
						</div>
						
						</c:forEach>
						</div>
					
				</div>
			</div>
		</section>
	</body>
</html>