package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

public class MainActivity extends AppCompatActivity {

    private final String json_url = "https://data.covid19india.org/state_district_wise.json";
    RequestQueue requestQueue;
    ListView result;
    List<Model> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);

        result=findViewById(R.id.result);
        modelList=new ArrayList<>();

        // Casts results into the TextView found within the main layout XML with id jsonData


        StringRequest arrayreq=new StringRequest(Request.Method.GET,json_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object=new JSONObject(response);
                    Iterator<String> keys=object.keys();
                    while(keys.hasNext())
                    {
                        String key=keys.next();
                        JSONObject obj1=object.getJSONObject(key);
                        JSONObject obj2=obj1.getJSONObject("districtData");
                        Iterator<String> subkeys=obj2.keys();
                        while(subkeys.hasNext())
                        {
                            String subkey=subkeys.next();
                            JSONObject obj3=obj2.getJSONObject(subkey);
                            String active=obj3.getString("active");
                            String confirmed=obj3.getString("confirmed");
                            String deceased=obj3.getString("deceased");
                            String recovered=obj3.getString("recovered");
                            JSONObject obj4=obj3.getJSONObject("delta");
                            String dconfirmed=obj4.getString("confirmed");
                            String ddeceased=obj4.getString("deceased");
                            String drecovered=obj4.getString("recovered");
                            Model model=new Model(key,subkey,active,confirmed,deceased,recovered,dconfirmed,ddeceased,drecovered);
                            modelList.add(model);
                        }
                        ListAdapter listAdapter=new ListAdapter(getApplicationContext(),modelList);
                        result.setAdapter(listAdapter);

                        Log.e("Over","over");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley",error.getMessage());


            }
        });
        requestQueue.add(arrayreq);

    }

}







