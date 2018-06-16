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

<body class="full-page">

<div class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="signin-signup-form">
                    <a href="../user/index.jsp"><img src="img/logo_rentprop_new.png" height="75" width="285"/></a><br><br>
                    <div class="form-title">Enter Registered Email Address to set up a New Password</div>
                    <form action="<%=request.getContextPath() %>/forgotPasswordServlet" method="post">
                        <input type="hidden" name="flag" value="email" required>
                        <div class="form-text">
                            <input type="email" name="email" placeholder="Enter your Registered Email-Id" required>
                        </div>
                        
                        <div class="form-button">
                            <input type="submit" value="Submit">
                        </div>
                    </form>
                   <br> <div class="links-holder"><a href="../user/login.jsp">Back</a></div>
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
