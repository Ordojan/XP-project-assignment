package eess

class Users {

    static constraints = {
		email(unique:true)
		password(password:true)
    }
	
	String email
	String password
}
