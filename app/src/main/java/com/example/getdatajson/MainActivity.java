package com.example.getdatajson;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.getdatajson.Model.myModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    Button mButton;
    Intent mIntent  ;
    String name_album,url;

    //public static ArrayList<myModel> mList;

    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.text_search);
        mButton = findViewById(R.id.button_GET);

        //mList = new ArrayList<myModel>();

        url = "http://nopbai.live/data/data.json";
        mEditText.setText(url);
        //getDataJSON();
        mIntent = new Intent(this, ShowIMG.class);


        mEditText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                url=mEditText.getText().toString();

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                url=mEditText.getText().toString();

            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("duy", "onClick: "+mEditText.getText());
                mIntent.putExtra("url", url);
                startActivity(mIntent);

            }
        });
    }

//    private void getDataJSON() {
//        mRequestQueue = Volley.newRequestQueue(this);
//
//        JsonObjectRequest mRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            name_album = response.getString("name");
//                            mIntent.putExtra("name_album", name_album);
//                            JSONArray mJSONArray = response.getJSONArray("images");
//                            Log.d("hello", name_album);
//
//                            //Toast.makeText(MainActivity.this, name_album , Toast.LENGTH_SHORT).show();
//                            mList.clear();
//                            for(int i=0;i<mJSONArray.length();i++){
//                                JSONObject mJSONObject = mJSONArray.getJSONObject(i);
//
//                                String name = mJSONObject.getString("name");
//                                String description= mJSONObject.getString("description");
//
//                                mList.add(new myModel(name, description));
//
//                                Log.d("hello", name +" " + description);
//                                //Toast.makeText(MainActivity.this, name +" " + description, Toast.LENGTH_SHORT).show();
//                            }
//
////                            mIntent.putExtra("myList", mList);
//                        } catch (JSONException mE) {
//                            mE.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, "Error !!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mRequestQueue.add(mRequest);
//    }

}
