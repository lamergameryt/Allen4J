package xyz.lamergameryt.allen4j

import org.apache.http.HttpEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.utils.URIBuilder
import org.json.JSONObject
import java.util.*
import kotlin.collections.HashMap

/**
 * Creates an instance of `HttpGet` containing the endpoint, the parameters and user authorization.
 *
 * @param url The endpoint to send the GET request to.
 * @param parameters The parameters included in the GET request.
 * @param authorization The authorization token of the user.
 * @return The GET Request object.
 */
internal fun getRequest(url: String, parameters: HashMap<String, String>, authorization: String): HttpGet {
    val builder = URIBuilder(url)
    for (s in parameters.keys) {
        builder.addParameter(s, parameters[s])
    }
    val httpGet = HttpGet(builder.build())
    httpGet.addHeader("Authorization", "Bearer $authorization")
    return httpGet
}

/**
 * Read the response received from the API and converts it into a `JSONObject`.
 *
 * @param entity The response received from the API.
 * @return The `JSONObject` contains the parsed json text.
 */
internal fun getJSONFromEntity(entity: HttpEntity): JSONObject {
    val sc = Scanner(entity.content)
    val json = StringBuilder()
    while (sc.hasNextLine()) {
        json.append(sc.nextLine())
    }
    return JSONObject(json.toString())
}