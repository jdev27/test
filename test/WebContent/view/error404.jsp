<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Page Not Found</title>
</head>
<body>
	<article>
		<section>
			<h1>Page ${pageName} Not Found</h1>
		</section>
		<section>
			<h1>
				go to main page <a href="${defaultPageLink}">${defaultPage}</a>
			</h1>
		</section>
	</article>
</body>
</html>