package xyz.lamergameryt.allen4j.profile;

import org.json.JSONObject;
import xyz.lamergameryt.allen4j.Student;

public class SelfProfileResponse {
    /**
     * The profile information of the user wrapped in the {@link xyz.lamergameryt.allen4j.Student} class.
     */
    private final Student profile;

    /**
     * Parses the json response received from the server.
     * @param json The response received from the server in the form of a JSONObject
     */
    public SelfProfileResponse(JSONObject json) {
        this.profile = Student.getFromJSONObject(json);
    }

    public Student getProfile() {
        return profile;
    }
}
