<header id="main-header">
    <div class="header-top">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <a class="logo" href="/">
                        <img src="img/logo.png" alt="Image Alternative text" title="Image Title"/>
                    </a>
                </div>
                <div class="col-md-3 col-md-offset-2">

                </div>
                <div class="col-md-4">
                    <div class="top-user-area clearfix">
                        <ul class="top-user-area-list list list-horizontal list-border">
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                <li>
                                    <a href="/admin">Admin</a>
                                </li>
                            </security:authorize>


                            <security:authorize access="hasRole('ROLE_ANONYMOUS')">
                                <li><a href="/login"><i
                                        class="fa fa-lock  box-icon-gray box-icon-success box-icon-left animate-icon-border-rise round"></i></a>
                                </li>
                            </security:authorize>


                            <security:authorize
                                    access="hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER') OR hasRole('ROLE_STAFF')">
                                <li><a href="/j_spring_security_logout"><i class="fa fa-sign-out danger fa-2x"></i></a>
                                </li>
                            </security:authorize>


                            <security:authorize
                                    access="hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER') OR hasRole('ROLE_STAFF')">
                                <li><a href="/profile"><i
                                        class="fa fa-user fa-2x  box-icon-gray box-icon-info box-icon-left animate-icon-border-rise round"></i>Hi,
                                    ${loggedInUser.firstName}</a></li>
                            </security:authorize>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

</header>
<script>
	function exchange(currency, cval){
		
		
		// ajax to convert
		
		$.ajax({
	    	url: '${pageContext.request.contextPath}/exchange/',
	    	type: "GET",
			data: {'symb': currency},
	    	
	    	success: function(data) {
	    		console.log("Data "+ data);
	    		$('#totalTrip').html(data);
	    	}
	    });
		
		// refresh page
		$('#exchange').html(currency+ ' ' +cval);
		
		
		
		
	}

</script>