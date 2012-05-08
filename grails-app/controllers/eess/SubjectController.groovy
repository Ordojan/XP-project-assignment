package eess

import java.util.List;

import org.apache.jasper.compiler.Node.ParamsAction;
import org.springframework.dao.DataIntegrityViolationException

class SubjectController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def votingRound1() {
		def subjectInstances = Subject.list()
		render(view: "votingRound1", model: [subjectInstances: subjectInstances])
	}
	
	def saveVotingRound1(){
		def subjects = Subject.list()
		
		int firstPriorityCount = 0
		int secoundPriorityCount = 0
		def selectedSubjects = [] //empty list
		
		for (Subject s : subjects) {
			if (params['choice_' + s.id] > 0){
				if (params['choice_' + s.id] == "1") firstPriorityCount++
				if (params['choice_' + s.id] == "2") secoundPriorityCount++
				
				selectedSubjects.add(new SubjectChoice(student: session.user, subject: s, priority: params['choice_' + s.id]))
			}
		}
		/*subjects.each {
			if (params['choice_' + it.id] > 0){
				if (params['choice_' + it.id] == 1) firstPriorityCount++
				if (params['choice_' + it.id] == 2) secoundPriorityCount++
				
				selectedSubjects.add(new SubjectChoice(student: session.user, subject: it, priority: params['choice_' + it.id]))
			}
		}*/
		
		if (secoundPriorityCount == 2 && firstPriorityCount == 2) {
			selectedSubjects.each {
				//TODO make transaction
				it.save()
			}
			
			flash.message = "congrats, your choices were saved"
			redirect(controller: "SubjectChoice", action: 'list')
		}
		else {
			flash.message = "you need to choose 2 first priorities and 2 second ones"
			render(view: "votingRound1", model: [subjectInstances: subjects])
		}
	}
	
	//returns students sorted by their happiness
	def arrangeStudentsByHappiness(def students, def subjects){
		students.each { 
			def poolA = 3
			def poolB = 3
			
			//TODO: refactor
			for (SubjectChoice choice : it.subjectChoices){
				if (["A", "B"].contains(choice.subject.pool)){
					if (choice.subject.pool == "A"){
						if (poolA > choice.priority){
							poolA = choice.priority
						}
					}
					
					if (choice.subject.pool == "B"){
						if (poolB > choice.priority){
							poolB = choice.priority
							
						}
					}
				}
			}
			
			if (poolA == 1) it.happiness += 10
			if (poolA == 2) it.happiness += 5
			
			if (poolB == 1) it.happiness += 10
			if (poolB == 2) it.happiness += 5
		}
		
		students.sort{it.happiness}
		
		return students
	}
	
	def showRound1Results = {
		// get all the students who have made 2 first priority votes and 2 second priority votes

		def students = Users.findAllByType("student")


		// get the list of subjects
		def subjects = Subject.findAll()
		
		if (params["showResult"] || params["saveResult"]){
			subjects.each {
				it.pool = params["subjectPool_" + it.id]
			}
			
			students = arrangeStudentsByHappiness(students, subjects)
		}
		
		
		
		render(view: "showRound1Results", model: [students: students, subjects: subjects, poolOptions: Subject.allowedPools])
	}
	

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[subjectInstanceList: Subject.list(params), subjectInstanceTotal: Subject.count()]
	}

	def create() {
		[subjectInstance: new Subject(params)]
	}

	def save() {
		def subjectInstance = new Subject(params)
		if (!subjectInstance.save(flush: true)) {
			render(view: "create", model: [subjectInstance: subjectInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'subject.label', default: 'Subject'), subjectInstance.id])
		redirect(action: "show", id: subjectInstance.id)
	}

	def show() {
		def subjectInstance = Subject.get(params.id)
		if (!subjectInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'subject.label', default: 'Subject'), params.id])
			redirect(action: "list")
			return
		}

		[subjectInstance: subjectInstance]
	}

	def edit() {
		def subjectInstance = Subject.get(params.id)
		if (!subjectInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'subject.label', default: 'Subject'), params.id])
			redirect(action: "list")
			return
		}

		[subjectInstance: subjectInstance]
	}

	def update() {
		def subjectInstance = Subject.get(params.id)
		if (!subjectInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'subject.label', default: 'Subject'), params.id])
			redirect(action: "list")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (subjectInstance.version > version) {
				subjectInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'subject.label', default: 'Subject')] as Object[],
						  "Another user has updated this Subject while you were editing")
				render(view: "edit", model: [subjectInstance: subjectInstance])
				return
			}
		}

		subjectInstance.properties = params

		if (!subjectInstance.save(flush: true)) {
			render(view: "edit", model: [subjectInstance: subjectInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'subject.label', default: 'Subject'), subjectInstance.id])
		redirect(action: "show", id: subjectInstance.id)
	}

	def delete() {
		def subjectInstance = Subject.get(params.id)
		if (!subjectInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'subject.label', default: 'Subject'), params.id])
			redirect(action: "list")
			return
		}

		try {
			subjectInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'subject.label', default: 'Subject'), params.id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'subject.label', default: 'Subject'), params.id])
			redirect(action: "show", id: params.id)
		}
	}
}
