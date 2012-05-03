package eess

import java.util.List;

class Subject {
	final static List<String> allowedPools=['A', 'B', "None"]
	
	String name
	String description
	String pool = "None"
	
	
	static hasMany = [students: SubjectChoice]
	static hasOne = [owner: Users]

    static constraints = {
		name(nullable: false, blank: false)
		description(nullable:true)
		owner(nullable:true)
		pool(nullable: true, validator:{val ->
			if(!Subject.allowedPools.contains(val)) {
				return "Invalid pool"
			}
		})
    }
	
	String toString(){
		return name
	}
}
