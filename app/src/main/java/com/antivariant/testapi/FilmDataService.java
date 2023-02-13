package com.antivariant.testapi;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FilmDataService {

    Context context;
    final String url = "http://antivariantum.com/api/film";

    public FilmDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onResponse(List<FilmDataModel> dataList);
        void onError(String message);
    }

    public List<FilmDataModel> getData(VolleyResponseListener volleyResponseListener) {
        List<FilmDataModel> result = new ArrayList<>();

        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray data=response.getJSONArray("data");

                            for(int i=0; i<data.length(); i++) {
                                FilmDataModel film = new FilmDataModel();
                                JSONObject jsonFilm = data.getJSONObject(i);
                                film.setId(jsonFilm.getInt("id"));
                                film.setTitle(jsonFilm.getString("title"));
                                film.setYear(jsonFilm.getInt("year"));
                                film.setActors(jsonFilm.getString("name"));
                                result.add(film);
                            }

                            volleyResponseListener.onResponse(result);

//                            for (FilmDataModel item:result) {
//                                Toast.makeText(context, item.toString(), Toast.LENGTH_SHORT).show();
//                            }

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        volleyResponseListener.onError(error.getMessage());
//                        Toast.makeText(context,
//                                "Error!" + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // Add the request to the RequestQueue.
        RequestQueueSingleton.getInstance(context).addToRequestQueue(request);


        return result;
    }

}

