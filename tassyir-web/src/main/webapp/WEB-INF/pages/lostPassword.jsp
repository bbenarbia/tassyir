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
	<div id="wrap">
		<jsp:include page="./common/menu.jsp" />
		<jsp:include page="./common/sub-menu.jsp" />
		<div id="content">
			<div id="home_sidebar_left">
					<jsp:include page="./common/left-menu.jsp" />
			</div> 
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
													<legend> Reset your password </legend>
													<section class="containerlogin">
														<div class="login">
															<c:if test="${not empty errorMessage}">
																<div class="errorblock">
																        Error. <br />	
																        ${errorMessage}															        
																</div>
															</c:if>
															<form:form modelAttribute="user" method="post" id="form1">
																<p>
																	<form:input type="text" id="login" path="login"
																		value="" placeholder="Login" cssErrorClass="error"/>
																</p>
																<p>
																	<form:input type="text" id="adresseMail" path="adresseMail"
																		value="" placeholder="Email" cssErrorClass="error"/>
																</p>
																<p class="submit">
																	<input type="submit" name="commit" value="Initialiser">
																</p>
															</form:form>
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
						alt="Advertise Here" style="width: 200px;" />
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

