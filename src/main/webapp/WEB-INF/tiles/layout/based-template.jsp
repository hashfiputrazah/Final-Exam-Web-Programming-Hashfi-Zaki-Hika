<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html lang="en">
<head>
<link rel="icon" href="<c:url value='/img/temp_library/library_icon.jpg" alt="lib Logo'/>" type="image/icon type">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Library</title>
	
<jsp:include page="/WEB-INF/tiles/templates/loader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/tiles/templates/modal.jsp"></jsp:include>
	<script type="text/javascript">
// 		$(document).ready(function () {
// // 			checkActivity(1800000, 60000, 0); // timeout = 30 minutes, interval = 1 minute.
// 			checkActivity(30000, 30000, 0); // timeout = 30 minutes, interval = 1 minute.
// 		});
	</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed big_container">
<div class="wrapper">
  	<!-- Navbar -->
	<header id="header">
		<tiles:insertAttribute name="header" />
	</header>
	<!-- /.navbar -->

	<!-- Main Sidebar Container -->
	<aside class="main-sidebar sidebar-dark-primary elevation-4 side_bg">
		<!-- Brand Logo -->
		<a href="index3.html" class="brand-link header_title"> 
			<img src="<c:url value='/img/temp_library/library_icon.jpg" alt="lib Logo'/>" class="brand-image img-circle elevation-3" style="opacity: .8">
			<span class="brand-text font-weight-light">E-Library</span>
		</a>

		<!-- Sidebar -->
		<div class="sidebar">
			<!-- Sidebar user panel (optional) -->
			<div class="user-panel mt-3 pb-3 mb-3 d-flex" style="">
				<div class="image">
					<img src="<c:url value='/img/temp_library/user-icon.png'/>" class="img-circle elevation-2" alt="User Image">
				</div>
				<div class="info">
					<h4 href="#" class="d-block text-white ">${username}</h4>
				</div>
			</div>

			<!-- Sidebar Menu -->
			<section id="sidemenu">
				<tiles:insertAttribute name="menu" />
			</section>
			<!-- /.sidebar-menu -->
		</div>
		<!-- /.sidebar -->
	</aside>
	<!-- /.main-sidebar -->

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper " style="background: #f4f6f9b3">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<!-- /.col -->
					<div class="col-sm-12">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">E-Library</li>
						</ol>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /.content-header -->

		<!-- Main content -->
		<section class="content" id="container">
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Control sidebar content goes here -->
	</aside>
	<!-- /.control-sidebar -->

	<!-- Main Footer -->
	<footer id="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
</div>
<!-- ./wrapper -->
</body>
</html>
