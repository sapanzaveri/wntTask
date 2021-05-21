package com.wmt.sapan;

import com.wmt.sapan.Response.FetchDetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("?page=1&results=25")
    Call<FetchDetailResponse> getAllDetails();

}
