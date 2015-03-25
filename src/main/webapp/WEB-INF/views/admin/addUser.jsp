<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <form:form class="form-horizontal margin-none" action="/admin/users/addPage/add/" method="post"
                           commandName="user" autocomplete="off">
                    <!-- Widget -->
                    <div class="widget">
                        <!-- Widget heading -->
                        <div class="widget-head">
                            <h4 class="heading">Add User</h4>
                        </div>
                        <!-- // Widget heading END -->
                        <div class="widget-body innerAll inner-2x">
                            <!-- Row -->
                            <div class="row innerLR">
                                <!-- Column -->
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="userRole.id"
                                                    for="userRoleId">Choose Role</form:label>
                                        <form:select id="userRoleId" class="selectpicker col-md-6" path="userRole.id"
                                                     data-style="btn-primary">
                                            <c:forEach items="${rolex}" var="role">

                                                <form:option label="${role.name}" value="${role.id}"/>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="firstName"
                                                    for="firstname">First name</form:label>

                                        <div class="col-md-8">
                                            <form:input class="form-control" path="firstName" id="firstname"
                                                        name="firstname" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="lastName"
                                                    for="lastname">Last name</form:label>

                                        <div class="col-md-8">
                                            <form:input class="form-control" path="lastName" id="lastname"
                                                        name="lastname" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="username"
                                                    for="username">Username</form:label>

                                        <div class="col-md-8">
                                            <form:input class="form-control" path="username" id="username"
                                                        name="username" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="address"
                                                    for="address">Address</form:label>

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
                                    <form:errors path="*" cssClass="error"/>
                                    <form:hidden path="enabled" value="1"/>
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="gender.id"
                                                    for="userGender">Select Gender</form:label>
                                        <form:select id="userGender" class="selectpicker col-md-6" path="gender.id"
                                                     data-style="btn-primary">
                                            <c:forEach items="${genderx}" var="gender">

                                                <form:option label="${gender.name}" value="${gender.id}"/>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="email"
                                                    for="email">E-mail: </form:label>

                                        <div class="col-md-8">
                                            <form:input class="form-control" id="email" path="email"
                                                        name="email" type="email"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="password"
                                                    for="password">Password</form:label>

                                        <div class="col-md-8">
                                            <form:input class="form-control" path="password" id="password"
                                                        name="password" type="password"/>
                                        </div>
                                    </div>

                                </div>
                                <!-- // Column END -->
                            </div>
                            <!-- // Row END -->
                            <!-- Row -->

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