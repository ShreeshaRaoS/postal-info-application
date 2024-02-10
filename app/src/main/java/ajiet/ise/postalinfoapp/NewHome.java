package ajiet.ise.postalinfoapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;


import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import ajiet.ise.postalinfoapp.databinding.ActivityNewHomeBinding;

public class NewHome extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    private AppBarConfiguration myAppBarConfiguration;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    viewPagerAdapter viewPagerAdapter;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_home);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Postal Info");

        viewPagerAdapter = new viewPagerAdapter(getSupportFragmentManager());

        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(viewPagerAdapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.fabButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewHome.this, Search.class);
                startActivity(intent);
            }
        });


        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });

    }
    private void showPopupWindow() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.popup_menu, null);
        dialogBuilder.setView(dialogView);

        TextView profileTextView = dialogView.findViewById(R.id.profileTextView);
        TextView aboutTextView = dialogView.findViewById(R.id.aboutTextView);
        TextView locationTextView = dialogView.findViewById(R.id.locationTextView);
        TextView pincodeFind = dialogView.findViewById(R.id.pincodeFinder);


        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setGravity(Gravity.TOP);
        alertDialog.show();

        profileTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewHome.this, Profile1.class));
                alertDialog.dismiss();
            }
        });

        aboutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewHome.this, About.class));
                alertDialog.dismiss();
            }
        });


        locationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewHome.this, Search.class));
                alertDialog.dismiss();
            }
        });

        pincodeFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.indiapost.gov.in/vas/pages/findpincode.aspx";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

    }


}