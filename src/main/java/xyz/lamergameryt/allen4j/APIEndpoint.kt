package xyz.lamergameryt.allen4j

/**
 * The `APIEndpoint` enum contains all the endpoints that the Allen API has.
 *
 * @property endpoint The link to the endpoint.
 */
enum class APIEndpoint(private val endpoint: String) {
    STUDENT_PROFILE("/user/profile/%s"), SELF_PROFILE("/user/profile/"), SEARCH("/globalsearch/2");

    /**
     * Returns the enum, converted to api endpoint url.
     *
     * @return The respective api endpoint.
     */
    override fun toString(): String {
        return endpoint
    }
}