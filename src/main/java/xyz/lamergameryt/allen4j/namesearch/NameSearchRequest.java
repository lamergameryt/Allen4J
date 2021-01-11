package xyz.lamergameryt.allen4j.namesearch;

import xyz.lamergameryt.allen4j.APIEndpoint;
import xyz.lamergameryt.allen4j.templates.Request;

/**
 * The NameSearchRequest class is used to perform a request that searches for a student based on his name.
 */
public class NameSearchRequest extends Request {
    /**
     * Set the value of name, page, endpoint and the parameters.
     *
     * @param name The name of the student to search for.
     * @param page The page number of the page to search the student.
     */
    private NameSearchRequest(String name, int page) {
        endpoint = APIEndpoint.SEARCH;
        params.put("mode", "0000000000");
        params.put("pageNumber", Integer.toString(page));
        params.put("q", name);
    }

    /**
     * Builds an instance of the NameSearchRequest class.
     *
     * @param name The name of the student to search for.
     * @param page The page number of the page to search the student.
     * @return An instance of this class.
     */
    public static NameSearchRequest build(String name, int page) {
        return new NameSearchRequest(name, page);
    }
}
