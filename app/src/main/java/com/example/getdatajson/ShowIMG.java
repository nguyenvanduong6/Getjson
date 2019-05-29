package com.example.getdatajson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.getdatajson.Adapter.myAdapter;
import com.example.getdatajson.Model.myModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowIMG extends AppCompatActivity {
    ViewPager mViewPager;
    TextView album_name;
    String name_album,url;

    RequestQueue mRequestQueue;
    ArrayList<myModel> mList;


    myAdapter mAdapter;

    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_img);

        album_name = findViewById(R.id.album_name);
        mViewPager = findViewById(R.id.viewpager);

        mList = new ArrayList<myModel>();

        mIntent = getIntent();
        url=mIntent.getStringExtra("url");
        getDataJSON();

        album_name.setText(mIntent.getStringExtra("name_album"));

////        Log.d("out_site_data",  MainActivity.mList.get(2).getName()+" "+ MainActivity.mList.get(2).getDescription());
        mAdapter = new myAdapter();
//        mAdapter.notifyDataSetChanged();
////
//        mViewPager.setAdapter(mAdapter);

    }
    void getDataJSON() {
        mRequestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest mRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            name_album = response.getString("name");
                            mIntent.putExtra("name_album", name_album);
                            JSONArray mJSONArray = response.getJSONArray("images");
                            Log.d("hello", name_album);

                            //Toast.makeText(MainActivity.this, name_album , Toast.LENGTH_SHORT).show();
                            mList.clear();
                            for(int i=0;i<mJSONArray.length();i++){
                                JSONObject mJSONObject = mJSONArray.getJSONObject(i);

                                String name = mJSONObject.getString("name");
                                String description= mJSONObject.getString("description");

                                mList.add(new myModel(name, description));

                                Log.d("hello", name +" " + description);
                                //Toast.makeText(MainActivity.this, name +" " + description, Toast.LENGTH_SHORT).show();
                            }
                            album_name.setText(mIntent.getStringExtra("name_album"));

                            //        Log.d("out_site_data",  MainActivity.mList.get(2).getName()+" "+ MainActivity.mList.get(2).getDescription());
                            //mAdapter = new myAdapter( mList,this);
                            mAdapter.setmModelList(mList);
                            mAdapter.setmContext(ShowIMG.this);
                            mAdapter.notifyDataSetChanged();
                            mViewPager.setAdapter(mAdapter);
                        } catch (JSONException mE) {
                            mE.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ShowIMG.this, "Error !!!", Toast.LENGTH_SHORT).show();
            }
        });
        mRequestQueue.add(mRequest);
    }


}
