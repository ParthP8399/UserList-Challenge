package com.example.userlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView=findViewById(R.id.recyclerview_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolder jsOnPLaceHolder = retrofit.create(JSONPlaceHolder.class);
       Call<UserList> call= jsOnPLaceHolder.getUsersList();
       call.enqueue(new Callback<UserList>() {
           @Override
           public void onResponse(Call<UserList> call, Response<UserList> response) {
               if (!response.isSuccessful()) {
                    Log.e("Response Code: ", String.valueOf(response.code()));
                    Log.e(" temp : ",String.valueOf(response.body()));
                    return;
                }
               UserList posts=response.body();
                recyclerView.setAdapter(new UserAdapter(getApplicationContext(), posts.data));

           }

           @Override
           public void onFailure(Call<UserList> call, Throwable t) {
               Log.e("Code: ",t.getMessage());
           }
       });


    }
}