<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<title>Showing Round 1 Results</title>
</head>
<body>
	<div class="body">

	<g:form action="showRound1Results" method="post">
		<table border="1" cellpadding="5" cellspacing="5" width="100%">
			<tr>
				<th>Students</th>
				<g:each in="${subjects}" var="subject">
					<th>
						${subject}
						<g:select name="subjectPool_${subject.id}" from="${poolOptions}" value="${subject.pool }" />
					</th>
				</g:each>
			</tr>

			<g:each in="${students}" var="student">
				<tr>
					<td>
						${student.name} ${student.happiness }
					</td>
					<g:each in="${subjects}" var="subject">
						<td>
							<%--<g:if test="${student.subjectChoices.contains(subject)}">
								--%><g:each in="${student.subjectChoices}" var="subjectChoice">
									<g:if test="${subjectChoice.subject == subject}">
										${subjectChoice.priority}
									</g:if>
								</g:each>
							<%--</g:if>
						--%></td>
					</g:each>
				</tr>
			</g:each>
			<tr>
				<td colspan="1000">
					<input type = "submit" name ="saveResult" value = "Save">
					<input type = "submit" name = "showResult" value = "Show Result">
				</td>				
			</tr>
		</table>
	</g:form>
	</div>
</body>
</html>