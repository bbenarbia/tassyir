<%@ include file="/WEB-INF/pages/common/header.jsp" %>
<div id="topbar">
			<ul>
				<li class="current"><a href="${contextPath}">Home</a></li>
				<li><a href="${contextPath}/users" >Admin</a></li>
				<li><a href="${contextPath}/parameters" >Params</a>	</li>			
				<li><a href="${contextPath}/biens/find-biens">Biens</a></li>
				<li><a href="#">About Us</a></li>
				<li><a href="#">Help &amp; Support</a></li>
				<li></li>
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
				<div id="headings">
					<h2>
						<img  src='<c:url value="/resources/graphics/create_indi_usr.jpg"/>' alt="Individual User"
							width="25" height="22" /> <a href="#">Create Individual
							Account</a>
					</h2>
					<h2>
						<img src='<c:url value="/resources/graphics/create_agent_icon.jpg"/>'  alt="Agent Account"
							width="27" height="22" /> <a href="#">Create Agent Accoun</a>t
					</h2>
				</div>
				<div id="login">
					<p>
						<strong>Already registered ?</strong> Login here to access your
						account
					</p>
					<div id="loginform">
						<form action="#">
							<div class="formblock">

								<label>Username</label> <input name="user" type="text"
									class="textfields" />
							</div>
							<div class="formblock">

								<label>Password</label><input name="user" type="text"
									class="textfields" />
							</div>
							<div class="formblock">
								<input type="image" src='<c:url value="/resources/graphics/loginbutton.jpg"/>'  name="button"
									id="button" value="Submit" />
							</div>


							<div class="clear">&nbsp;</div>
							<p>
								<input name="" type="checkbox" value="" /> Remember me on this
								computer | Forgot password ?
							</p>
						</form>
					</div>

				</div>
			</div>
</div>
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