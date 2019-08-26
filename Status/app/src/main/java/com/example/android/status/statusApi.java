package com.example.android.status;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface statusApi {
    @GET("status_events")
    Call<List<obj>> getevents(@Query("status") String status_type);
}
