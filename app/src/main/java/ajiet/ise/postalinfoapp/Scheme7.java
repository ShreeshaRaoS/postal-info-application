package ajiet.ise.postalinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class Scheme7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme7);

        MaterialButton fabButton1 = findViewById(R.id.fabButton1);

        MaterialButton fabButton2 = findViewById(R.id.fabButton2);
        MaterialButton fabButton = findViewById(R.id.fabButton);
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scheme7.this, ajiet.ise.postalinfoapp.activities.calculator.CalculatorRD.class);
                startActivity(intent);
            }
        });

        fabButton2.setOnClickListener(new View.OnClickListener() {
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