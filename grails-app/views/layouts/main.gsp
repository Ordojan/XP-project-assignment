<!doctype html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Electronic Elective Subject System"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<g:javascript src="bootstrap.min.js"></g:javascript>
        <g:javascript src="application.js"></g:javascript>
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<%--<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		--%><link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'site.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-responsive.css')}" type="text/css">
		<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
		  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<g:layoutHead/>
        <r:layoutResources />
	</head>
	<body>
		<div class="container">
		<g:render template="/layouts/header"></g:render>
		<g:layoutBody/>
		</div>
		<%--<g:javascript library="application"/>--%>
        <r:layoutResources />
        
        
		
        
	</body>
</html>