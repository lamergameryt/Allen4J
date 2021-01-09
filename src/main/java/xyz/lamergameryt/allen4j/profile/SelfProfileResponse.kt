package xyz.lamergameryt.allen4j.profile

import org.json.JSONObject
import xyz.lamergameryt.allen4j.Student

class SelfProfileResponse internal constructor(json : JSONObject) {
    /**
     * Your profile information wrapped in the [Student] class.
     */
    var profile : Student
        private set

    /**
     * Set the value of `profile`.
     */
    init {
        profile = Student.getFromJsonObject(json)
    }
}