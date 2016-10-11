package org.grails.recommendation

import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.util.EntityUtils
import org.grails.recommendation.auth.Person

class TimelineService {

    void clearTimelineCacheForUser(String username) {}

    def getTimelineForUser(String username) {
        def per = Person.where {
            userName == username
        }.find()

        def query = Status.whereAny {
            author {
                userName == per.userName
            }
            if(per.followed) author in per.followed
        }.order 'dateCreated', 'desc'

        HttpClient httpClient = new DefaultHttpClient()
        HttpResponse response
        HttpPost httpPost = new HttpPost("http://metasearch.int-maui.karmalab.net/OrdersByCustomerEmailAddress")
        httpPost.setHeader("Content-Type", "application/json")
        httpPost.setHeader("client-id", "7424EECF-7523-496B-AF19-B810F950F1CC")
        String data ="{\"parameters\": [{\"CustomerEmailAddress\": \"test@expedia.com\"}]}"
        HttpEntity reqEntity = new StringEntity(data, "UTF-8")
        reqEntity.setContentType("application/json")
        reqEntity.setChunked(true)
        httpPost.setEntity(reqEntity)
        response = httpClient.execute(httpPost)
        HttpEntity entity = response.getEntity();
        def messages = EntityUtils.toString(entity, "UTF-8");

//        def messages = query.list(max: 10)

        messages
    }
}
