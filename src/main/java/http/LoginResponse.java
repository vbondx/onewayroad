package http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by v.bondarenko on 22.07.17.
 */
@JsonSerialize
public class LoginResponse {

   public LoginResponse (String mustConfirmSafetyInfo){
        this.mustConfirmSafetyInfo = mustConfirmSafetyInfo;
       }

    @JsonProperty
    private String mustConfirmSafetyInfo;

    public String getMustConfirmSafetyInfo() {
        return mustConfirmSafetyInfo;
    }



}
