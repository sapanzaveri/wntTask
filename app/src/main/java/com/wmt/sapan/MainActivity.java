package com.wmt.sapan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.wmt.sapan.Adapter.DetailsAdapter;
import com.wmt.sapan.Response.DetailsResponse;
import com.wmt.sapan.Response.FetchDetailResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_mwtdeaties;
    List<DetailsResponse> detailsResponseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        GetDetails();
    }


    private void init() {
        rv_mwtdeaties = findViewById(R.id.rv_wntDetails);
    }

    private void GetDetails() {
        rv_mwtdeaties.setHasFixedSize(true);
        rv_mwtdeaties.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        Call<FetchDetailResponse> call = RetrofitClient.getInstance().getApi().getAllDetails();
        call.enqueue(new Callback<FetchDetailResponse>() {
            @Override
            public void onResponse(Call<FetchDetailResponse> call, Response<FetchDetailResponse> response) {
                if (response.isSuccessful()){
                    detailsResponseList = response.body().getDetailsResponseList();
                    rv_mwtdeaties.setAdapter(new DetailsAdapter(getApplicationContext(),detailsResponseList));
                }
            }

            @Override
            public void onFailure(Call<FetchDetailResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}