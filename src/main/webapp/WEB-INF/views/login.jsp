    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page session="true" %>
<!DOCTYPE HTML>
<html class="full">

<head>
    <title>Parkit - Airport Parking Made Easy</title>


    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <meta name="keywords" content="Template, html, premium, themeforest"/>
    <meta name="description" content="Traveler - Premium template for travel companies">
    <meta name="author" content="Tsoy">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- GOOGLE FONTS -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,600' rel='stylesheet'
          type='text/css'>
    <!-- /GOOGLE FONTS -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/mystyles.css">
    <script src="js/modernizr.js"></script>


</head>

<body class="full">
<div class="global-wrap">

    <div class="full-page">
        <div class="bg-holder full">
            <div class="bg-mask"></div>
            <div class="bg-img" style="background-image:url(img/background.jpg);"></div>
            <div class="bg-holder-content full text-white">
                <a class="logo-holder" href="/">
                    <img src="img/logo.png" alt="Image Alternative text" title="Image Title"/>
                </a>

                <div class="full-center">
                    <div class="container">
                        <div class="row row-wrap" data-gutter="60">
                            <div class="col-md-4">
                                <div class="visible-lg">
                                    <h3 class="mb15">Login to Account</h3>

                                    <p>Please login to your account so you can open up a box of opportunities (carpark
                                        space) to your world, security guaranteed. Check-in and Check-out with ease. you
                                        couldn't have it better </p>

                                    <p>
                                        Parkit - Airport carparking made easy
                                        <br/>
                                        ${serverTime}
                                    </p>

                                </div>
                                <h3 class="mb15">Login</h3>
                                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                                    <p class="alert-warning">
                                        Your login attempt was not successful due to <br/><br/>
                                        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                                    </p>
                                </c:if>
                                <form id="login" action="<c:url value='/j_spring_security_check' />" method="post">

                                    <div class="form-group form-group-ghost form-group-icon-left"><i
                                            class="fa fa-user input-icon input-icon-show"></i>
                                        <label name="usernameLB" id="usernameLB">Email: </label>
                                        <input name="username" id="username" class="form-control"
                                               placeholder="e.g. johndoe@gmail.com" type="text"/>
                                    </div>
                                    <div class="form-group form-group-ghost form-group-icon-left"><i
                                            class="fa fa-lock input-icon input-icon-show"></i>
                                        <label name="passwordLB" id="passwordLB">Password: </label>
                                        <input name="password" id="password" class="form-control" type="password"
                                               placeholder="your secret password"/>
                                    </div>
                                    <input class="btn btn-primary" type="submit" value="Sign in"/>


                                </form>
                            </div>
                            <div class="col-md-4">
                                <h3 class="mb15">Create an Account</h3>
								<spring:url var="addAction" value="/profile/register/add"/>
                                <form:form commandName="user" action="${addAction }">
                                <form:errors path="*" cssClass="error"/>
                                <div class="form-group form-group-ghost form-group-icon-left"><i
                                        class="fa fa-user input-icon input-icon-show"></i>
                                    <form:label path="firstName">First Name</form:label>
                                    <form:input path="firstName" class="form-control" placeholder="e.g. John"
                                                type="text"/>
                                </div>
                                <div class="form-group form-group-ghost form-group-icon-left"><i
                                        class="fa fa-user input-icon input-icon-show"></i>
                                    <form:label path="lastName">Last Name</form:label>
                                    <form:input path="lastName" class="form-control" placeholder="e.g. Doe"
                                                type="text"/>
                                </div>
                                <div class="form-group form-group-ghost form-group-icon-left"><i
                                        class="fa fa-envelope input-icon input-icon-show"></i>
                                    <form:label path="email">Email</form:label>
                                    <form:input path="email" class="form-control" placeholder="e.g. johndoe@gmail.com"
                                                type="text"/>
                                </div>
                                <div class="form-group form-group-ghost form-group-icon-left"><i
                                        class="fa fa-mobile input-icon input-icon-show"></i>
                                    <form:label path="mobile">Mobile</form:label>
                                    <form:input path="mobile" class="form-control" placeholder="e.g. 0787876322"
                                                type="text"/>
                                </div>
                            </div>
                            <div class="col-md-4">

                                <div class="form-group form-group-ghost form-group-icon-left"><i
                                        class="fa fa-mobile input-icon input-icon-show"></i>
                                    <form:label path="address">Address</form:label>
                                    <form:textarea rows="2" cols="5" path="address" class="form-control"
                                                   placeholder="e.g. P.O. Box or General Address" type="text"/>
                                </div>
                                <div class="form-group form-group-ghost form-group-icon-left"><i
                                        class="fa fa-lock input-icon input-icon-show"></i>
                                    <form:label path="password">Password</form:label>
                                    <form:input path="password" class="form-control" type="password"
                                                placeholder="your secret password"/>
                                    <form:hidden path="userRole.id" value="3"/>
                                    <form:hidden path="enabled" value="1"/>
                                </div>
                                <div class="form-group form-group-ghost form-group-icon-left"><i
                                        class="fa fa-lock input-icon input-icon-show"></i>

                                    <div class="radio-inline radio-lg">

                                        <label>
                                            <form:radiobutton path="gender.id" class="i-radio" value="1"
                                                              name="genderRadio"/>Male </label>
                                    </div>
                                    <div class="radio-inline radio-lg">
                                        <label>
                                            <form:radiobutton path="gender.id" class="i-radio" value="2"
                                                              name="genderRadio"/>Female </label>
                                    </div>

                                    <div class="gap gap-mini"></div>
                                    <div class="form-group">
                                        <label>Date of Birth </label>
                                        <form:input path="dob" name="dob" class="form-control"
                                                    data-date-format="yyyy-MM-dd" type="text" placeholder="YYYY-MM-DD"/>
                                    </div>
                                </div>


                                <input class="btn btn-primary" type="submit" value="Create Parkit Account"/>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
                <ul class="footer-links">
                    <li><a href="#">About</a>
                    </li>
                    <li><a href="/">Home</a>
                    </li>
                    <li><a href="/admin">Admin</a>
                    </li>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/slimmenu.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/bootstrap-timepicker.js"></script>
<script src="js/nicescroll.js"></script>
<script src="js/dropit.js"></script>
<script src="js/ionrangeslider.js"></script>
<script src="js/icheck.js"></script>
<script src="js/fotorama.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script src="js/typeahead.js"></script>
<script src="js/card-payment.js"></script>
<script src="js/magnific.js"></script>
<script src="js/owl-carousel.js"></script>
<script src="js/fitvids.js"></script>
<script src="js/tweet.js"></script>
<script src="js/countdown.js"></script>
<script src="js/gridrotator.js"></script>
<script src="js/custom.js"></script>
</body>

</html>


