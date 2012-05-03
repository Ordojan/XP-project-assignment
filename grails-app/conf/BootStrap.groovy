import eess.Subject
import eess.SubjectChoice
import eess.Users

class BootStrap {

    def init = { servletContext ->
		
		//users
		def u1 = new Users(name: "Bjarke Carlsen", email: "test1@email.com", password: "1")
		u1.save()
		
		def u2 = new Users(name: "Emil Christiansen", email: "test2@email.com", password: "2")
		u2.save()
		
		def u3 = new Users(name: "Jesper Dahl", email: "test3@email.com", password: "2")
		u3.save()
		
		def u4 = new Users(name: "Kenn Jacobsen", email: "test4@email.com", password: "2")
		u4.save()
		
		def u5 = new Users(name: "Aske rode", email: "test5@email.com", password: "2")
		u5.save()
		
		def u6 = new Users(name: "Thor Kristensen", email: "test6@email.com", password: "2")
		u6.save()
		
		//subjects
		def s1 = new Subject(name: "C#", owner: u1)
		s1.save()
		
		def s2 = new Subject(name: "Algorithms", owner: u1)
		s2.save()
		
		def s3 = new Subject(name: "Apps and innovation")
		s3.save()
		
		def s4 = new Subject(name: "HCI")
		s4.save()
		
		def s5 = new Subject(name: "Globalization")
		s5.save()
		
		def s6 = new Subject(name: "Databases")
		s6.save()
		
		def s7 = new Subject(name: "Test")
		s7.save()
		
		def s8 = new Subject(name: "Project management")
		s8.save()
		
		// Test data for User Story 4
		
		def sc = new SubjectChoice(student: u1, priority: 1, subject: s1)
		sc.save()
		
		sc = new SubjectChoice(student: u1, priority: 1, subject: s4)
		sc.save()
		
		sc = new SubjectChoice(student: u1, priority: 2, subject: s2)
		sc.save()
		
		sc = new SubjectChoice(student: u1, priority: 2, subject: s3)
		sc.save()
		
		sc = new SubjectChoice(student: u2, priority: 1, subject: s4)
		sc.save()
		
		sc = new SubjectChoice(student: u2, priority: 1, subject: s8)
		sc.save()
		
		sc = new SubjectChoice(student: u2, priority: 2, subject: s6)
		sc.save()
		
		sc = new SubjectChoice(student: u2, priority: 2, subject: s7)
		sc.save()
		
		sc = new SubjectChoice(student: u3, priority: 1, subject: s3)
		sc.save()
		
		sc = new SubjectChoice(student: u3, priority: 1, subject: s5)
		sc.save()
		
		sc = new SubjectChoice(student: u3, priority: 2, subject: s1)
		sc.save()
		
		sc = new SubjectChoice(student: u3, priority: 2, subject: s6)
		sc.save()
		
		sc = new SubjectChoice(student: u4, priority: 1, subject: s2)
		sc.save()
		
		sc = new SubjectChoice(student: u4, priority: 1, subject: s8)
		sc.save()
		
		sc = new SubjectChoice(student: u4, priority: 2, subject: s4)
		sc.save()
		
		sc = new SubjectChoice(student: u4, priority: 2, subject: s7)
		sc.save()
		
    }
    def destroy = {
    }
}
