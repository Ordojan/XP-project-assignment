package eess

import java.util.List;

class SubjectChoice {
	
	int round
	
	int priority	//primary or secondary 
	
	static belongsTo = [student: Users, subject: Subject]

    static constraints = {
		
    }
}
