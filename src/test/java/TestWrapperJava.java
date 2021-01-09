import org.junit.jupiter.api.Test;
import xyz.lamergameryt.allen4j.AllenAPI;
import xyz.lamergameryt.allen4j.Student;
import xyz.lamergameryt.allen4j.namesearch.NameSearchRequest;
import xyz.lamergameryt.allen4j.namesearch.NameSearchResponse;
import xyz.lamergameryt.allen4j.profile.SelfProfileRequest;
import xyz.lamergameryt.allen4j.profile.SelfProfileResponse;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestWrapperJava {
    private final AllenAPI api = new AllenAPI(System.getenv("API"), System.getenv("AUTH_TOKEN"));

    @Test
    public void testSearchByName() {
        String name = "Het Naik";
        NameSearchResponse response = api.searchByName(NameSearchRequest.build(name, 1));

        // This result may change with time.
        assertEquals(response.getTotalResults(), 70, "The number of students found were not 70.");

        ArrayList<Student> students = response.getStudents();
        assertEquals(students.size(), 10);

        assertEquals(students.get(0).getFullname().toLowerCase(), name.toLowerCase());
    }

    @Test
    public void testSelfProfile() {
        SelfProfileResponse response = api.getSelfProfile(SelfProfileRequest.build());
        assertTrue(response.getProfile().isStudent());
        assertEquals(response.getProfile().getBatchId(), 13341);
    }
}
