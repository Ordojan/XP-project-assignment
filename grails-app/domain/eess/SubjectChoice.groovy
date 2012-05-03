package eess

import java.util.List;

class SubjectChoice {
	
	
	int priority	//primary or secondary 
	
	static belongsTo = [student: Users, subject: Subject]

    static constraints = {
		
    }
}
