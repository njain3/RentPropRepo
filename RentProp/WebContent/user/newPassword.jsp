<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<base href="${pageContext.request.contextPath}/admin/">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>RentProp Login</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min1.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min1.css">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
</head>
<%
if(session.getAttribute("type")!=null && session.getAttribute("type").equals("admin")){
	response.sendRedirect("index.jsp");
	}
else if(session.getAttribute("type")!=null && session.getAttribute("type").equals("resident")){
	response.sendRedirect("../user/index.jsp");
}
String error=(String)request.getAttribute("error");
if(error != null){
	out.print("<p style='background-color:white;'>"+error +"</p>");
}
%>
<body class="full-page">

<div class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="signin-signup-form">
                    <a href="../user/index.jsp"><img src="img/logo_rentprop_new.png" height="75" width="285" /></a><br><br>
                    <div class="form-title">Set a new Password</div>
                    <form action="<%=request.getContextPath() %>/forgotPasswordServlet" method="post">
                        <input type="hidden" name="flag" value="changepassword" required>
                        <div class="form-text">
                            <input type="text" name="otp" placeholder="Enter OTP, sent to your email ID" required>
                        </div>
                        <div class="form-text">
                            <input type="password" name="newPassword" placeholder="Enter New Password" required>
                        </div>
                        <div class="form-text">
                            <input type="password" name="newPassword1" placeholder="Enter Confirm Password" required>
                        </div>
                        
                        <div class="form-button">
                            <input type="submit" value="Submit">
                        </div>
                    </form>
                    <br> <div class="links-holder"><a href="../user/email.jsp">Back</a></div>
                   <br> <div class="links-holder"><a href="../user/index.jsp">Home</a> </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <br><br><br><br>
    
<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script src="js/main.js"></script>
</body>
</html>
