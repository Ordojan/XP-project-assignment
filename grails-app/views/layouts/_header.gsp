			<header>
				<div class="page-header row">
					<div class="span8">
						<h1>Prepare 2nd Round</h1>
					</div>
					
					<span class="span4" style="text-align:right;">
						<g:if test="${session.user }">
							
							<g:form controller="users" action="logout">
								<strong>${session.user.name }</strong>
								<button class="btn btn-small" type="submit" >Sign out</button>
							</g:form>
						</g:if>
					</span>
				</div>
			</header>