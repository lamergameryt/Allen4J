package xyz.lamergameryt.allen4j.templates;

import org.json.JSONObject;

/**
 * The Student class contains most of the data of the student which is sent by Allen's API.
 */
public class Student {
    private final String fullName, courseName, formNumber, pic;
    private final int batchId, userType, userId;

    /**
     * The constructor for the Student class. The constructor is private as a custom student cannot be created directly.
     *
     * @param fullName The full name of the student.
     * @param courseName The name of the course the student is enrolled in.
     * @param formNumber The form number of the student (this is the email id in case the student is actually a teacher)
     * @param pic The profile picture of the student.
     * @param batchId The batch id of the student.
     * @param userType The integer value of the user type.
     */
    private Student(String fullName, String courseName, String formNumber, String pic, int batchId, int userType, int userId) {
        this.fullName = fullName;
        this.courseName = courseName;
        this.formNumber = formNumber;
        this.pic = pic;
        this.batchId = batchId;
        this.userType = userType;
        this.userId = userId;
    }

    /**
     * Get an instance of the Student class.
     *
     * @param json The JSONObject containing the data of the student.
     * @return A instance of the Student class.
     */
    public static Student getFromJSONObject(JSONObject json) {
        return new Student(json.getString("fullname").trim(), json.getString("courseName"),
                json.getString("email"), json.getString("pic"), json.getInt("batchId"),
                json.getInt("userType"), json.getInt("userId"));
    }

    /**
     * Check if the student received is actually student or some other faculty member.
     *
     * @return true if the student is actually a student, else false.
     */
    public boolean isStudent() {
        return userType == 6;
    }

    /**
     * Check if the student's email is his form number of not.
     *
     * @return true if the student's email is his form number, else false.
     */
    public boolean hasFormNumber() {
        try {
            Long.parseLong(formNumber);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getFormNumber() {
        return formNumber;
    }

    public String getPic() {
        return pic;
    }

    public int getBatchId() {
        return batchId;
    }

    public int getUserType() {
        return userType;
    }

    public int getUserId() {
        return userId;
    }
}
