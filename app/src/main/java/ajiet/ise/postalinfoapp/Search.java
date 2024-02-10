package ajiet.ise.postalinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.AsyncTask;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class Search extends AppCompatActivity {

    private EditText pinCodeEditText;
    private Button searchButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        pinCodeEditText = findViewById(R.id.pinCodeEditText);
        searchButton = findViewById(R.id.searchButton);
        resultTextView = findViewById(R.id.resultTextView);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pinCode = pinCodeEditText.getText().toString().trim();
                if (!pinCode.isEmpty()) {
                    searchPostOffices(pinCode);
                }
            }
        });
    }

    private void searchPostOffices(String pinCode) {
        try {
            String encodedPinCode = URLEncoder.encode(pinCode, "UTF-8");
            String apiUrl = "https://api.postalpincode.in/pincode/" + encodedPinCode;
            new FetchPostOfficesTask().execute(apiUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    private class FetchPostOfficesTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            String response = "";
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }

                bufferedReader.close();
                inputStream.close();
                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            displayResult(response);
        }
    }

    private void displayResult(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String status = jsonObject.getString("Status");
            if (status.equals("Success")) {
                JSONArray postOfficeArray = jsonObject.getJSONArray("PostOffice");
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < postOfficeArray.length(); i++) {
                    JSONObject postOffice = postOfficeArray.getJSONObject(i);
                    String name = postOffice.getString("Name");
                    String district = postOffice.getString("District");
                    String state = postOffice.getString("State");
                    String pinCode = postOffice.getString("Pincode");
                    result.append("Name: ").append(name).append("\n");
                    result.append("District: ").append(district).append("\n");
                    result.append("State: ").append(state).append("\n");
                    result.append("Pin Code: ").append(pinCode).append("\n\n");

                    // Make post office details clickable
                    SpannableString spannableString = new SpannableString(result.toString());
                    ClickableSpan clickableSpan = new ClickableSpan() {
                        @Override
                        public void onClick(View view) {
                            try {
                                if (postOffice.has("Latitude") && postOffice.has("Longitude")) {
                                    String latitude = postOffice.getString("Latitude");
                                    String longitude = postOffice.getString("Longitude");
                                    showLocationOnMap(latitude, longitude);
                                } else {
                                    // Handle missing latitude or longitude
                                    // You can show an error message or handle the case as per your requirement
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    int start = result.indexOf(pinCode);
                    int end = start + pinCode.length();
                    spannableString.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    resultTextView.setText(spannableString);
                    resultTextView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            } else {
                resultTextView.setText("No post offices found for the provided pin code.");
            }
        } catch (JSONException e) {
            e.printStackTrace();
            resultTextView.setText("Error parsing response.");
        }
    }


    private void showLocationOnMap(String latitude, String longitude) {
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude + "(Post Office)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            // Google Maps app is not installed, show error or open web browser
            Uri mapsWebUri = Uri.parse("https://maps.google.com/?q=" + latitude + "," + longitude);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, mapsWebUri);
            startActivity(webIntent);
        }
    }


}