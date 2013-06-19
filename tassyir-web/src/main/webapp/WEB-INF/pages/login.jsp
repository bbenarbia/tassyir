
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/stylesheets/style-login.css"/>' />
<jsp:include page="./common/head.jsp" />

</head>
<body>
	<spring:url value="/users/subscribe.htm" var="subscribeUrl" />
	<spring:url value="/users/reset-password.htm" var="resetPasswordUrl" />
	
	<div id="wrap">
		<jsp:include page="./common/menu.jsp" />
		<jsp:include page="./common/sub-menu.jsp" />
		<div id="content">
			<div id="main_bien">
				<div id="search_bien">
					<div class="group">
						<h2>Selectionner le type de biens</h2>
						<ul>
							<li id="li_select_lang">
								<table class="search_form" style="width: 100%; border: none;">
									<tr>
										<td>
											<div id="searchoptions"
												class="pma_auto_slider slider_init_done" title="Options"
												style="overflow: auto;">
												<fieldset id="fieldset_select_fields">
													<legend> You have a new </legend>
													<div class="login-help">
															<p>
																Click her to create your account? <a href="${fn:escapeXml(subscribeUrl)}">Click
																	here to reset it</a>.
															</p>
													</div>
												</fieldset>

												<fieldset id="fieldset_select_fields">
													<legend> You have an account </legend>

													<section class="containerlogin">
														<div class="login">
															<c:if test="${not empty param.login_error}">
																<div class="errorblock">
																        Login Error. <br />	
																        ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}															        
																</div>
															</c:if>
															
															<form method="post" action="${pageContext.request.contextPath}/j_spring_security_check">
																
																<p>
																	<input type="text" id="j_username" name="j_username"
																		value="" placeholder="Login">
																</p>
																<p>
																	<input type="password" id="j_password"
																		name="j_password" value="" placeholder="Password">
																</p>
																<p class="remember_me">
																	<label> Mot de passe oublié? <a href="${fn:escapeXml(resetPasswordUrl)}">Clicker ici</a>.
																	</label>
																	
																</p>
																<p class="submit">
																	<input type="submit" name="commit" value="Login">
																</p>
															</form>
														</div>
													</section>
												</fieldset>


											</div>
										</td>
									</tr>
								</table>

							</li>
						</ul>
					</div>
				</div>
			</div>
			<div id="home_sidebar">
				<div class="block advert">

					<img src='<c:url value="/resources/graphics/advertisehere.jpg"/>'
						alt="Advertise Here" style="width: 315px;" />
					<%-- <jsp:include page="./../immobilier/right-side-recherche.jsp" /> --%>
				</div>
				<jsp:include page="./common/slide-right.jsp" />


			</div>
			<div class="clear">&nbsp;</div>
			<div class="clear">&nbsp;</div>
		</div>
		<div class="clear">&nbsp;</div>
		<div class="clear">&nbsp;</div>
		<jsp:include page="./common/footer.jsp" />
	</div>

</body>
</html>

