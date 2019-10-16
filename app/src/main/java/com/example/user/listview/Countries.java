package com.example.user.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Countries extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv2;
    TextView tv1, tv2;
    int x2;
    String [][] country = {{ "Israel", "Japan", "China", "India", "Thailand", "Russia", "Vietnam" },{"Germany", "Italy", "France", "Greece", "Spain", "Sweden", "Norway"},{"Egypt", "South Africa", "Ethiopia", "Morocco", "Nigeria", "Algeria", "Sudan"},{"Argentina", "Brazil", "Chile", "peru", "Colombia", "U.S.A", "Canada"}};
    String [][] ccp = {{"Jerusalem", "Tokyo", "Beijing", "New Delhi", "Bangkok","Moscow","Hanoi", "Berlin", "Rome", "Paris", "Athens", "Madrid","Stockholm","Oslo", "Cairo", "Cape Town", "Addis Ababa", "Rabat", "Abuja", "Algiers", "Khartoum", "Buenos Aires", "Brasilia", "Santiago", "Lima", "Bogota", "Washington D.C", "Ottawa" },
            {"8,712,000", "126,800,000", "1,386,000,000", "1,339,000,000", "69,040,000","142,100,000", "95,000,000", "82,790,000", "60,590,000", "66,770,000", "10,770,000", "46,570,000","10,300,000","5,300,000", "97,550,000", "56,720,000", "105,000,000", "35,740,000", "190,900,000", "42,200,000", "41,600,000", "44,270,000", "209,300,000", "18,050,000", "32,170,000", "49,070,000", "327,100,000", "37,600,000" }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        lv2 = (ListView) findViewById(R.id.lv2);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        Intent gi = getIntent();
        x2 = gi.getIntExtra("continent", -1);

        lv2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv2.setOnItemClickListener(this);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,country[x2]);
        lv2.setAdapter(adp);



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tv1.setText("capital city: "+ ccp[0][x2*7+position]);
        tv2.setText("population: "+ ccp[1][x2*7+position]);
    }

    public void back(View view) {
        finish();
    }
}
