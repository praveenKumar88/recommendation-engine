package org.grails.recommendation

import org.grails.recommendation.auth.Person

class recommendationSecurityService {

    def springSecurityService

    Person getCurrentUser() {
        Person.findByUserName(springSecurityService.principal.username)
    }
}
