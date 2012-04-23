import eess.User

class BootStrap {

    def init = { servletContext ->
		
		User u = new User(email: "test@test.com", password: "123")
		u.save();
		
    }
    def destroy = {
    }
}
