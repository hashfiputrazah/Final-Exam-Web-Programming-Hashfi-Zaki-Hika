<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>404 Page Not Found Error</title>

	<!-- Google font -->
	<!-- <link href="https://fonts.googleapis.com/css?family=Nunito:400,700" rel="stylesheet"> -->

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/style_404.css'/>" />
</head>

<body>

	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404"></div>
			<h1>404</h1>
			<h2>Oops! Page Not Be Found</h2>
			<p>Sorry but the page you are looking for does not exist, have been removed. name changed or is temporarily unavailable</p>
			<a href="<c:url value='/'/>">Back to homepage</a>
		</div>
	</div>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
