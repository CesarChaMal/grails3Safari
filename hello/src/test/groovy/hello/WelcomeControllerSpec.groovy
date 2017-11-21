package hello

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class WelcomeControllerSpec extends Specification implements ControllerUnitTest<WelcomeController> {

    void 'greet without name returns Hello, World!'() {
        when:
        controller.greet()

        then:
        response.text == '<h2>Hello, World!</h2>'
    }

    void 'greet with a name returns Hello, name!'() {
        when:
        controller.greet('Dolly')

        then:
        response.text == '<h2>Hello, Dolly!</h2>'
    }

    void 'index without a name redirects to greet without a name'() {
        when:
        controller.index()

        then:
        response.redirectedUrl == '/welcome/greet'
    }

    void 'index with a name redirects to greet with a name'() {
        when:
        params.name = 'Dolly'
        controller.index()

        then:
        response.redirectedUrl == '/welcome/greet?name=Dolly'
    }

    void 'hi without a name returns map with user=World'() {
        when:
        Map model = controller.hi()

        then:
        model.user == 'World'
    }

    void 'hi with a name returns map with user=name'() {
        when:
        params.name = 'Dolly'
        Map model = controller.hi()

        then:
        model.user == 'Dolly'
    }
}
