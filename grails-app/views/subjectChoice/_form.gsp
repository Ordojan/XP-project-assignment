<%@ page import="eess.SubjectChoice" %>



<div class="fieldcontain ${hasErrors(bean: subjectChoiceInstance, field: 'priority', 'error')} required">
	<label for="priority">
		<g:message code="subjectChoice.priority.label" default="Priority" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="priority" required="" value="${fieldValue(bean: subjectChoiceInstance, field: 'priority')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subjectChoiceInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="subjectChoice.student.label" default="Student" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="student" name="student.id" from="${eess.Users.list()}" optionKey="id" required="" value="${subjectChoiceInstance?.student?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subjectChoiceInstance, field: 'subject', 'error')} required">
	<label for="subject">
		<g:message code="subjectChoice.subject.label" default="Subject" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="subject" name="subject.id" from="${eess.Subject.list()}" optionKey="id" required="" value="${subjectChoiceInstance?.subject?.id}" class="many-to-one"/>
</div>

