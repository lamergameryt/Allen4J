package xyz.lamergameryt.allen4j.namesearch;

import org.json.JSONArray;
import org.json.JSONObject;
import xyz.lamergameryt.allen4j.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * The response received after searching for a student by his name.
 */
public class NameSearchResponse {
    /**
     * The number of students found with their name similar to the name provided.
     */
    private final int totalResults;

    /**
     * The list of students received from allen's server.
     */
    private final List<Student> students = new ArrayList<>();

    /**
     * Parse the json response received from the server.
     *
     * @param json The response received from the server in the form of a JSONObject.
     */
     public NameSearchResponse(JSONObject json) {
        this.totalResults = json.has("total") ? json.getInt("total") : -1;
        JSONArray results = json.has("results") ? json.getJSONArray("results") : null;

         if (results != null) {
             for (int i = 0; i < results.length(); i++) {
                 students.add(Student.getFromJSONObject(results.getJSONObject(i)));
             }
         }
     }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Student> getStudents() {
        return students;
    }
}
