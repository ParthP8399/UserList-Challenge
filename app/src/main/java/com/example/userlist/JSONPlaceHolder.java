package com.example.userlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolder {

    @GET("api/users?page=2")
    Call<UserList> getUsersList();

}
