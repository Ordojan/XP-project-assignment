<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<title>Showing Round 1 Results</title>
</head>
<body>
<section id="all-subjects">
				<div class="row">
					<table class="table table-striped" id="subjects">
						<thead>
							<tr>
							    <th style="vertical-align: middle;">
									<h3>#</h3>
								</th>
								
								<th style="vertical-align: middle;">
									<h3>Students</h3>
								</th>
								<g:each in="${subjects}" var="subject">
									<th data-id="${subject.id }">
										<h3>${subject}</h3>
										<div class="btn-group switches" data-toggle="buttons-checkbox">
											<button class="btn btn-small">A</button><button class="btn btn-small">B</button>
										</div>
									</th>
								</g:each>
							</tr>
						</thead>
						<tbody>
						
							<g:each in="${students}" var="student" status="i">
								<tr>
									<td>
										<h4>${i + 1}</h4>
									</td>
									<td>
										<h4>${student.name} ${student.happiness }</h4>
									</td>
									<g:each in="${subjects}" var="subject">
										<td>
											<g:each in="${student.subjectChoices}" var="subjectChoice">
												<g:if test="${subjectChoice.subject == subject}">
													<g:if test="${subjectChoice.priority == 1}">
														<span class="badge badge-success">1st</span>
													</g:if>
													<g:else>
														<span class="badge badge-warning">2nd</span>
													</g:else>
												</g:if>
											</g:each>
										</td>
									</g:each>
								</tr>
							</g:each>
						</tbody>
					</table>
				</div>
			</section>

			<section id="pools"> 
				<div class="row">
					<div class="span12" id="pools">
						<div class="row">
							<div class="span6">
								<div class="page-header row">
									<h1 class="span6">Pool A</h1>
								</div>
								
								<div class="row">
									<table class="table table-striped" id="pool-a">
										<thead>
											<tr>
												<th>#</th>
												<th>Name</th>
												<th>Description</th>
												<th>Teacher</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>

							<div class="span6">
								<div class="page-header row">
									<h1 class="span6">Pool B</h1>
								</div>
						
								<div class="row">
									<table class="table table-striped" id="pool-b">
										<thead>
											<tr>
												<th>#</th>
												<th>Name</th>
												<th>Description</th>
												<th>Teacher</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
						
							</div>
						</div>
					</div>
				</div>
			</section>
			
			<div class="row" id="start-round">
				<button type="button" class="btn btn-large btn-primary" id='start-round-btn'>Start 2nd Round</button>			
			</div>

		
	</div>
	<g:javascript src="prepare-round.js"></g:javascript>
</body>
</html>