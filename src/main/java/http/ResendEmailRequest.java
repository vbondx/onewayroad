package http;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by v.bondarenko on 22.07.17.
 */
public class ResendEmailRequest {

    public int resendEmailPost() throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBodybody = RequestBody.create(JSON, "{\"login\":\"vbondx@gmail.com\"}");

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://test-maven.cogniance.com/api/v1/sign-up/resend")
                .post(requestBodybody)
                //.addHeader("Authorization", "header value") //Notice this request has header if you don't need to send a header just erase this part
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String responseBody = response.body().string();
        int responseCode = response.code();
        return responseCode; //FIXME: fix this method and create new what returns reponse code int

    }

}
