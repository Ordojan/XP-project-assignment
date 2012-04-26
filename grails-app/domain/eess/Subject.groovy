package eess

class Subject {
	String name
	String description
	
	
	static hasMany = [students: SubjectChoice]
	static hasOne = [owner: Users]

    static constraints = {
		name(nullable: false, blank: false)
		description(nullable:true)
		owner(nullable:true)
    }
	
	String toString(){
		return name
	}
}
