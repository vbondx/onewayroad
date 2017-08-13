package http;

import okhttp3.*;

import java.io.IOException;

public class AddItemRequest {
    public void sendAddItemRequest() throws IOException {

        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, "{\"cookie\":\"mvszfupokbicngxlrtwy\",\"product_id\":553388056,\"quantity\":\"1\"}");

        Request request = new Request.Builder()
                .url("https://my.prom.ua/api/_/mobile/v1/add_item")
                .post(requestBody)
                //.addHeader("Authorization", "header value")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String responseBody = response.body().string();

    }
}
