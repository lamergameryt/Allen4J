package xyz.lamergameryt.allen4j

enum class APIEndpoint(private val endpoint: String) {
    STUDENT_PROFILE("/user/profile/%s"), SELF_PROFILE("/user/profile/"), SEARCH("/globalsearch/2");

    override fun toString(): String {
        return endpoint
    }
}