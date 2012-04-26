package eess

class Subject {
	String name
	String description
	
	
	static hasMany = [students: SubjectChoice]
	static hasOne = [owner: Users]

    static constraints = {
    }
}
