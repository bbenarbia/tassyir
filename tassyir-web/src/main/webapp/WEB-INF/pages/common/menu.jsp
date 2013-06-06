<%@ include file="/WEB-INF/pages/common/header.jsp" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="topbar">
			<ul>
				<li class="current"><a href="${contextPath}"><spring:message code="home" /> </a></li>
				<sec:authorize access="hasAnyRole('ROLE_MANAGER')">
						<li><a href="${contextPath}/users">Admin</a></li>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
						<li><a href="${contextPath}/parameters">Params</a></li>
				</sec:authorize>				
				<li><a href="#">Publicité</a></li>
				<li><a href="#">About Us</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>
</div>
<div id="header">
			<div id="sitename">
				<h1 id="logo">Tassyir</h1>
			</div>
			<div id="shoutout">
				<img  src='<c:url value="/resources/graphics/joinnow_shoutout.jpg"/>'  alt="Join Now! It's Free"
					width="168" height="126" />
			</div>
			<div id="useractions">
			<sec:authorize access="isAuthenticated()">
				<div id="headings">
						<h2>
							<img src='<c:url value="/resources/graphics/user-icone.png"/>'  alt="My profile"
								width="27" height="22" /> <a href="${contextPath}/users/my-profile">My profile</a>
						</h2>
						<h2>
							<img src='<c:url value="/resources/graphics/mail.png"/>'  alt="Messages"
								width="27" height="22" /> <a href="${contextPath}/messages">Messages(0)</a>
						</h2>
						<h2>
							<img src='<c:url value="/resources/graphics/logout.png"/>'  alt="Logout"
								width="27" height="22" /> <a href="${contextPath}/logout">Logout</a>
						</h2>
				</div>
				<div id="headings">
						<h2>
							<img src='<c:url value="/resources/graphics/Home.png"/>'  alt="Mes annonces"
								width="27" height="22" /> <a href="${contextPath}/biens/my-biens.htm">Mes annonces</a>
						</h2>
						<h2>
							<img  src='<c:url value="/resources/graphics/Home-plus.png"/>' alt="New annonce"
								width="25" height="22" /> <a href="${contextPath}/biens/new.htm">Add new annonce</a>
						</h2>
				</div>
				</sec:authorize>	
				<sec:authorize access="isAnonymous()">
					<div id="headings">
						<h2>
							<img  src='<c:url value="/resources/graphics/create_indi_usr.jpg"/>' alt="Individual User"
								width="25" height="22" /> <a href="#">New Indiv Account</a>
						</h2>
						<h2>
							<img src='<c:url value="/resources/graphics/create_agent_icon.jpg"/>'  alt="Agent Account"
								width="27" height="22" /> <a href="#">Create Agent Acc</a>
						</h2> 
					</div>
				 <div id="login">
					<p>
						<strong>Already registered ?</strong> Login here to access your account
					</p>
					<div id="loginform">
						 <form method="post" action="${contextPath}/j_spring_security_check">
							<div class="formblock">

								<label>Username</label> <input id="j_username" name="j_username"  value="" placeholder="Username or Email" type="text"  class="textfields" />
							</div>
							<div class="formblock">

								<label>Password</label><input id="j_password" name="j_password" value="" placeholder="Password" type="password" class="textfields" />
							</div>
							<div class="formblockButton">
								<%-- <input type="image" src='<c:url value="/resources/graphics/loginbutton.jpg"/>'  name="button" id="button"  value="Submit" /> --%>
								<input type="submit"  alt="Login"  class="buttonmenu" value="Login" />
							</div>
							<div class="clear">&nbsp;</div>
							<p>
								<input name="remember_me" id="remember_me" type="checkbox" value="" /> Remember me on this computer | Forgot password ?
							</p>
						</form>
					</div>
				</div>
			</sec:authorize>				
		 </div>
</div>
<!-- <div id="header">
</div> -->
<%-- 
<div class="wrapperCenter">
       <table id="table-menu">
		<tr>
		  <td>
			<a href="${contextPath}/users" >Admin</a>  
		  </td>
		  <td>
				<a href="${contextPath}/parameters" >Params</a>			
		  </td>
		  <td>
				<a href="${contextPath}/groups" >Groups</a>
		  </td>
		
		</tr>
	</table>	
</div>		 --%>