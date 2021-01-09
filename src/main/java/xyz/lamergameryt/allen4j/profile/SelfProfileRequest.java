package xyz.lamergameryt.allen4j.profile;

import xyz.lamergameryt.allen4j.APIEndpoint;
import xyz.lamergameryt.allen4j.Request;

public class SelfProfileRequest extends Request {
    /**
     * Set the value of the endpoint.
     */
    private SelfProfileRequest() {
        endpoint = APIEndpoint.SELF_PROFILE;
    }

    /**
     * @return An instance of this class.
     */
    public static SelfProfileRequest build() {
        return new SelfProfileRequest();
    }
}
