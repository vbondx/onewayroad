package http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import com.google.gson.Gson;
import sun.rmi.runtime.Log;

import java.io.IOException;


public class LoginRequest {

    public static void main(String[] args) throws IOException {


        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, "{\"login\":\"maventests+patient+1@gmail.com\",\"password\":\"Password11\"}\n");

        Request request = new Request.Builder()
                .url("https://test-maven.cogniance.com/api/v1/login")
                .post(requestBody)
                //.addHeader("Authorization", "header value")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String responseBody = response.body().string();
        System.out.println(response.code());
        System.out.println(responseBody);
        LoginResponse loginResponse = new ObjectMapper().readValue(responseBody,LoginResponse.class);
        System.out.println(loginResponse.getMustConfirmSafetyInfo());
    }
}
