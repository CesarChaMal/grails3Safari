package com.oreilly

import grails.gorm.transactions.Transactional

@Transactional
class GeocoderService {

    Castle fillInLatLng(Castle castle) {
        String base = 'http://maps.googleapis.com/maps/api/geocode/xml?'
        String encoded = [castle.city, castle.state].collect {
            URLEncoder.encode(it, 'UTF-8')
        }.join(',')
        String qs = "address=$encoded"
        def root = new XmlSlurper().parse("$base$qs")
        def loc = root.result[0].geometry.location
        castle.latitude = loc.lat.toDouble()
        castle.longitude = loc.lng.toDouble()
        castle
    }
}
