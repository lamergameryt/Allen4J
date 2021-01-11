package xyz.lamergameryt.allen4j.schedule;

import org.json.JSONArray;
import xyz.lamergameryt.allen4j.templates.Lecture;

import java.util.ArrayList;
import java.util.List;

/**
 * The response received after requesting for upcoming schedule.
 */
public class SelfScheduleResponse {
    /**
     * The number of lectures found in your upcoming schedule.
     */
    private final int totalResults;

    /**
     * The list of upcoming lectures in your schedule.
     */
    private final List<Lecture> lectures = new ArrayList<>();

    /**
     * Parses the json response received from the server.
     *
     * @param json The response received from the server in form of a JSON Array.
     */
    public SelfScheduleResponse(JSONArray json) {
        totalResults = json.length();

        if (!json.isEmpty()) {
            for (int i = 0; i < totalResults; i++) {
                lectures.add(Lecture.getFromJSONObject(json.getJSONObject(i)));
            }
        }
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }
}
