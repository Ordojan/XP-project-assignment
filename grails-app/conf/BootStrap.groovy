import eess.Subject
import eess.Users

class BootStrap {

    def init = { servletContext ->
		
		//users
		def u = new Users(name: "Bjarke Carlsen", email: "test1@email.com", password: "1")
		u.save()
		
		u = new Users(name: "Emil Christiansen", email: "test2@email.com", password: "2")
		u.save()
		
		u = new Users(name: "Jesper Dahl", email: "test3@email.com", password: "2")
		u.save()
		
		u = new Users(name: "Kenn Jacobsen", email: "test4@email.com", password: "2")
		u.save()
		
		u = new Users(name: "Aske rode", email: "test5@email.com", password: "2")
		u.save()
		
		u = new Users(name: "Thor Kristensen", email: "test6@email.com", password: "2")
		u.save()
		
		//subjects
		def s = new Subject(name: "C#", owner: u)
		s.save()
		
		s = new Subject(name: "Algorithms", owner: u)
		s.save()
		
		s = new Subject(name: "Apps and innovation")
		s.save()
		
		s = new Subject(name: "HCI")
		s.save()
		
		s = new Subject(name: "Globalization")
		s.save()
		
		s = new Subject(name: "Databases")
		s.save()
		
		s = new Subject(name: "Test")
		s.save()
		
		s = new Subject(name: "Project management")
		s.save()
		
		
    }
    def destroy = {
    }
}
