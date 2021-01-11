package xyz.lamergameryt.allen4j.templates;

import xyz.lamergameryt.allen4j.APIEndpoint;

import java.util.HashMap;

public abstract class Request {
    /**
     * The endpoint of the request that will be accessed.
     */
    protected APIEndpoint endpoint;

    /**
     * The parameters used with the request.
     */
    protected final HashMap<String, String> params = new HashMap<>();

    /**
     * Returns the API endpoint of the request.
     *
     * @return The API Endpoint.
     */
    public APIEndpoint getEndpoint() {
        return endpoint;
    }

    /**
     * Get the parameters to include with the request.
     *
     * @return The HashMap of params.
     */
    public HashMap<String, String> getParams() {
        return params;
    }
}