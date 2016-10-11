package org.grails.recommendation

import org.grails.recommendation.auth.Person

class Status {
    String message
    Person author
    Date dateCreated
/*
    transient jmsService
    transient afterInsert = {
        jmsService.send 'grailsrecommendation.status', author.username
    }
    */
}
