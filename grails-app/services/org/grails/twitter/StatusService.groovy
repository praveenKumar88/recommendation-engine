package org.grails.recommendation

import org.grails.recommendation.auth.Person

class StatusService {

    def recommendationSecurityService
    def timelineService
    
    void clearTimelineCacheForUser(newMessageUserName) {
        log.debug "Message received. New status message posted by user <${newMessageUserName}>."
        def following = Person.where {
            followed.userName == newMessageUserName
        }.property('username').list()

        following.each { uname ->
            timelineService.clearTimelineCacheForUser(uname)
        }
    }

    void updateStatus(String message) {
        def status = new Status(message: message)
        status.author = recommendationSecurityService.currentUser
        status.save()
        timelineService.clearTimelineCacheForUser(status.author.userName)
    }

    void unfollow(String userName) {
        def person = Person.findByUserName(userName)
        if (person) {
            def currentUser = recommendationSecurityService.currentUser
            currentUser.removeFromFollowed(person)
            timelineService.clearTimelineCacheForUser(currentUser.userName)
        }
    }

    void follow(String userName) {
        def person = Person.findByUserName(userName)
        if (person) {
            def currentUser = recommendationSecurityService.currentUser
            currentUser.addToFollowed(person)
            timelineService.clearTimelineCacheForUser(currentUser.userName)
        }
    }
}
