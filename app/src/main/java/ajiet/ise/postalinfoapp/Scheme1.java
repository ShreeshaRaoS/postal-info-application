package ajiet.ise.postalinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.button.MaterialButton;

public class Scheme1 extends AppCompatActivity {

    MaterialButton fabButton;
    MaterialButton fabButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme1);

        fabButton = findViewById(R.id.fabButton);
        fabButton1 = findViewById(R.id.fabButton1);

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the PDF file for download
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.indiapost.gov.in/VAS/DOP_PDFFiles/form/Accountopening.pdf")); // Replace with your PDF file URL
                startActivity(intent);
            }
        });

        fabButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the webpage in a browser
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.indiapost.gov.in/Financial/Pages/Content/Post-Office-Saving-Schemes.aspx"));
                startActivity(intent);
            }
        });
    }
}
