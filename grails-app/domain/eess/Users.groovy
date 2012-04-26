package eess

class Users {
	String email
	String password
	
	static hasMany = [proposedSubjects: Subject, subjectChoices: SubjectChoice]
	
    static constraints = {
		email(unique:true)
		password(password:true)
    }
}
