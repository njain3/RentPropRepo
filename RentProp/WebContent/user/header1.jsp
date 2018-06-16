<div class="container">
				<div class="menu">
						<nav class="navbar navbar-default">
						  <div class="container-fluid">
						    <!-- Brand and toggle get grouped for better mobile display -->
						    <div class="navbar-header">
						      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						        <span class="sr-only"></span>
						        <span class="icon-bar"> </span>
						        <span class="icon-bar"> </span>
						        <span class="icon-bar"> </span>
						      </button>
						      <a class="navbar-brand" href="index.jsp">
						      	<img src="img/logo_rentprop_new.png" height="75" width="285">
						      </a>
						    </div>
						
						    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						      <ul class="nav navbar-nav nav_link pull-right">
						        <li><a href="../user/index.jsp">HOME </a>
						        	
							    </li>
						        
						        <li><a href="<%=request.getContextPath()%>/allProperties?flag=fetch_properties"><b>PROPERTIES</b></a>
						        							        	
						        
						        </li>
						        
						        <li><a href="contact.jsp">CONTACT US</a>
						        	
							  </li>	      
							    
				
						       <li style="float: right"><a class="drop_down"> <% out.print(session.getAttribute("firstName")); %></a>
						        
							    	        	<ul class="submenu">
							           <li><a href="<%=request.getContextPath()%>/addResidentServlet?flag=edit&resident_id=<%=session.getAttribute("resident_id")%>">Edit Profile</a> </li>
							           <li><a href="requestService.jsp">Request for Service</a> </li>
							           <li><a href="<%=request.getContextPath()%>/paymentServlet?flag=viewBill&resident_id=<%=session.getAttribute("resident_id")%>">View Bills</a> </li>
							           <li><a href="<%=request.getContextPath()%>/paymentServlet?flag=viewPayments&resident_id=<%=session.getAttribute("resident_id")%>">View Payment History</a> </li>
							           <li><a href="<%=request.getContextPath()%>/loginServlet?flag=logout">Log Out</a> </li>
							  
							    	</ul>
							  </li>
							  </ul>
						  </div>
						  </div>
						</nav>
				</div>
				
				  			
				</div>
				

				