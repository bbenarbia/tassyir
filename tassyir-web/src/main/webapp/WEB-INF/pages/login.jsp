<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html > <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head> --%>


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
																Click her to create your account? <a href="index.html">Click
																	here to reset it</a>.
															</p>
													</div>
												</fieldset>

												<fieldset id="fieldset_select_fields">
													<legend> You have an account </legend>

													<section class="containerlogin">
														<div class="login">
															<div id="login-error">${error}</div>
															<form method="post" action="j_spring_security_check">
																<p>
																	<input type="text" id="j_username" name="j_username"
																		value="" placeholder="Username or Email">
																</p>
																<p>
																	<input type="password" id="j_password"
																		name="j_password" value="" placeholder="Password">
																</p>
																<p class="remember_me">
																	<label> <input type="checkbox"
																		name="remember_me" id="remember_me"> Remember
																		me on this computer
																	</label>
																</p>
																<p class="submit">
																	<input type="submit" name="commit" value="Login">
																</p>
															</form>
														</div>

														<div class="login-help">
															<p>
																Forgot your password? <a href="index.html">Click
																	here to reset it</a>.
															</p>
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

