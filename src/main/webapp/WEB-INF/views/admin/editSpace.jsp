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
                <form:form class="form-horizontal margin-none" action="/admin/spaces/addPage/add" method="post"
                           commandName="space" autocomplete="off">
                    <!-- Widget -->
                    <div class="widget">
                        <!-- Widget heading -->
                        <div class="widget-head">
                            <h4 class="heading">Add Space</h4>
                        </div>
                        <!-- // Widget heading END -->
                        <div class="widget-body innerAll inner-2x">
                            <!-- Row -->
                            <div class="row innerLR">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <div class="col-md-8">
                                            <form:label path="carpark.id" for="carparkId"
                                                        class="control-label">Choose Carpark</form:label></div>
                                        <br/>

                                        <div class="col-md-8">
                                            <form:select data-style="btn-primary" class="selectpicker"
                                                         path="carpark.id" id="carparkId" autocomplete="false">
                                                <c:forEach items="${carparkx}" var="carpark">
                                                    <form:option label="${carpark.codename}" value="${carpark.id}"/>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <!-- Group -->
                                    <div class="form-group">
                                        <div class="col-md-8">
                                            <form:label path="spaceType.id" for="spaceTypeId"
                                                        class="control-label">Choose Space Type</form:label>
                                        </div>
                                        <br/>

                                        <div class="col-md-8">
                                            <form:select data-style="btn-primary" class="selectpicker"
                                                         path="spaceType.id" id="spaceTypeId" autocomplete="false">
                                                <c:forEach items="${spaceTypex}" var="spaceType">
                                                    <form:option label="${spaceType.name}" value="${spaceType.id}"/>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                </div>
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