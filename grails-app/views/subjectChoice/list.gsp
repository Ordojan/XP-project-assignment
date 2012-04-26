
<%@ page import="eess.SubjectChoice" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'subjectChoice.label', default: 'SubjectChoice')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div id="list-subjectChoice" class="content scaffold-list" role="main">
			<h1>Your choices</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			1st priority: <g:each in="${firstPriorityChoices}" var="choice">${ choice.subject }, </g:each></br>
			2nd priority: <g:each in="${secondPriorityChoices}" var="choice">${ choice.subject }, </g:each>
		</div>
	</body>
</html>
