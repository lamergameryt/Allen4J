package xyz.lamergameryt.allen4j

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients

class AllenAPI(private val baseURL: String, private val authorization: String) {
    private val httpClient : CloseableHttpClient = HttpClients.createDefault()

    fun searchByName(request: NameSearchRequest): NameSearchResponse {
        val httpGet = HttpGet(getURI(baseURL + request.endpoint, request.params))
        httpClient.execute(httpGet).use { r ->
            return NameSearchResponse(getJSONFromEntity(r.entity))
        }
    }
}