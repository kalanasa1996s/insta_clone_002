package com.ijse.instagram_clone.util;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import static org.springframework.security.oauth2.common.exceptions.OAuth2Exception.INVALID_TOKEN;

public class TokenHandler {

    private static JSONObject getJsonObjectFromJwt(String jwtToken) {
        try {

            jwtToken = jwtToken.split(" ")[1];
//        ------------ Decode JWT ------------
            String[] split_string = jwtToken.split("\\.");
            String base64EncodedHeader = split_string[0];
            String base64EncodedBody = split_string[1];

//      ~~~~~~~~~ JWT Header ~~~~~~~
            Base64 base64Url = new Base64(true);

//      ~~~~~~~~~ JWT Body ~~~~~~~~~
            String body = new String(base64Url.decode(base64EncodedBody));

            return new JSONObject(body);
        } catch (IndexOutOfBoundsException | IllegalArgumentException |
                IllegalStateException | JSONException | NullPointerException n) {
            // token is invalid or user is not found if hits here.
            throw new CustomException(400, INVALID_TOKEN);
        }
    }

    public static String getEmailFromToken(String jwtToken) {
        JSONObject tokenJson = getJsonObjectFromJwt(jwtToken);
        try {
            return tokenJson.getString("user_name");
        } catch (JSONException e) {
            throw new CustomException(500, "Error while converting the token");
        }
    }
}
