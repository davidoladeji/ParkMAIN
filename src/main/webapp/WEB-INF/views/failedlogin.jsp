<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>

<!DOCTYPE HTML>
<html>

<head>
    <%@ include file="template/header.html" %>
    <%@ include file="template/styles.html" %>
    <%@ include file="template/meta.html" %>
    <%@ include file="template/scripts.html" %>
</head>

<body class="full">
<div class="global-wrap">

    <div class="full-page">
        <div class="bg-holder full">
            <div class="bg-mask"></div>
            <div class="bg-img" style="background-image:url(img/background.jpg);"></div>
            <div class="bg-holder-content full text-white">
                <a class="logo-holder" href="admin/tmp/index.html">
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
                                        <small>Parkit - Airport carparking made easy</small>
                                        <br/>
                                        ${serverTime}
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <h3 class="mb15">Login</h3>
                                <form:form id="login" action="<c:url value='/j_spring_security_check' />" method="post">
                                    <div class="form-group form-group-ghost form-group-icon-left"><i
                                            class="fa fa-user input-icon input-icon-show"></i>
                                        <label>Username or email</label>
                                        <input class="form-control" placeholder="e.g. johndoe@gmail.com" type="text"/>
                                    </div>
                                    <div class="form-group form-group-ghost form-group-icon-left"><i
                                            class="fa fa-lock input-icon input-icon-show"></i>
                                        <label>Password</label>
                                        <input class="form-control" type="password" placeholder="your secret password"/>
                                    </div>
                                    <input class="btn btn-primary" type="submit" value="Sign in"/>

                                    <input type="hidden" name="${_csrf.parameterName}"
                                           value="${_csrf.token}"/>
                                </form:form>


                            </div>
                            <div class="col-md-4">
                                <h3 class="mb15">Create and Account</h3>

                                <form>
                                    <div class="form-group form-group-ghost form-group-icon-left"><i
                                            class="fa fa-user input-icon input-icon-show"></i>
                                        <label>Full Name</label>
                                        <input class="form-control" placeholder="e.g. John Doe" type="text"/>
                                    </div>
                                    <div class="form-group form-group-ghost form-group-icon-left"><i
                                            class="fa fa-envelope input-icon input-icon-show"></i>
                                        <label>Emai</label>
                                        <input class="form-control" placeholder="e.g. johndoe@gmail.com" type="text"/>
                                    </div>
                                    <div class="form-group form-group-ghost form-group-icon-left"><i
                                            class="fa fa-lock input-icon input-icon-show"></i>
                                        <label>Password</label>
                                        <input class="form-control" type="password" placeholder="your secret password"/>
                                    </div>
                                    <input class="btn btn-primary" type="submit" value="Sign up for Traveler"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <ul class="footer-links">
                    <li><a href="#">About</a>
                    </li>
                    <li><a href="#">Help</a>
                    </li>
                    <li><a href="#">Hot Deals</a>
                    </li>
                    <li><a href="#">Popular Locations</a>
                    </li>
                    <li><a href="#">Cheap Flights</a>
                    </li>
                    <li><a href="#">Business</a>
                    </li>
                    <li><a href="#">Media</a>
                    </li>
                    <li><a href="#">Developers</a>
                    </li>
                    <li><a href="#">Advertise</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <%@ include file="template/footer.html" %>
    <%@ include file="template/footerscripts.html" %>
</div>
</body>

</html>


