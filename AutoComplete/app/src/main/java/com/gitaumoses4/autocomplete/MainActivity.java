package com.gitaumoses4.autocomplete;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

/**
 * Created by root on 3/12/17.
 */

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView actv;
    private MultiAutoCompleteTextView mactv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        String[] countries = getResources()
                .getStringArray(
                        R.array.list_of_countries
                );
        ArrayAdapter adapter = new ArrayAdapter(this
                , android.R.layout.simple_list_item_1, countries);

        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        mactv = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);

        actv.setAdapter(adapter);
        mactv.setAdapter(adapter);

        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
