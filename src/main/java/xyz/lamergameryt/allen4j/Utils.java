package xyz.lamergameryt.allen4j;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Scanner;

public class Utils {
    /**
     * Creates an instance of HttpGet containing the endpoint, the parameters and user authorization.
     *
     * @param url The endpoint to send the GET request to.
     * @param parameters The parameters included in the GET request.
     * @param authorization The authorization token of the user.
     * @return The GET Request object.
     * @throws URISyntaxException This will most likely be thrown when the baseURL is invalid.
     */
    public static HttpGet getRequest(String url, HashMap<String, String> parameters, String authorization) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(url);
        for (String s : parameters.keySet()) {
            builder.addParameter(s, parameters.get(s));
        }
        HttpGet httpGet = new HttpGet(builder.build());
        httpGet.addHeader("Authorization", "Bearer " + authorization);
        return httpGet;
    }

    /**
     * Read the response received from the API and converts it into a JSONObject object.
     *
     * @param entity The response received from the API.
     * @return The JSONObject contains the parsed json text.
     * @throws IOException The connection could not be established.
     */
    public static JSONObject getJSONFromEntity(HttpEntity entity) throws IOException {
        Scanner sc = new Scanner(entity.getContent());
        StringBuilder json = new StringBuilder();
        while (sc.hasNextLine()) {
            json.append(sc.nextLine());
        }
        return new JSONObject(json.toString());
    }
}
