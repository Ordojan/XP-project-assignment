package eess

class SubjectChoice {
	int priority	//primary or secondary 
	
	static belongsTo = [student: Users, subject: Subject]

    static constraints = {
    }
}
