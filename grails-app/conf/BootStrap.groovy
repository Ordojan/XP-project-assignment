import eess.Users

class BootStrap {

    def init = { servletContext ->
		
		Users u = new Users(email: "test@test.com", password: "123")
		u.save();
		
    }
    def destroy = {
    }
}
