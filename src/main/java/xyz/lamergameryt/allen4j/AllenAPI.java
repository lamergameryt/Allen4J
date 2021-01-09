package xyz.lamergameryt.allen4j;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import xyz.lamergameryt.allen4j.namesearch.NameSearchRequest;
import xyz.lamergameryt.allen4j.namesearch.NameSearchResponse;
import xyz.lamergameryt.allen4j.profile.SelfProfileRequest;
import xyz.lamergameryt.allen4j.profile.SelfProfileResponse;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * The AllenAPI class is the main class of Allen's API Wrapper. Used to perform most of the requests.
 */
public class AllenAPI {
    /**
     * Store the API url passed through the constructor.
     */
    private final String baseURL;

    /**
     * Store the user's authorization token.
     */
    private final String authorization;

    /**
     * The default httpclient used for all the requests that the wrapper makes.
     */
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * @param baseURL The url of Allen's API.
     * @param authorization The authorization token used to send requests with.
     */
    public AllenAPI(String baseURL, String authorization) {
        this.baseURL = baseURL;
        this.authorization = authorization;
    }

    /**
     * Search for a user by name
     *
     * @param request The request used to search for a user. Created by {@link xyz.lamergameryt.allen4j.namesearch.NameSearchRequest#build(String, int)} function.
     * @return Instance of {@link xyz.lamergameryt.allen4j.namesearch.NameSearchResponse}
     * @throws IOException The connection could not be established.
     * @throws URISyntaxException This will most likely be thrown when the baseURL is invalid.
     */
    public NameSearchResponse searchByName(NameSearchRequest request) throws IOException, URISyntaxException {
        HttpGet httpGet = Utils.getRequest(baseURL + request.getEndpoint(), request.getParams(), authorization);
        try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
            return new NameSearchResponse(Utils.getJSONFromEntity(httpResponse.getEntity()));
        }
    }


    /**
     * Get your own profile
     *
     * @param request The request used to get your own profile. Created by {@link SelfProfileRequest#build()} function.
     * @return Instance of {@link SelfProfileResponse}
     * @throws IOException The connection could not be established.
     * @throws URISyntaxException This will most likely be thrown when the baseURL is invalid.
     */
    public SelfProfileResponse getSelfProfile(SelfProfileRequest request) throws IOException, URISyntaxException {
        HttpGet httpGet = Utils.getRequest(baseURL + request.getEndpoint(), request.getParams(), authorization);
        try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
            return new SelfProfileResponse(Utils.getJSONFromEntity(httpResponse.getEntity()));
        }
    }
}