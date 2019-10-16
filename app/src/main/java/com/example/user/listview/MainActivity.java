package com.example.user.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @author Hadar Malul
 * @since 16.10.19
 * On this activity you need to choose one continent out of 4 .
 * the continent you chose will be shown as a toast on the screen
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    String[] continent = {"Asia", "Europe", "Africa", "America"};
    int x = 10;

    /**
     * lv is a List view java component
     * The continent array contains the continents
     * x has the position of the chosen continent
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);

        /**
         * Connecting between the java component to the xml component
         */

        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);

        /**
         * Setting features to the list view
         */

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, continent);
        lv.setAdapter(adp);

        /**
         * The adapter connects between the array and the list view
         */

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, ""+ continent[position], Toast.LENGTH_SHORT).show();
        x = position;

        /**
         * the function starts when you click on a continent
         * @param position is the position of the chosen continent
         * @return the chosen continent is shown on the screen as a toast
         */

    }

    public void next(View view) {
        if (x != 10) {
            Intent si = new Intent(this, Countries.class);
            si.putExtra("continent", x);
            startActivity(si);
        }
        else {
            Toast.makeText(this,"please choose a continent", Toast.LENGTH_SHORT ).show();
        }

        /**
         *  the function starts when the button next is clicked
         *  if the user choose a continent the screen moves to yhe next activity with the position
         *  else a toast is shown on the screen saying you have to choose a continent
         */
    }
}
