package xyz.lamergameryt.allen4j

import org.json.JSONObject

class Student private constructor(val fullname: String, val courseName: String, val formNumber: String,
                                  private val pic: String, val batchId: Int, private val userType: Int) {
    companion object {
        @JvmStatic
        internal fun getFromJsonObject(json: JSONObject) : Student {
            return Student(fullname = json.getString("fullname"), courseName = json.getString("courseName"),
                formNumber = json.getString("email"), pic = json.getString("pic"), batchId = json.getInt("batchId"),
                userType = json.getInt("userType"))
        }
    }

    fun isTeacher() : Boolean {
        return userType != 6
    }

    fun hasFormNumber() : Boolean {
        return formNumber.toLongOrNull() != null
    }
}