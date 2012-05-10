<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  	<h1>Round 2 voting</h1>
  	
  	<g:if test="${flash.message}">
	<div class="message" role="status">${flash.message}</div>
	</g:if>
	
	<g:form method="post" action="saveVotingRound2">
		<table>
			<tr>
				<th>Pool A</th>
				<th>Pool B</th>
			</tr>
			<tr>
				<td>
				<g:each in="${poolASubjects}" var="subjectInstance">
				<input type='radio' Name="PoolA" value="${subjectInstance.id }" /> ${subjectInstance.name}<br>
				
			</g:each>
				</td>
				<td>
				<g:each in="${poolBSubjects}" var="subjectInstance">
				<input type='radio' Name="PoolB" value="${subjectInstance.id }" /> ${subjectInstance.name}<br>
				
			</g:each>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Vote" /></td>
			</tr>
		</table>
	</g:form>
  </div>
</body>
</html>