package com.bulovackiy.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Implementation for {@link BigTextClient}
 * that get text from <a href="http://norvig.com/big.txt">BIG_TXT</a> by HTTP GET call
 *
 * @author Eugene Bulovackiy
 */
public class HttpBigTextClient implements BigTextClient {

    public static final Logger LOGGER = LoggerFactory.getLogger(HttpBigTextClient.class);

    private static final String BIG_TXT_URI = "http://norvig.com/big.txt";

    /**
     * Get Big Text from <a href="http://norvig.com/big.txt">BIG_TXT</a> by HTTP GET call
     *
     * Used {@link HttpClient} to connect throw HTTP
     *
     * @return {@link BufferedReader} with Big Text or {@code null} if Big Text not got
     */
    @Override
    public BufferedReader getBigText() {
        try {
            var request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(BIG_TXT_URI))
                    .build();
            var response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofInputStream());

            return new BufferedReader(new InputStreamReader(response.body()));

        } catch (IOException | InterruptedException e) {
            LOGGER.error("Some error occurred.", e);
        }

        return null;
    }
}
