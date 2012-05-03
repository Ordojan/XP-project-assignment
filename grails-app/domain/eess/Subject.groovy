package eess

import java.util.List;

class Subject {
	final static List<String> allowedPools=['A', 'B']
	
	String name
	String description
	String pool
	
	
	static hasMany = [students: SubjectChoice]
	static hasOne = [owner: Users]

    static constraints = {
		name(nullable: false, blank: false)
		description(nullable:true)
		owner(nullable:true)
		pool(nullable: true, validator:{val ->
			if(!SubjectChoice.allowedPools.contains(val)) {
				return "Invalid pool"
			}
		})
    }
	
	String toString(){
		return name
	}
}
