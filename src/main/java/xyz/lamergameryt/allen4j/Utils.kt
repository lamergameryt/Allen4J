package xyz.lamergameryt.allen4j

import org.apache.http.HttpEntity
import org.apache.http.client.utils.URIBuilder
import org.json.JSONObject
import java.net.URI
import java.util.*
import kotlin.collections.HashMap

internal fun getURI(url: String, parameters: HashMap<String, String>): URI {
    val builder = URIBuilder(url)
    for (s in parameters.keys) {
        builder.addParameter(s, parameters[s])
    }
    return builder.build()
}

internal fun getJSONFromEntity(entity: HttpEntity): JSONObject {
    val sc = Scanner(entity.content)
    val json = StringBuilder()
    while (sc.hasNextLine()) {
        json.append(sc.nextLine())
    }
    return JSONObject(json.toString())
}