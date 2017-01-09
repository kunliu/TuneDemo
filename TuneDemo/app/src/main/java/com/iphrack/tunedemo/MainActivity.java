package com.iphrack.tunedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity  implements Callback{

    CharacterAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.character_list);

        loadCharacters();
    }

    private void loadCharacters(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://iphrack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TuneDemoService service = retrofit.create(TuneDemoService.class);
        Call<Object> call =  service.listCharacters();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call call, Response response) {
        final ArrayList list = parseCharacterListFromResponse(response);
        adapter = new CharacterAdapter(this,0,list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.d("ddv",t.toString());
    }

    public interface TuneDemoService {
        @GET("tune_demo/")
        Call<Object> listCharacters();
    }

    private ArrayList parseCharacterListFromResponse(Response response){

        Gson gson = new Gson();
        ArrayList list = new ArrayList<>();

        LinkedTreeMap map = (LinkedTreeMap) response.body();
        JsonArray arr = gson.toJsonTree(map.get("characters")).getAsJsonArray();

        for(int i=0;i<arr.size();i++){
            JsonObject obj = (JsonObject) arr.get(i);
            Character character = gson.fromJson(obj,Character.class);
            ((ArrayList) list).add(character);
        }
        return list;
    }
}
