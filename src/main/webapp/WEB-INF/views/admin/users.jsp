<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>

<!DOCTYPE html>
<%@ include file="template/sidebar.html" %>
<head>
    <%@ include file="template/header.html" %>
    <%@ include file="template/styles.html" %>
    <%@ include file="template/meta.html" %>
    <%@ include file="template/scripts.html" %>
</head>
<body class="">
<!-- Main Container Fluid -->
<div class="container-fluid menu-hidden">
    <!-- Sidebar Menu -->
    <%@ include file="template/sidebarmenu.html" %>
    <!-- // Sidebar Menu END -->
    <!-- Content -->
    <div id="content">
        <%@ include file="template/navbar.html" %>
        <!-- // END navbar -->
        <h2 class="">Users</h2>

        <div class="innerLR">
            <div class="row">
                <c:forEach items="${userx}" var="userx">
                    <div class="col-md-4">
                        <!-- Widget -->

                        <div class="widget widget-body-white">

                            <div class="bg-gray">
                                <h4 class="innerAll  border-top  border-bottom margin-bottom-none">Profile Completion:
                                    <p class="margin-none strong pull-right">${userx.profilecompleteness}%</p>
                                </h4>
                            </div>
                            <div class="progress progress-mini margin-none bg-gray border-bottom">
                                <div class="progress-bar progress-bar-success"
                                     style="width: ${userx.profilecompleteness}%;"></div>
                            </div>

                            <div class="media widget-body innerAll">


                                <a href="" class="pull-left">
                                    <img src="../assets/images/people/50/16.jpg" alt=""
                                         class="img-circle">
                                </a>

                                <div class="media-body innerT">

                                    <h4 class="margin-none"><a href=""
                                                               class="strong text-primary">${userx.firstName} ${userx.lastName}</a>
                                    </h4>
                                    <c:if test="${userx.userRole.id == 1}">
                                        <small class="text-muted-dark">Administrator</small>
                                    </c:if>
                                    <c:if test="${userx.userRole.id == 2}">
                                        <small class="text-muted-dark">Staff</small>
                                    </c:if>
                                    <c:if test="${userx.userRole.id == 3}">
                                        <small class="text-muted-dark">Customer</small>
                                    </c:if>
                                    <div class="clearfix"></div>
                                    <div class="innerT half">
                                        <a href="" class="btn btn-default btn-xs"><i class=" fa fa-star text-muted"></i></a>
                                        <a href="" class="btn btn-default btn-xs"><i class=" fa fa-user text-muted"></i></a>
                                        <a href="" class="btn btn-default btn-xs"><i
                                                class=" fa fa-envelope text-muted"></i></a>
                                        <a href="" class="btn btn-default btn-xs"><i
                                                class=" fa fa-twitter text-muted"></i></a>
                                    </div>
                                    <div class="bg-gray">

                                        <h5 class="innerB half border-bottom innerAll half"><i
                                                class="fa fa-fw icon-briefcase-2"></i>${userx.company}</h5>

                                    </div>
                                </div>
                            </div>

                            <a href="/admin/users/editPage/${userx.id}" class="btn btn-sm btn-success"><i
                                    class="fa fa-edit fa-fw"></i> Edit User</a>
                            <a href="/admin/users/delete/${userx.id}" class="btn btn-sm pull-right"><i
                                    class="fa fa-minus-circle"></i> Delete</a>

                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- End Row -->
        </div>
    </div>
    <!-- // Content END -->
    <div class="clearfix"></div>
    <!-- // Sidebar menu & content wrapper END -->
    <%@ include file="template/footer.html" %>
</div>
<%@ include file="template/footerscripts.html" %>
</body>
</html>