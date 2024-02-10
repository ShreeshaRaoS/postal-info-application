package ajiet.ise.postalinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PincodeLookupActivity extends AppCompatActivity {

    private EditText editTextPlace;
    private Button btnLookup;
    private TextView tvResult;

    private static final String TAG = "PincodeLookupActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pincode_lookup);

        editTextPlace = findViewById(R.id.editTextPlace);
        btnLookup = findViewById(R.id.btnLookup);
        tvResult = findViewById(R.id.tvResult);

        btnLookup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookupPincode();
            }
        });
    }

    private void lookupPincode() {
        String place = editTextPlace.getText().toString().trim();

        if (place.isEmpty()) {
            Toast.makeText(this, "Please enter a place name", Toast.LENGTH_SHORT).show();
            return;
        }

        // Make API call to retrieve the PIN code based on the place
        String url = "https://api.postalpincode.in/pincode/" + place;
        makeApiCall(url);
    }

    private void makeApiCall(String url) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "API call failed", e);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(PincodeLookupActivity.this, "API call failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseBody = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        processApiResponse(responseBody);
                    }
                });
            }
        });
    }

    private void processApiResponse(String responseBody) {
        Gson gson = new Gson();
        PincodeApiResponse[] apiResponses = gson.fromJson(responseBody, PincodeApiResponse[].class);

        if (apiResponses != null && apiResponses.length > 0) {
            PincodeApiResponse apiResponse = apiResponses[0];
            if (apiResponse.getStatus().equals("Success")) {
                PostOffice[] postOffices = apiResponse.getPostOffice();
                if (postOffices != null && postOffices.length > 0) {
                    String pincode = postOffices[0].getPincode();
                    tvResult.setText("PIN Code: " + pincode);
                } else {
                    tvResult.setText("PIN Code Not Found");
                }
            } else {
                tvResult.setText("PIN Code Not Found");
            }
        } else {
            tvResult.setText("PIN Code Not Found");
        }
    }
}
