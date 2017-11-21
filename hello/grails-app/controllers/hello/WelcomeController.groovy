package hello

class WelcomeController {

    def index() {
        redirect(action: 'greet', params: params)
    }

    def greet(String name) {
        String n = name ?: 'World'
        render "<h2>Hello, ${n}!</h2>"
    }

    def hi() {
        String n = params.name ?: 'World'
        [user:n]
    }
}
