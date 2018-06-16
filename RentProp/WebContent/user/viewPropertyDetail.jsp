<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<base href="${pageContext.request.contextPath}/user/">
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="Residency theme">
		<meta name="keywords" content="Residency,sale,buy,rent,pg,house,villa,apartment">
		<meta name="author" content="Fortune Creations">
		<meta name="viewport" content="width=device-width">
		
		<title>Property Details</title>
		
		<link rel="stylesheet" href="css/font-awesome.min.css">	
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />	
	</head>
	<body>
<header>
		<%
			if(session.getAttribute("type")==null){
		%>
		<%@include file="header.jsp" %>
		<%	} 
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
			<div class="property-detail">
				<div class="container">
					<div class="row">
						<div class="col-lg-8 col-md-8 property-detail-inner">
							
							<div class="row">
								<div class="col-lg-6 col-md-6">
									<h4>Essential Information</h4>
									<div class="row">
										
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 inofrmaition-label">Price</div>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 information-value"><% out.print("$ ");%> ${sessionScope.edit_apartments1.price}<% out.print(" per Month");%></div>
										
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 inofrmaition-label">Bedrooms</div>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 information-value">${sessionScope.edit_apartments1.noOfBedroom }</div>
										
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 inofrmaition-label">Bathrooms</div>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 information-value">${sessionScope.edit_apartments1.noOfBathroom }</div>										
										
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 inofrmaition-label">Type</div>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 information-value">Single Family</div>
										<br>
										<br>
										</div>
								</div>
								<div class="col-lg-6 col-md-6">
									<h4>Amenities</h4>
									<div class="row amenities-info">
										<div class="col-lg-1 col-md-1 col-sm-2 col-xs-2 inofrmaition-label"></div>
										<div class="col-lg-11 col-md-11 col-sm-10 col-xs-10 information-value">${sessionScope.edit_apartments1.aminities }</div>
										
										
									</div>		
								</div>
							</div>
							<br>
							<a href="<%=request.getContextPath() %>/appointmentServlet?flag=search&apartment_id=${sessionScope.edit_apartments1.apartmentId}"><button class="btn btn-primary" type="submit" >Schedule an Appointment</button></a>
							<a href="<%=request.getContextPath() %>/appointmentServlet?flag=fetchAddress&apartment_id=${sessionScope.edit_apartments1.apartmentId}"><button class="btn btn-primary" type="submit" >Request for Rental</button></a>
							<br>
							<br>
							<br>
						</div>
						
					</div>
				</div>
			</div>
		</section>
	
		<%
		if(session.getAttribute("list_of_apartment_photos")!=null){
		%>
		<section>
			<div class="inner-page-gallery-three-columns">
				<div class="container">
					
					<div class="LivingRoom inner-page-gallery-three-columns-dimension-detail show-hide-detail" id="LivingRoom">
						<ul class="row">
						<c:forEach items="${sessionScope.list_of_apartment_photos }" var="m" varStatus="j">
							<li class="col-md-4 col-sm-4 col-xs-12">
								<img src="<%=request.getContextPath()%>/img/${m.encryptedName}" alt="gallery_img">
														
							</li>
							</c:forEach>							
						</ul>
					</div>
																					
				</div>
			</div>
		</section>
		
		
		<%}	%>
		
		<script src="js/jquery-2.1.4.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/image-light-box.js"></script>
		<script src="js/tab-navigation.js"></script>
		<script src="js/formsubmit.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				function centerModals(){
				  $('.modal').each(function(i){
				    var $clone = $(this).clone().css('display', 'block').appendTo('body');
				    var top = Math.round(($clone.height() - $clone.find('.modal-content').height()) / 2);
				    top = top > 0 ? top : 0;
				    $clone.remove();
				    $(this).find('.modal-content').css("margin-top", top);
				  });
				}
				$('.modal').on('show.bs.modal', centerModals);
				$(window).on('resize', centerModals);
			});
		</script>		
	</body>
</html>