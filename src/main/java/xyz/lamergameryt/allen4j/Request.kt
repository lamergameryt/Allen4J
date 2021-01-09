package xyz.lamergameryt.allen4j

abstract class Request internal constructor() {
    /**
     * The endpoint of the request that will be accessed.
     */
    abstract val endpoint: APIEndpoint

    /**
     * The parameters used with the request.
     */
    val params: HashMap<String, String> = HashMap()
}