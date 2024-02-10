package ajiet.ise.postalinfoapp;

import com.google.gson.annotations.SerializedName;

public class ZippopotamApiResponse {
    @SerializedName("post code")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

}
