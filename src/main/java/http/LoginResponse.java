package http;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.SerializedName;

/**
 * Created by v.bondarenko on 22.07.17.
 */

public class LoginResponse {
    @SerializedName("mustConfirmSafetyInfo")
    public boolean mustConfirmSafetyInfo;

    public boolean isMustConfirmSafetyInfo() {
        return mustConfirmSafetyInfo;
    }
}
