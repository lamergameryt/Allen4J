package xyz.lamergameryt.allen4j

import org.json.JSONObject

/**
 * The `Student` class contains most of the data of the student which is sent by Allen's API.
 *
 * @property fullname The full name of the student.
 * @property courseName The name of the course the student is enrolled in.
 * @property formNumber The form number of the student (this is the email id in case the student is actually a teacher)
 * @property pic The profile picture of the student.
 * @property batchId The batch id of the student.
 * @property userType The integer value of the user type.
 */
class Student private constructor(val fullname: String, val courseName: String, val formNumber: String,
                                  private val pic: String, val batchId: Int, private val userType: Int) {
    companion object {
        /**
         * Get an instance of the `Student` class.
         *
         * @param json The JSONObject containing the data of the student.
         * @return A instance of the `Student` class.
         */
        @JvmStatic
        internal fun getFromJsonObject(json: JSONObject) : Student {
            return Student(fullname = json.getString("fullname").trim(), courseName = json.getString("courseName"),
                formNumber = json.getString("email"), pic = json.getString("pic"), batchId = json.getInt("batchId"),
                userType = json.getInt("userType"))
        }
    }

    /**
     * Check if the student received is actually student or some other faculty member.
     *
     * @return true if the student is actually a student, else false.
     */
    fun isStudent() : Boolean {
        return userType == 6
    }

    /**
     * Check if the student's email is his form number of not.
     *
     * @return true if the student's email is his form number, else false.
     */
    fun hasFormNumber() : Boolean {
        return formNumber.toLongOrNull() != null
    }
}