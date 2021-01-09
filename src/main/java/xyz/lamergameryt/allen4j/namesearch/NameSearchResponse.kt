package xyz.lamergameryt.allen4j.namesearch

import org.json.JSONArray
import org.json.JSONObject
import xyz.lamergameryt.allen4j.Student

/**
 * The response received after searching for a student by his name.
 *
 * @constructor Internal use only. Not meant to be created from outside of this project.
 *
 * @param json The response received from the server in the form of a JSONObject.
 */
class NameSearchResponse internal constructor(private val json : JSONObject) {
    /**
     * The number of results available.
     */
    var totalResults = 0
        private set

    /**
     * The list of students received from allen's server.
     */
    var students = ArrayList<Student>()
        private set

    /**
     * The list of students in JSON Array form.
     */
    private var results : JSONArray

    /**
     * Set the value of `totalResults`, `students` and `results`.
     */
    init {
        totalResults = if (json.has("total")) json.getInt("total") else -1
        results = if (json.has("results")) json.getJSONArray("results") else JSONArray()

        var i = 0
        while (i < results.length()) {
            students.add(Student.getFromJsonObject(results.getJSONObject(i)))
            i++
        }
    }
}