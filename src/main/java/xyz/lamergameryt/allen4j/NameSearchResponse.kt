package xyz.lamergameryt.allen4j

import org.json.JSONArray
import org.json.JSONObject

class NameSearchResponse internal constructor(json : JSONObject) {
    var totalResults = 0
        private set

    var students = ArrayList<Student>()
        private set

    private var results : JSONArray?

    init {
        totalResults = if (json.has("total")) json.getInt("total") else -1
        results = if (json.has("results")) json.getJSONArray("results") else null

        if (results != null) {
            results?.toList()?.forEach { r -> if (r is JSONObject) students.add(Student.getFromJsonObject(r)) }
        }
    }
}