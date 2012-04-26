<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  	<h1>Round 1 voting</h1>
  	
  	<g:if test="${flash.message}">
	<div class="message" role="status">${flash.message}</div>
	</g:if>
	
	<g:form method="post" action="saveVotingRound1">
		<table>
			<tr>
				<th>Subject</th>
				<th>Choice</th>
			</tr>
			<g:each in="${subjectInstances}" status="i" var="subjectInstance">
				<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					<td>
						${ subjectInstance.name }
						<g:if test="${subjectInstance.description != null}"> - ${subjectInstance.description}</g:if>
					</td>
					<td>
						<input type="radio" name="choice_${ subjectInstance.id }" value="1"> 1st priority
						<input type="radio" name="choice_${ subjectInstance.id }" value="2"> 2nd priority
						<input type="radio" name="choice_${ subjectInstance.id }" value="0"> don't choose
					</td>
				</tr>
			</g:each>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Vote" /></td>
			</tr>
		</table>
	</g:form>
  </div>
</body>
</html>