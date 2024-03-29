package com.naveen.latestnewsupdate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private String location;
    private String keyWords;

    private final String spinnerUSA = "USA";
    private final String spinnerIndia = "India";
    private final String spinnerChina = "China";
    private final String spinnerCanada = "Canada";
    private final String spinnerAustralia = "Australia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI reference
        final Button btnMainPage = (Button)findViewById(R.id.btnMainpage);

        //add event handler
        View.OnClickListener btnMainPageListener = new View.OnClickListener() {

            //UI reference for input text box and radio button
            final EditText txtKeyWord = (EditText)findViewById(R.id.txtKeyWord);
            final Spinner txtLocation = (Spinner)findViewById(R.id.txtLocation);

            @Override
            public void onClick(View v) {

                //Intent
                Intent mainPageIntent = new Intent(MainActivity.this, CategoryActivity.class);

                //get user input
                location = txtLocation.getSelectedItem().toString();
                keyWords = txtKeyWord.getText().toString();

                switch(location) {
                    case spinnerUSA:
                        mainPageIntent.putExtra(CategoryActivity.LOCATION_KEY,"us");
                        break;
                    case spinnerIndia:
                        mainPageIntent.putExtra(CategoryActivity.LOCATION_KEY,"in");
                        break;
                    case spinnerChina:
                        mainPageIntent.putExtra(CategoryActivity.LOCATION_KEY,"cn");
                        break;
                    case spinnerCanada:
                        mainPageIntent.putExtra(CategoryActivity.LOCATION_KEY,"ca");
                        break;
                    case spinnerAustralia:
                        mainPageIntent.putExtra(CategoryActivity.LOCATION_KEY,"au");
                        break;
                    default:
                        //change the default to something meaningful
                        //this is for testing purpose
                        mainPageIntent.putExtra(CategoryActivity.LOCATION_KEY,"NA");
                }

                mainPageIntent.putExtra(CategoryActivity.KEYWORDS_KEY,keyWords);
                //start activity
                startActivity(mainPageIntent);

            }//end of onclick
        };

        btnMainPage.setOnClickListener(btnMainPageListener);

    }// end of on create
}//end of main class
