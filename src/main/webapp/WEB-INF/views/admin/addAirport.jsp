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
        <div class="innerLR">

            <div class="innerLR">
                <!-- Form -->
                <form:form class="form-horizontal margin-none" action="/admin/airports/addPage/add" method="post"
                           commandName="airport">
                    <!-- Widget -->
                    <div class="widget">
                        <!-- Widget heading -->
                        <div class="widget-head">
                            <h4 class="heading">Add Airport</h4>
                        </div>
                        <!-- // Widget heading END -->
                        <div class="widget-body innerAll inner-2x">
                            <!-- Row -->

                            <div class="row innerLR">
                                <!-- Column -->
                                <div class="col-md-6">
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="name"
                                                    for="name">Name: </form:label>
                                        <div class="col-md-8">
                                            <form:input class="form-control" path="name" id="name"
                                                        name="name" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="address"
                                                    for="address">Address: </form:label>
                                        <div class="col-md-8">
                                            <form:textarea cols="6" rows="4" class="form-control" path="address"
                                                           id="address"
                                                           name="address" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                </div>
                                <!-- // Column END -->
                                <!-- Column -->
                                <div class="col-md-6">
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="name"
                                                    for="postcode">Postcode: </form:label>
                                        <div class="col-md-8">
                                            <form:input class="form-control" path="postcode" id="postcode"
                                                        name="postcode" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->

                                </div>
                                <!-- // Column END -->
                            </div>
                            <div class="separator"></div>
                            <!-- Form actions -->
                            <div class="form-actions">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-check-circle"></i> Save
                                </button>
                                <button type="button" class="btn btn-default"><i class="fa fa-times"></i> Cancel
                                </button>
                            </div>
                            <!-- // Form actions END -->
                        </div>
                    </div>
                    <!-- // Widget END -->
                </form:form>
                <!-- // Form END -->
            </div>

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