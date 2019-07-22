package com.naveen.latestnewsupdate;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CategoryActivity extends AppCompatActivity {

    //change key to general value so that if not selected general value will be given as input
    //for example if no keyword given make keyword general or make null

    public  static final String KEYWORDS_KEY = "KEYWORDS",LOCATION_KEY = "COUNTRY";
    private String selectedLocation;
    private String givenKeyWords;
    private String selectedCategory;
    public static String url;

    // creating que queue object
    private RequestQueue queue;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        // initializing the queue object
        queue = Volley.newRequestQueue(this);

        //getting extras
        Intent myIntent = getIntent();
        Bundle myExtras = myIntent.getExtras();

        selectedLocation = myExtras.getString(LOCATION_KEY).toString();
        givenKeyWords = myExtras.getString(KEYWORDS_KEY).toString();

        //getting UI elemnts
        final Button btnCategory = (Button)findViewById(R.id.btnCategory);

        View.OnClickListener btnCategoryListener = new View.OnClickListener(){

            //UI reference for radio button
            final RadioButton radBtnGeneral = (RadioButton)findViewById(R.id.radBtnGeneral);
            final RadioButton radBtnBusiness = (RadioButton)findViewById(R.id.radBtnBusiness);
            final RadioButton radBtnEntertainment = (RadioButton)findViewById(R.id.radBtnEntertainment);
            final RadioButton radBtnHealth = (RadioButton)findViewById(R.id.radBtnHealth);
            final RadioButton radBtnScience = (RadioButton)findViewById(R.id.radBtnScience);
            final RadioButton radBtnSports = (RadioButton)findViewById(R.id.radBtnSports);
            final RadioButton radBtnTechnology = (RadioButton)findViewById(R.id.radBtnTecgnology);



            @Override
            public void onClick(View v) {

                //checking which radio button is checked
                if(radBtnGeneral.isChecked()){
                    //get from request api and send data to news list
                    selectedCategory = "general";
                }
                final String API = "&apiKey=9220d9a452ce4cdf9f7ad25b91fb20da";
                final String KEYWORD_SEARCH = "q="+givenKeyWords;
                final String LOCATION = "&country="+selectedLocation;
                final String CATEGORY = "&category="+selectedCategory;
                final String URL_PREFIX = "  https://newsapi.org/v2/top-headlines?";

                url = URL_PREFIX + KEYWORD_SEARCH + LOCATION + CATEGORY + API;

                Intent categoryPageIntent = new Intent(CategoryActivity.this,NewsListActivity.class);
                startActivity(categoryPageIntent);


               /* Log.d("string Request",stringRequest+"");
                queue.add(jsonObjectRequest);
                Log.d("que",queue+"");
*/

            }//end of onclick
        };
        btnCategory.setOnClickListener(btnCategoryListener);
    }//end of on create



}//end of CategoryActivity class