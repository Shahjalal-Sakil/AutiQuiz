package com.example.autism.sakil.autism;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CareCenterActivity extends AppCompatActivity {
    ListView careCenterList;
    private CareCenterCollection careCenterCollection;
    ArrayList<String> newData;

    MySimpleArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_center);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        careCenterCollection.initQuestions(getApplicationContext());
        updateList();
        careCenterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<String> rowdetails = new ArrayList<>();;
                rowdetails.add(careCenterCollection.getName(position));
                rowdetails.add(careCenterCollection.getContact(position));
                rowdetails.add(careCenterCollection.getEmail(position));
                rowdetails.add(careCenterCollection.getAddress(position));
                rowdetails.add(careCenterCollection.getAbout(position));
                Intent intent = new Intent(getApplicationContext(),CareCenterDetailsActivity.class);
                intent.putExtra("details",rowdetails);
                startActivity(intent);
            }
        });


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

    private void init()
    {
        careCenterList = findViewById(R.id.careListView);
        careCenterCollection = new CareCenterCollection();
        newData = new ArrayList<>();

    }

    private void updateList()
    {
        int itemNum =0;
        while(itemNum<careCenterCollection.getLength() ){
            newData.add(careCenterCollection.getName(itemNum));

            itemNum++;
        }
        adapter = new MySimpleArrayAdapter(this, newData);
        careCenterList.setAdapter(adapter);
    }
}

class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;

    public MySimpleArrayAdapter(Context context, ArrayList<String> values) {
        super(context, R.layout.row_style, values);

        this.context = context;
        this.values = values;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row_style, parent, false);

        TextView textView =  rowView.findViewById(R.id.nameLabel);

        // Setting the text to display
        textView.setText(values.get(position));

        return rowView;
    }
}
