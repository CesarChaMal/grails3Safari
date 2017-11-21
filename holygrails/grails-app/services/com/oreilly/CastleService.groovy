package com.oreilly

import grails.gorm.services.Service

@Service(Castle)
interface CastleService {

    Castle get(Serializable id)

    List<Castle> list(Map args)

    Long count()

    void delete(Serializable id)

    Castle save(Castle castle)

}