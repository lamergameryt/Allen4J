package xyz.lamergameryt.allen4j.schedule;

import xyz.lamergameryt.allen4j.APIEndpoint;
import xyz.lamergameryt.allen4j.templates.Request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The SelfScheduleRequest class is used to perform a request that gets your upcoming schedule.
 */
public class SelfScheduleRequest extends Request {
    /**
     * Set the value of starting date and ending date in the parameters of the request.
     *
     * @param startDate The date to see your schedule from.
     */
    private SelfScheduleRequest(LocalDateTime startDate) {
        endpoint = APIEndpoint.SELF_SCHEDULE;

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        params.put("start", startDate.format(format));
        params.put("end", startDate.plusDays(7).format(format));
    }

    /**
     * Builds an instance of the SelfScheduleRequest.
     * @param startDate The date to see your schedule from.
     * @return An instance of this class.
     */
    public static SelfScheduleRequest build(LocalDateTime startDate) {
        return new SelfScheduleRequest(startDate);
    }
}
