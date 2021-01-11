import org.junit.jupiter.api.Test;
import xyz.lamergameryt.allen4j.AllenAPI;
import xyz.lamergameryt.allen4j.namesearch.NameSearchRequest;
import xyz.lamergameryt.allen4j.namesearch.NameSearchResponse;
import xyz.lamergameryt.allen4j.profile.SelfProfileRequest;
import xyz.lamergameryt.allen4j.profile.SelfProfileResponse;
import xyz.lamergameryt.allen4j.schedule.SelfScheduleRequest;
import xyz.lamergameryt.allen4j.schedule.SelfScheduleResponse;
import xyz.lamergameryt.allen4j.templates.Student;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestWrapperJava {
    private final AllenAPI api = new AllenAPI(System.getenv("API"), System.getenv("AUTH_TOKEN"));

    @Test
    public void testSearchByName() throws IOException, URISyntaxException {
        String name = "Het Naik";
        NameSearchResponse response = api.searchByName(NameSearchRequest.build(name, 1));
        List<Student> students = response.getStudents();

        // This result may change with time.
        assertEquals(70, response.getTotalResults(), "The number of students found were not 70.");
        assertEquals(10, students.size());
        assertEquals(name.toLowerCase(), students.get(0).getFullName().toLowerCase());
        System.out.println(students.get(0).getUserId());
    }

    @Test
    public void testSelfProfile() throws IOException, URISyntaxException {
        SelfProfileResponse response = api.getSelfProfile(SelfProfileRequest.build());
        assertTrue(response.getProfile().isStudent());
        assertEquals(13341, response.getProfile().getBatchId());
    }

    @Test
    public void testSelfSchedule() throws IOException, URISyntaxException {
        SelfScheduleResponse response = api.getSelfSchedule(SelfScheduleRequest.build(LocalDateTime.now()));
        assertNotEquals(0, response.getTotalResults());
    }
}
