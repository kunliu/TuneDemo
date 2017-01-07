package com.iphrack.tunedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

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

        adapter = new CharacterAdapter(this,0);
        listView.setAdapter(adapter);

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
        Log.d("ddv",response.body().toString());
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.d("ddv",t.toString());
    }

    public interface TuneDemoService {
        @GET("tune_demo/")
        Call<Object> listCharacters();
    }
}
