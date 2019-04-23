package com.example.autism.sakil.autism;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class CareCenterDetailsActivity extends AppCompatActivity {
    private TextView nameText,contactText,emailText,addressText,aboutText;
    private ArrayList<String> details = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_center_details);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        updateDetails();

    }
    private void init()
    {
        nameText = findViewById(R.id.nameView);
        contactText = findViewById(R.id.contactView);
        emailText = findViewById(R.id.emailView);
        addressText = findViewById(R.id.addressView);
        aboutText = findViewById(R.id.aboutView);
        details = (ArrayList<String>)getIntent().getSerializableExtra("details");
    }
    private void updateDetails()
    {
        nameText.setText(details.get(0));
        contactText.setText("CONTACT:\t"+details.get(1));
        emailText.setText("\nEMAIL:\t"+details.get(2));
        addressText.setText("\nADDRESS:\n"+details.get(3));
        aboutText.setText("ABOUT:\n"+details.get(4));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
