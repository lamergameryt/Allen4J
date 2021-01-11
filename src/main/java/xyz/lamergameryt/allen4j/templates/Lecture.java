package xyz.lamergameryt.allen4j.templates;

import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Lecture class contains most of the information regarding a lecture sent by Allen's server.
 */
public class Lecture {
    private final LocalDateTime startTime, endTime;
    private final String professor, subject, topic, institute;
    private final int professorId, duration;
    private final boolean active;

    /**
     * The constructor for the Lecture class. The constructor is private as a custom lecture cannot be created directly.
     * 
     * @param startTime The time the lecture starts. 
     * @param endTime The time the lecture ends.
     * @param professor The name of the professor teaching the lecture.
     * @param subject The subject being taught.
     * @param topic The topic being taught.
     * @param institute The department which is teaching the lecture.
     * @param professorId The id of the professor teaching the lecture.
     * @param duration The duration of the lecture. (in seconds)
     * @param active Is the lecture on going?
     */
    private Lecture(LocalDateTime startTime, LocalDateTime endTime, String professor, String subject, String topic, String institute, int professorId, int duration, boolean active) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.professor = professor;
        this.subject = subject;
        this.topic = topic;
        this.institute = institute;
        this.professorId = professorId;
        this.duration = duration;
        this.active = active;
    }

    /**
     * Get an instance of the Lecture class.
     *
     * @param json The JSON Object contains the information regarding the lecture.
     * @return An instance of this class.
     */
    public static Lecture getFromJSONObject(JSONObject json) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        JSONObject lectureInfo = json.getJSONObject("lectureInfo");

        return new Lecture(LocalDateTime.from(format.parse(json.getString("startTime"))), LocalDateTime.from(format.parse(json.getString("endTime"))),
                lectureInfo.getString("professorName").trim(), lectureInfo.getString("subjectName"),
                lectureInfo.getString("topic"), lectureInfo.getString("institute"), lectureInfo.getInt("professorId"),
                lectureInfo.getInt("actualDuration"), lectureInfo.getInt("active") == 1);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getProfessor() {
        return professor;
    }

    public String getSubject() {
        return subject;
    }

    public String getTopic() {
        return topic;
    }

    public String getInstitute() {
        return institute;
    }

    public int getProfessorId() {
        return professorId;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isActive() {
        return active;
    }
}
