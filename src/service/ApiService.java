package service;

import java.net.http.HttpResponse;

public interface ApiService {
    HttpResponse<String> getData();
}
