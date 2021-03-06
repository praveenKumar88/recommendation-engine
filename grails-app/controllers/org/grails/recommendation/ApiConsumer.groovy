package org.grails.recommendation

import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.HttpResponseException
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.util.EntityUtils

class ApiConsumer {

    static def postText() {
            HttpClient httpClient = new DefaultHttpClient()
            HttpResponse response
            try {
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
                String responseString = EntityUtils.toString(entity, "UTF-8");
                return responseString;
            } catch (HttpResponseException ex) {
                println "POST Success"
                ex.printStackTrace()
                return ex.message
            } catch (ConnectException ex) {
                ex.printStackTrace()
                return null
            }
        }
    }

