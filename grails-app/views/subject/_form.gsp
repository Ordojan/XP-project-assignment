<%@ page import="eess.Subject" %>



<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="subject.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${subjectInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="subject.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${subjectInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="subject.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${eess.Users.list()}" optionKey="id" required="" value="${subjectInstance?.owner?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'students', 'error')} ">
	<label for="students">
		<g:message code="subject.students.label" default="Students" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${subjectInstance?.students?}" var="s">
    <li><g:link controller="subjectChoice" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="subjectChoice" action="create" params="['subject.id': subjectInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'subjectChoice.label', default: 'SubjectChoice')])}</g:link>
</li>
</ul>

</div>

