package eess

class Users {
	final static List<String> allowedTypes=['head master', 'student', 'teacher']
	
	String name
	String type = 'student'
	
	String email
	String password
	
	int happiness = 0
	
	static transients = ["happiness"]
	
	static hasMany = [proposedSubjects: Subject, subjectChoices: SubjectChoice]
	
    static constraints = {
		email(unique:true)
		password(password:true)
		
		type(validator:{val ->
			if(!Users.allowedTypes.contains(val)) {
				return "Invalid type"
			}
		})
    }
	
	String toString(){
		return name
	}
}
