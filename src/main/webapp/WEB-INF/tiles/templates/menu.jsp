<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="mt-2">
	<ul class="nav nav-legacy nav-compact nav-child-indent nav-sidebar flex-column text-sm lis" data-widget="treeview" role="menu" data-accordion="false">
		<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
		<li class="nav-header">Management</li>
	<li class="nav-item ">
			<a href="#" class="nav-link"> 
			<img src="<c:url value='/img/temp_library/book_icon.png'/>" class="img-circle elevation-2 mr-2" height="25" width="25" alt="User Image">
				<p>
					Library Management <i class="fas fa-angle-left right"></i>
				</p>
			</a>
			<ul class="nav nav-treeview">
				<li class="nav-item e_lib_nav">
					<a href="/e_library/list_library" class="nav-link"> 
						<i class="far fa-circle nav-icon"></i>
						<p>List Library</p>
					</a>
				</li>
				<li class="nav-item e_lib_nav">
					<a href="/e_library/manage_library" class="nav-link"> 
						<i class="far fa-circle nav-icon"></i>
						<p>Manage Library</p>
					</a>
				</li>
			</ul>
		</li>
	<!-- 			<li class="nav-item"> -->
	<!-- 			<a href="#" class="nav-link">  -->
	<!-- 				<i class="nav-icon far fa-envelope"></i> -->
	<!-- 				<p> -->
	<!-- 					User Management <i class="fas fa-angle-left right"></i> -->
	<!-- 				</p> -->
	<!-- 			</a> -->
	<!-- 			<ul class="nav nav-treeview"> -->
	<!-- 				<li class="nav-item e_lib_nav"> -->
	<!-- 					<a href="pages/mailbox/mailbox.html" class="nav-link">  -->
	<!-- 						<i class="far fa-circle nav-icon"></i> -->
	<!-- 						<p>List User</p> -->
	<!-- 					</a> -->
	<!-- 				</li> -->
	<!-- 				<li class="nav-item e_lib_nav"> -->
	<!-- 					<a href="pages/mailbox/compose.html" class="nav-link">  -->
	<!-- 						<i class="far fa-circle nav-icon"></i> -->
	<!-- 						<p>Manage User</p> -->
	<!-- 					</a> -->
	<!-- 				</li> -->
	<!-- 			</ul> -->
	<!-- 		</li> -->
<!-- 		<li class="nav-header">MISCELLANEOUS</li> -->
<!-- 		<li class="nav-item"> -->
<!-- 			<a href="iframe.html" class="nav-link"> -->
<!-- 				<i class="nav-icon fas fa-ellipsis-h"></i> -->
<!-- 				<p>Tabbed IFrame Plugin</p> -->
<!-- 			</a> -->
<!-- 		</li> -->
<!-- 		<li class="nav-item"> -->
<!-- 			<a href="https://adminlte.io/docs/3.1/" class="nav-link">  -->
<!-- 				<i class="nav-icon fas fa-file"></i> -->
<!-- 				<p>Documentation</p> -->
<!-- 			</a> -->
<!-- 		</li> -->
	</ul>
</nav>