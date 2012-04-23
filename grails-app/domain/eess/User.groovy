package eess

class User {

    static constraints = {
		email(unique:true)
		password(password:true)
    }
	
	String email
	String password
}
