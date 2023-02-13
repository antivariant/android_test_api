package com.antivariant.testapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView filmsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FilmDataService data = new FilmDataService(MainActivity.this);
        data.getData(new FilmDataService.VolleyResponseListener() {
            @Override
            public void onResponse(List<FilmDataModel> dataList) {
                Toast.makeText(MainActivity.this, dataList.toString(), Toast.LENGTH_SHORT).show();
                filmsRecycler = findViewById(R.id.filmsRecycler);
                LinearLayoutManager lmanager=new LinearLayoutManager(MainActivity.this);
                filmsRecycler.setLayoutManager(lmanager);

                FilmListAdapter adapter = new FilmListAdapter(dataList);
                filmsRecycler.setAdapter(adapter);

            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });


    }
}