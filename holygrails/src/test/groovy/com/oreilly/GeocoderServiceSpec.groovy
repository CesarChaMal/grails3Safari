package com.oreilly

import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class GeocoderServiceSpec extends Specification implements ServiceUnitTest<GeocoderService>,
        DomainUnitTest<Castle> {

    void 'verify lat,lng from Mountain View, CA'() {
        given:
        Castle google = new Castle(name: 'Google', city: 'Mountain View', state: 'CA')

        when:
        service.fillInLatLng(google)

        then:
        (google.latitude - 37.4).abs() < 0.1
        (google.longitude - -122.1).abs() < 0.1
    }
}
