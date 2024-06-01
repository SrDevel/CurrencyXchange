package service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiServiceImpl implements ApiService {
    private String url;
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;

    public ApiServiceImpl(String url) {
        this.url = url;
        connect();
    }

    public void connect() {
        try {

            client = HttpClient.newHttpClient();
            request = HttpRequest.newBuilder()
                    .uri(java.net.URI.create(url))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HttpResponse<String> getData() {
        return response;
    }
}
