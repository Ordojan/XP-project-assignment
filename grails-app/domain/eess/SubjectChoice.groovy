package eess

import java.util.List;

class SubjectChoice {
	final static List<String> allowedPools=['A', 'B']
	
	int priority	//primary or secondary 
	String pool		//pool a or b or none
	
	static belongsTo = [student: Users, subject: Subject]

    static constraints = {
		pool(nullable: true, validator:{val ->
			if(!SubjectChoice.allowedPools.contains(val)) {
				return "Invalid pool"
			}
		})
    }
}
