package com.oreilly

import groovy.transform.ToString

@ToString(includes = ['name', 'priority', 'completed'])
class Task {
    String name
    int priority = 3
    Date startDate = new Date()
    Date endDate = new Date()
    boolean completed

    int getDuration(){
        endDate - startDate + 1
    }

    static transients = ['duration']

    static belongsTo = [quest: Quest]

    static constraints = {
        name(blank: false)
        priority range: 1..5
        startDate()
        endDate validator: { val, task ->
            val >= task.startDate
        }
        completed()
    }
}
