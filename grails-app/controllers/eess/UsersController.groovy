package eess

class UsersController {
	def scaffold = Users

	def beforeInterceptor = [action:this.&auth, except:[
			"login",
			"authenticate",
			"logout"
		]]

	def auth() {
		if(!session.user) {
			redirect(controller:"users", action:"login")
			return false
		}
	}

	def index = { render ("howdy") }

	def login = {}

	def authenticate = {
		def user = Users.findByEmailAndPassword(params.email, params.password)
		if(user){
			log.debug "found it"
			session.user = user
			flash.message = "Hello ${user.email}!"
			redirect(action:"index")
		}
		else{
			log.debug "didn't find it: ${params.email} ${params.password}"
			flash.message = "Couldn't find you. Try again."
			redirect(action:"login")
		}
	}

	def logout = {
		flash.message = "Goodbye ${session.user.email}"
		session.user = null
		redirect(action:"login")
	}

}
