package xyz.lamergameryt.allen4j.namesearch

import xyz.lamergameryt.allen4j.APIEndpoint
import xyz.lamergameryt.allen4j.Request

/**
 * The `NameSearchRequest` class is used to perform a request that searches for a student based on his name.
 *
 * @param name The name of the student to search for.
 * @param page The page number of the page to search the student.
 */
class NameSearchRequest private constructor(name: String, page: Int): Request() {
    companion object {
        /**
         * Creates an instance of this class with the student's name and the page number to search.
         *
         * @param name The name of the student to search for.
         * @param pageThe page number of the page to search the student.
         * @return Instance of [NameSearchRequest]
         */
        @JvmStatic
        fun build(name: String, page: Int): NameSearchRequest {
            return NameSearchRequest(name, page)
        }
    }

    /**
     * The endpoint of the [NameSearchRequest] request.
     */
    override val endpoint = APIEndpoint.SEARCH

    /**
     * Add all the parameters required by endpoint to the params HashMap.
     */
    init {
        params["mode"] = "0000000000";
        params["pageNumber"] = page.toString()
        params["q"] = name
    }
}