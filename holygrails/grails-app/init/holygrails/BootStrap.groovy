package holygrails

import com.oreilly.Castle
import com.oreilly.GeocoderService
import com.oreilly.Quest

class BootStrap {
    GeocoderService geocoderService

    def init = { servletContext ->
        Quest q = new Quest(name: 'Seek the grail')
                .addToTasks(name: 'Run away from killer rabbit')
                .addToTasks(name: 'Answer the Bridge Keeper', priority: 4)
                .addToTasks(name: 'Defeat the Black Knight', completed: true)
                .save()
        Castle camelot = new Castle(name: 'Camelot', city: 'Boston', state: 'MA')
                .addToKnights(title: 'King', name: 'Arthur', quest: q)
                .addToKnights(title: 'Sir', name: 'Lancelot', quest: q)
                .addToKnights(title: 'Sir', name: 'Robin', quest: q)
        geocoderService.fillInLatLng(camelot)
                .save()

        Castle swamp = new Castle(name: 'Swamp', city: 'Framingham', state: 'MA')
        geocoderService.fillInLatLng(swamp).save()
    }
    def destroy = {
    }
}
