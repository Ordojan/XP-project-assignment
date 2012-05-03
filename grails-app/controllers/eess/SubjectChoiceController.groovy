package eess

import org.springframework.dao.DataIntegrityViolationException

class SubjectChoiceController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		def firstPriorityChoices = SubjectChoice.where {
			student == session.user && priority == 1
		}
		def secondPriorityChoices = SubjectChoice.where {
			student == session.user && priority == 2
		}
		
		render (view: "list", model: [firstPriorityChoices: firstPriorityChoices, secondPriorityChoices: secondPriorityChoices])
	}

	def create() {
		[subjectChoiceInstance: new SubjectChoice(params)]
	}

	def save() {
		def subjectChoiceInstance = new SubjectChoice(params)
		if (!subjectChoiceInstance.save(flush: true)) {
			render(view: "create", model: [subjectChoiceInstance: subjectChoiceInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'subjectChoice.label', default: 'SubjectChoice'), subjectChoiceInstance.id])
		redirect(action: "show", id: subjectChoiceInstance.id)
	}

	def show() {
		def subjectChoiceInstance = SubjectChoice.get(params.id)
		if (!subjectChoiceInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'subjectChoice.label', default: 'SubjectChoice'), params.id])
			redirect(action: "list")
			return
		}

		[subjectChoiceInstance: subjectChoiceInstance]
	}

	def edit() {
		def subjectChoiceInstance = SubjectChoice.get(params.id)
		if (!subjectChoiceInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'subjectChoice.label', default: 'SubjectChoice'), params.id])
			redirect(action: "list")
			return
		}

		[subjectChoiceInstance: subjectChoiceInstance]
	}

	def update() {
		def subjectChoiceInstance = SubjectChoice.get(params.id)
		if (!subjectChoiceInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'subjectChoice.label', default: 'SubjectChoice'), params.id])
			redirect(action: "list")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (subjectChoiceInstance.version > version) {
				subjectChoiceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'subjectChoice.label', default: 'SubjectChoice')] as Object[],
						  "Another user has updated this SubjectChoice while you were editing")
				render(view: "edit", model: [subjectChoiceInstance: subjectChoiceInstance])
				return
			}
		}

		subjectChoiceInstance.properties = params

		if (!subjectChoiceInstance.save(flush: true)) {
			render(view: "edit", model: [subjectChoiceInstance: subjectChoiceInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'subjectChoice.label', default: 'SubjectChoice'), subjectChoiceInstance.id])
		redirect(action: "show", id: subjectChoiceInstance.id)
	}

	def delete() {
		def subjectChoiceInstance = SubjectChoice.get(params.id)
		if (!subjectChoiceInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'subjectChoice.label', default: 'SubjectChoice'), params.id])
			redirect(action: "list")
			return
		}

		try {
			subjectChoiceInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'subjectChoice.label', default: 'SubjectChoice'), params.id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'subjectChoice.label', default: 'SubjectChoice'), params.id])
			redirect(action: "show", id: params.id)
		}
	}
}
