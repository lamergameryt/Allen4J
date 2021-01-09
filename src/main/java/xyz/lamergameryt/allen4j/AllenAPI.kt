package xyz.lamergameryt.allen4j

import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import xyz.lamergameryt.allen4j.namesearch.NameSearchRequest
import xyz.lamergameryt.allen4j.namesearch.NameSearchResponse
import xyz.lamergameryt.allen4j.profile.SelfProfileRequest
import xyz.lamergameryt.allen4j.profile.SelfProfileResponse

/**
 * The `AllenAPI` class is the main class of Allen's API Wrapper. Used to perform most of the requests.
 *
 * @property baseURL The URL of Allen's API.
 * @property authorization Your authorization token used to send requests with.
 */
class AllenAPI(private val baseURL: String, private val authorization: String) {
    /**
     * The default httpclient used for all the requests that the wrapper makes.
     */
    private val httpClient : CloseableHttpClient = HttpClients.createDefault()

    /**
     * Search for a user by name
     *
     * @param request The request used to search for a user. Created by [NameSearchRequest.build] function.
     * @return Instance of [NameSearchResponse]
     */
    fun searchByName(request: NameSearchRequest): NameSearchResponse {
        val httpGet = getRequest(baseURL + request.endpoint, request.params, authorization)
        httpClient.execute(httpGet).use { r ->
            return NameSearchResponse(getJSONFromEntity(r.entity))
        }
    }

    /**
     * Get your own profile
     *
     * @param request The request used to get your own profile. Created by [SelfProfileRequest.build] function.
     * @return Instance of [SelfProfileResponse]
     */
    fun getSelfProfile(request: SelfProfileRequest): SelfProfileResponse {
        val httpGet = getRequest(baseURL + request.endpoint, request.params, authorization)
        httpClient.execute(httpGet).use { r ->
            return SelfProfileResponse(getJSONFromEntity(r.entity))
        }
    }
}