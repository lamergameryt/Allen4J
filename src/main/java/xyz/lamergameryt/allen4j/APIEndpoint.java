package xyz.lamergameryt.allen4j;

/**
 * The APIEndpoint enum contains all the endpoints that the Allen API has.
 */
public enum APIEndpoint {
    STUDENT_PROFILE("/user/profile/%s"),
    SELF_PROFILE("/user/profile/"),
    SEARCH("/globalsearch/2");

    /**
     * Holds the value of the endpoint.
     */
    private final String endpoint;

    /**
     * @param endpoint The link to the endpoint.
     */
    APIEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Returns the enum, converted to api endpoint url.
     *
     * @return The respective api endpoint.
     */
    @Override
    public String toString() {
        return endpoint;
    }
}